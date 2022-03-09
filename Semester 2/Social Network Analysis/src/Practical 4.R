library(igraph)
matt <- as.matrix(read.table(text=
                               "node R S T U
                                     R 7 5 0 0
                                     S 7 0 0 2
                                     T 0 6 0 0
                                     U 4 0 1 0", header=T))
nms <- matt[, 1]
matt <- matt[, -1]
colnames(matt) <- rownames(matt) <- nms
matt[is.na(matt)] <- 0
g <- graph.adjacency(matt,weighted=TRUE)
plot(g)

s.paths <- shortest.paths(g, algorithm = "dijkstra")
print(s.paths)

shortest.paths(g, v="R", to="S")
plot(g, edge.label=E(g)$weight)

dg <- graph.formula(1-+2, 1-+3, 2++3)
plot(dg)

graph.density(dg, loops=TRUE)
graph.density(simplify(dg), loops=FALSE)