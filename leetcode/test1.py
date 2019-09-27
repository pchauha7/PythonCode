def order (employee_nodes, employees_from, employees_to, host):
    edges = [[ (0) for i in range (employee_nodes +1)]  for i in range (employee_nodes + 1)]

    print edges
    for i in range(len(employees_from)):
        edges[employees_from[i]][employees_to[i]] = 1
        edges[employees_to[i]][employees_from[i]] = 1

    print edges

    visited = [False] * (employee_nodes + 1)

    queue = []
    queue.append(host)
    visited[host] = True

    res = []
    while queue:
        s = queue.pop(0)
        res.append(s)
        for i in range(len(edges)):
            if edges[s][i] == 1 and visited[i] == False:
                queue.append(i)
                visited[i] = True
        #if len(tq) > 0:
         #   tq.sort()
          #  queue = queue + tq

    return res[1:]


print order(2, [1], [2], 2)
