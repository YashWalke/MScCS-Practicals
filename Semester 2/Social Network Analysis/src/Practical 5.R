library(igraph)

sociogram <- graph.formula(Andy++Garth,Garth-+Bill,Bill-
                             +Elena,Elena++Frank,Carol-+Andy,Carol-
                             +Elena,Carol++Dan,Carol++Bill,Dan++Andy,Dan++Bill)

plot(sociogram)

get.adjacency(sociogram)
E(sociogram)
get.adjedgelist(sociogram)