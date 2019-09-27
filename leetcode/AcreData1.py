def Solve (N,M,Q, Grid, Point):
    res = []
    for ix,q in enumerate(Point):
        if (0<=q[0]<=q[2]<=N and 0<=q[1]<=q[3]<=M):
            s=0
            for i in range(q[0]-1, q[2]):
                for j in range(q[1]-1, q[3]):
                    s+=Grid[i][j]
            res.append(s)
    return res