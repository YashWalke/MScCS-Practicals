#install.packages("igraph")
library("igraph")

kite <- graph.famous("Krackhardt_Kite")
vcount(kite)
ecount(kite)
ecount(kite) / (vcount(kite) * (vcount(kite) - 1) / 2)

dir_graph <- graph.formula(A ++ B, A ++ D, A -+ C, B -+ C, B -+ E, B -+ F, C -+ D, C -+ F, D -+ E)
plot(dir_graph)
reciprocity(dir_graph)
dyad.census(dir_graph)
mutual <- dyad.census(dir_graph)$mut
mutual / (ecount(dir_graph))

atri <- adjacent.triangles(kite)
plot(kite, vertex.label = atri)
transitivity(kite, type = "local")
adjacent.triangles(kite) / (degree(kite) * (degree(kite) - 1) / 2)

graph_2 <- barabasi.game(50, p = 2, directed = F)
graph_1 <- watts.strogatz.game(1, size = 100, nei = 5, p = 0.05)
graph <- graph.union(graph_1, graph_2)
graph <- simplify(graph)
plot(graph)