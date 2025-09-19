class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        ans = 0
        l = 0
        dup = set()
        for r in range (len(s)):
            c = s[r]
            while c in dup and l <= r:
                dup.remove(s[l])
                l += 1
            ans = max(r - l + 1, ans)
            dup.add(c)
        
        return ans