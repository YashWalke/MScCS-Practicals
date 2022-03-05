require("igraph")

edges <- read.csv("C:/Temp/input_files/edges.csv")
nodes <- read.csv("C:/Temp/input_files/nodes.csv")

head(edges)
head(nodes)

dir_graph <- graph.data.frame(d = edges, vertices = nodes, directed = T)
get.adjacency(dir_graph)

plot(dir_graph)