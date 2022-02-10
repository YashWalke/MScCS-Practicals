library(igraph)

u_graph <- graph.formula(A - B, A - C, A - D, B - C, B - F, C - D, C - E, C - F, D - E, E - F, F - G, G - H)
d_graph <- graph.formula(A ++ B, A ++ D, A -+ C, B -+ C, B -+ E, B -+ F, C -+ D, C -+ F, D -+ E)

e_count(u_graph)
e_count(d_graph)

v_count(u_graph)
v_count(d_graph)

E(u_graph)
E(d_graph)

V(u_graph)
V(d_graph)

degree(u_graph)
degree(u_graph, mode = "in")
degree(u_graph, mode = "out")

degree(d_graph)
degree(d_graph, mode = "in")
degree(d_graph, mode = "out")

V(u_graph)$name[degree(u_graph) == min(degree(u_graph))]
V(d_graph)$name[degree(d_graph, mode = "in") == min(degree(d_graph, mode = "in"))]
V(d_graph)$name[degree(d_graph, mode = "out") == min(degree(d_graph, mode = "out"))]

get.adjacency(u_graph)
get.adjacency(d_graph)

get.adjlist(u_graph)
get.adjlist(d_graph)