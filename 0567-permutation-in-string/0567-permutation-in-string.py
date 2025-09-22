class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        freq1 = Counter(s1)
        freq2 = Counter(s2[:len(s1)]) #s1의 길이까지만 저장

        if freq1 == freq2: return True

        for i in range(1, len(s2) - 1 - len(s1) + 1 + 1):
            
            l = i
            r = i + len(s1) - 1
           # print(f"checking {l}, {r}")
            freq2[s2[l-1]] -= 1
            if freq2[s2[l-1]] == 0:
                del freq2[s2[l-1]]
            freq2[s2[r]] += 1

            if freq1 == freq2: return True

        return False
        

'''
s1의 빈도수를 저장한다
s2를 two pointers로 순회한다
    빈도수를 추적하며 빈도수가 같으면 종료한다
    키와 밸류가 모두 동일해야한다.
'''