reports = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r")
  .map(&:chomp)
  .map { |line| line.split(" ").map { _1.to_i } }

def safe_report?(report)
  diffs = report.each_cons(2).map { |l, r| r - l }
  diffs.all? { _1.abs.between?(1, 3) } && diffs.minmax.reduce(:*) > 0
end

pp reports.select { safe_report?(_1) }.count