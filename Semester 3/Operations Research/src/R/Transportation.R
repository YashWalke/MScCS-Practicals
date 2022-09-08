##SOLVE FOLLOWING TRANSPORTATION PROBLEM IN WHICH CELL ENTRIES REPRESENT UNIT COSTS USING R PROGRAMMING.

#           "Customer 1", "Customer 2", "Customer 3", "Customer 4"  SUPPLY
#SUPPLIER 1     10          2               20            11          15
#SUPPLIER 2     12          7               9             20          25
#SUPPLIER 3     4           14              16            18          10
#DEMAND         5           15              15            15

library(lpSolve)
cost <- matrix(c(10, 2, 20, 11,
                 12, 7, 9, 20,
                 4, 14, 16, 18), nrow = 3, byrow = T)

colnames(cost) <- c("Customer 1", "Customer 2", "Customer 3", "Customer 4")
rownames(cost) <- c("Supplier 1", "Supplier 2", "Supplier 3")

row.signs <- rep("<=", 3)
row.rhs <- c(15, 25, 10)

col.signs <- rep(">=", 4)
col.rhs <- c(5, 15, 15, 15)

total.cost <- lp.transport(cost, "min", row.signs, row.rhs, col.signs, col.rhs)
total.cost$solution
print(total.cost)