# Write a program to solve a Sudoku puzzle by filling the empty cells.
#
# A sudoku solution must satisfy all of the following rules:
#
# Each of the digits 1-9 must occur exactly once in each row.
# Each of the digits 1-9 must occur exactly once in each column.
# Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
# https://leetcode.com/problems/sudoku-solver/


class Solution(object):
    def isSafe(self, board, x, y, str):
        # Checking Row
        for i in range(9):
            if (str == board[x][i]):
                return False
        # Checking Column
        for i in range(9):
            if (board[i][y] == str):
                return False
        # Checking 3X3 Grid
        i = row = x - x % 3
        col = y - y % 3
        while i < (row + 3):
            j = col
            while j < (col + 3):
                if (str == board[i][j]):
                    return False
                j += 1
            i += 1
        return True

    def nextUnassigned(self, board, l):
        for i in range(9):
            for j in range(9):
                if (board[i][j]=='.'):
                    l[0] = i
                    l[1] = j
                    return True
        return False

    def solveSudoku(self, board):
        l =[0,0]

        if not self.nextUnassigned(board,l):
            return True

        i = l[0]
        j = l[1]

        for k in range(1, 10):
            if self.isSafe(board, i, j, str(k)):
                board[i][j] = str(k)

                if self.solveSudoku(board):
                    return True     #Got our solution
                #Backtracking
                board[i][j] = "."




board = [["5","3",".",".","7",".",".",".","."],
         ["6",".",".","1","9","5",".",".","."],
         [".","9","8",".",".",".",".","6","."],
         ["8",".",".",".","6",".",".",".","3"],
         ["4",".",".","8",".","3",".",".","1"],
         ["7",".",".",".","2",".",".",".","6"],
         [".","6",".",".",".",".","2","8","."],
         [".",".",".","4","1","9",".",".","5"],
         [".",".",".",".","8",".",".","7","9"]]


Solution().solveSudoku(board)
print board