---
--- Generated by EmmyLua(https://github.com/EmmyLua)
--- Created by Administrator.
--- DateTime: 2020/11/18 12:13
---
local trueCode = redis.call('get', KEYS[1])
if trueCode == ARGV[1] then
    redis.call('del',KEYS[1])
    return 0
else
    return 4
end