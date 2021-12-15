require 'digest'

module Cacheable

    CACHE = {}

    def cache(method, lambda)
        proxy = Module.new do 
            CACHE[method] = {a: 1}
            define_method(method) do |*args|
                key = lambda.call *args
                return CACHE[method][key] if CACHE[method].key? key
                result = super *args
                CACHE[method][key] = result
            end
        end
        self.prepend proxy
    end

    def hashkey(*args)
        Digest::MD5.hexdigest(Marshal::dump(args))
    end

end