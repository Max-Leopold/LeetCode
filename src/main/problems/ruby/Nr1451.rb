def arrange_words(text)
  text.downcase.split(" ").sort_by { |w| w.size }.join(" ").capitalize
end
