use std::cmp::Ordering;
use std::str::Chars;

use itertools::Itertools;

#[derive(Debug, Clone)]
pub enum PackageData {
    Value(usize),
    List(Vec<PackageData>),
}

#[derive(Debug)]
pub struct Package {
    data: PackageData,
}

impl ToString for PackageData {
    fn to_string(&self) -> String {
        match self {
            PackageData::Value(v) => format!("{v}"),
            PackageData::List(l) => format!("[{}]", l.iter().map(|p| p.to_string()).join(",")),
        }
    }
}

impl PartialOrd for PackageData {
    fn partial_cmp(&self, other: &Self) -> Option<std::cmp::Ordering> {
        Some(self.cmp(other))
    }
}

impl Ord for PackageData {
    fn cmp(&self, other: &Self) -> Ordering {
        match (self, other) {
            (PackageData::Value(v1), PackageData::Value(v2)) => v1.cmp(v2),
            (PackageData::Value(_), PackageData::List(_)) => {
                return PackageData::List(vec![self.clone()]).cmp(other);
            }
            (PackageData::List(_), PackageData::Value(_)) => {
                return self.cmp(&PackageData::List(vec![other.clone()]));
            }
            (PackageData::List(l1), PackageData::List(l2)) => {
                let mut iter = l1.iter().zip_longest(l2);
                while let Some(elem) = iter.next() {
                    match elem {
                        itertools::EitherOrBoth::Both(x, y) => {
                            if x == y {
                                continue;
                            }
                            return x.cmp(y);
                        }
                        itertools::EitherOrBoth::Left(_) => return Ordering::Greater,
                        itertools::EitherOrBoth::Right(_) => return Ordering::Less,
                    }
                }
                return Ordering::Equal;
            }
        }
    }
}

impl PartialEq for PackageData {
    fn eq(&self, other: &Self) -> bool {
        match (self, other) {
            (PackageData::Value(v1), PackageData::Value(v2)) => v1 == v2,
            (PackageData::Value(_), PackageData::List(_)) => {
                &PackageData::List(vec![self.clone()]) == other
            }
            (PackageData::List(_), PackageData::Value(_)) => {
                self == &PackageData::List(vec![other.clone()])
            }
            (PackageData::List(l1), PackageData::List(l2)) => {
                let mut iter = l1.iter().zip_longest(l2);
                while let Some(elem) = iter.next() {
                    match elem {
                        itertools::EitherOrBoth::Both(x, y) => {
                            if x == y {
                                continue;
                            }
                            return x.eq(y);
                        }
                        itertools::EitherOrBoth::Left(_) => return false,
                        itertools::EitherOrBoth::Right(_) => return false,
                    }
                }
                return true;
            }
        }
    }
}

impl Eq for PackageData {}

impl Package {
    pub fn from_chars(chars: &mut Chars) -> PackageData {
        let mut package_data = PackageData::List(Vec::new());
        let mut num_string = String::new();
        while let Some(c) = chars.next() {
            match c {
                ',' => {
                    if let PackageData::List(ref mut list) = package_data {
                        if !num_string.is_empty() {
                            list.push(PackageData::Value(num_string.parse::<usize>().unwrap()))
                        }
                        num_string = String::new();
                    }
                }
                '[' => {
                    if let PackageData::List(ref mut list) = package_data {
                        list.push(Package::from_chars(chars));
                    }
                }
                ']' => {
                    if let PackageData::List(ref mut list) = package_data {
                        if !num_string.is_empty() {
                            list.push(PackageData::Value(num_string.parse::<usize>().unwrap()))
                        }
                    }
                    return package_data;
                }
                c => {
                    num_string.push(c);
                }
            }
        }

        package_data
    }
}
