# Use graphical method to solve the following LPP:
# Max z = 3x + 5y
# w.r.t
# x + 2y <= 2000,
# x + y <= 1500,
# y <= 600,
# x, y >= 0

require(lpSolve)

C <- c(3, 5)

A <- matrix(c(1, 2, 
              1, 1,
              0, 1), nrow = 3, byrow = T)

B <- c(2000, 1500, 600)

constraint_direction <- c("<=", "<=", "<=")

plot.new()
plot.window(xlim = c(0, 2000), ylim = c(0, 2000))
axis(1)
axis(2)
title(main = "LPP using graphical method", xlab = "X-axis", ylab = "Y-axis")
box()

segments(x0 = 2000, y0 = 0, x1 = 0, y1 = 1000, col = "green")
segments(x0 = 1500, y0 = 0, x1 = 0, y1 = 1500, col = "red")
segments(x0 = 0, y0 = 0, x1 = 600, y1 = 0, col = "blue")

z <- lp(direction = "max",
        objective.in = C,
        const.mat = A,
        const.dir = constraint_direction,
        const.rhs = B,
        all.int = T
        )

print(z$status)

best_sol <- z$solution
names(best_sol) <- c("x1", "x2")
print(paste("Total cost: ", z$objval, sep = ""))