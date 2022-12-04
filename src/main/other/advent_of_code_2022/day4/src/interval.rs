pub struct Interval {
    start: u32,
    end: u32,
}

impl Interval {
    pub fn from_string(input: &str) -> Interval {
        let mut iter = input.split('-');
        Interval {
            start: iter.next().unwrap().parse::<u32>().unwrap(),
            end: iter.next().unwrap().parse::<u32>().unwrap(),
        }
    }

    pub fn contains_fully(&self, other: &Interval) -> bool {
        self.start <= other.start && self.end >= other.end
    }

    pub fn contains_part(&self, other: &Interval) -> bool {
        // Contains a part
        self.start <= other.start && self.end >= other.start ||
        self.start <= other.end && self.end >= other.end ||
        // Contains other fully
        self.contains_fully(other) ||
        // Is fully contained
        other.contains_fully(self)
    }
}
