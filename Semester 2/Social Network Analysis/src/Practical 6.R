library(sna)
library(igraph)
links2 <- read.csv("C:/Temp/input_files/edges1.csv", header=T, row.names=1)
eq<-equiv.clust(links2)
plot(eq)

g.se<-sedist(links2)

plot(cmdscale(as.dist(g.se)))
b<-blockmodel(links2,eq,h=10)
plot(b)
