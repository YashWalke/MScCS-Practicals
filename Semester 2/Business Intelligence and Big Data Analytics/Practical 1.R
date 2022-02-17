#install.packages(c("tm", "devtools"))
require("tm")


kshingle <- function(){
  # readline(prompt = Text to be displayed)
  # as.integer(variable)
  k <- as.integer(readline("Enter the value for k - 1 > "))
  
  # Enter the location of the input file in the function below.
  u1 <- readLines("C:/Temp/input_text.txt")
  
  shingle <- i <- 0
  while(i < nchar(u1) - k + 1)
  {
    #substr(input_string, start = start_value, stop = stop_value)
    shingle[i] <- substr(u1, i, i + k)
    print(shingle[i])
    
    # Counter variable
    i <- i + 1
  }
}

# interactive() checks if R is running in interactive (i.e. REPL) mode or not.
if(interactive())kshingle()