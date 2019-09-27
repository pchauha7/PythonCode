class Graph:
    def __init__(self, V):
        self.V = V
        self.adj = [[] for i in range(V)]

    def addRelation(self, v, w):
        v -= 1
        w -= 1
        self.adj[v].append(w)
        self.adj[w].append(v)

    def countUtil(self, v, visited):
        count = 1
        visited[v] = True
        i = 0
        while i != len(self.adj[v]):
            if (not visited[self.adj[v][i]]):
                count = count + self.countUtil(self.adj[v][i], visited)
            i += 1
        return count

    def countGroups(self):

        visited = [0] * self.V

        existing_groups = 0
        new_groups = 1
        for i in range(self.V):

            # If not in any group.
            if (visited[i] == False):
                existing_groups += 1

                new_groups = (new_groups * self.countUtil(i, visited))

        return existing_groups

def minOperations(comp_nodes, comp_from, comp_to):
    if comp_nodes> len(comp_from) + 1:
        return -1

    g = Graph(comp_nodes)
    for i in range(len(comp_from)):
        g.addRelation(comp_from[i], comp_to[i])

    return g.countGroups() - 1

frm = [1]
to = [2]
x = minOperations(2, frm, to)
print x