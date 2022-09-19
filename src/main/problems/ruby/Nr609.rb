# @param {String[]} paths
# @return {String[][]}
def find_duplicate(paths)
  hash = Hash.new { [] }
  paths.each do |path|
    dir_name, *files = path.split(" ")
    files.each do |file|
      file_name, content = file[...-1].split("(")
      hash[content] += [dir_name + "/" + file_name]
    end
  end

  hash.values.select { |arr| arr.size > 1 }
end
