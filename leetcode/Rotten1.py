class Solution(object):
    def orangesRotting(self, grid):
        q = []
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        count = 0
        R = len(grid)
        C = len(grid[0])
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    q.append([i, j])
                    grid[i][j] = 0

        while len(q) > 0:
            l = len(q)
            for i in range(l):
                pos = q.pop(0)
                for dir in dirs:
                    x = pos[0] + dir[0]
                    y = pos[1] + dir[1]
                    if (x < 0 or x >= R or y < 0 or y >= C or grid[x][y] == 0):
                        continue
                    q.append([x, y])
                    grid[x][y] = 0
            count += 1

        for x in grid:
            if 1 in x:
                return -1
        if count == 0:
            return count
        return count - 1