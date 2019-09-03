# Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
#
# Each row must contain the digits 1-9 without repetition.
# Each column must contain the digits 1-9 without repetition.
# Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
# https://leetcode.com/problems/valid-sudoku/


class Solution(object):
    def isValid(self, board, x, y, str):
        num = board[x][y]
        # Checking Row
        for i, val in enumerate(board[x]):
            if (i != y and val == board[x][y]):
                return False
        # Checking Column
        for i in range(9):
            if (i != x and board[i][y] == board[x][y]):
                return False
        # Checking 3X3 Grid
        i = row = x - x % 3
        col = y - y % 3
        while i < (row + 3):
            j = col
            while j < (col + 3):
                if i == x and j == y:
                    j += 1
                    continue
                if (board[x][y] == board[i][j]):
                    return False
                j += 1
            i += 1
        return True

    def isValidSudoku(self, board):
        i = 0
        while(i<9):
            j=0;
            while(j<9):
                if (board[i][j] != ".") and not self.isValid(board, i,j, board[i][j]):
                    return False
                j+=1
            i+=1
        return True



board = [[".",".","4",".",".",".","6","3","."],
         [".",".",".",".",".",".",".",".","."],
         ["5",".",".",".",".",".",".","9","."],
         [".",".",".","5","6",".",".",".","."],
         ["4",".","3",".",".",".",".",".","1"],
         [".",".",".","7",".",".",".",".","."],
         [".",".",".","5",".",".",".",".","."],
         [".",".",".",".",".",".",".",".","."],
         [".",".",".",".",".",".",".",".","."]]


print Solution().isValidSudoku(board)