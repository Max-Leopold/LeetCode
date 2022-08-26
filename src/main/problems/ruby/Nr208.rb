class Trie

    class TrieNode

        attr_reader :chars

        def initialize()
            @chars = {}
        end

        def add_char(char)
            @chars[char] ||= TrieNode.new
        end

        def get_char(char)
            return @chars.values if char == '.'

            [@chars[char]]
        end

        def is_end?
            !!@chars['*']
        end
    end

    def initialize()
        @root = TrieNode.new
    end

    def insert(word)
        current = @root
        word.each_char do |char|
            current = current.add_char(char)
        end
        current.add_char('*')
    end

    def search(word)
        end_nodes = get_ending_nodes(word)
        end_nodes.any? { |node| node.is_end? }
    end

    def starts_with(prefix)
        end_nodes = get_ending_nodes(prefix)
        end_nodes.size > 0
    end

    private

    def get_ending_nodes(prefix)
        current = [@root]
        prefix.each_char do |char|
            current = current.map do |node|
                node.get_char(char)
            end.flatten.compact
        end
        current
    end
end