# Maximize the following:
# z = 40x1 + 50x2
# w.r.t
# 2x1 + 3x2 <= 3
# 8x1 + 4x2 <= 5
# x1, x2 >= 0

require(lpSolve)
f.obj <- c(40, 50)
f.con <- matrix(c(2, 3,
                  8, 4), nrow = 2, byrow = T)
f.dir <- c("<=", "<=")
f.rhs <- c(3, 5)

lp("max", f.obj, f.con, f.dir, f.rhs)$solution
lp("max", f.obj, f.con, f.dir, f.rhs, compute.sens = T)$sens.coef.from
lp("max", f.obj, f.con, f.dir, f.rhs, compute.sens = T)$sens.coef.to
lp("max", f.obj, f.con, f.dir, f.rhs, compute.sens = T)$duals
lp("max", f.obj, f.con, f.dir, f.rhs, compute.sens = T)$duals.to