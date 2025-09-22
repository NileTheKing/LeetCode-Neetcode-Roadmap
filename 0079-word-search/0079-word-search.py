class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        ROWS = len(board)
        COLS = len(board[0])
        directions = [[-1,0],[1,0],[0,1],[0,-1]]
        def dfs(r, c, board, word, idx):
            if r < 0 or r >= ROWS or c < 0 or c >= COLS or board[r][c] == '0': return False
            if board[r][c] != word[idx]: return False
            if idx == len(word) -1: return True #마지막 인덱스이고 동일하다면 종료
            #print(f"r={r},c={c}, idx={idx}")
            temp = board[r][c]
            board[r][c] = '0' #방문처리
            for d in directions:
                nr = r + d[0]
                nc = c + d[1]
                if dfs(nr,nc,board,word,idx+1): return True
            board[r][c] = temp
            
            return False
        
        for i in range(ROWS):
            for j in range(COLS):
                if dfs(i,j, board, word,0): return True
        return False
            

            