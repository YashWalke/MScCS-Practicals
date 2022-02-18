# install.packages(c("tm", "devtools", "ggplot2", "textreuse"))
require("tm")

my.corpus <- Corpus(DirSource("C:/Temp/input_files/1"))
my_corpus <- tm_map(my.corpus, removeWords, stopwords("english"))
my.tdm <- TermDocumentMatrix(my.corpus)

my.df <- as.data.frame(inspect(my.tdm))
my.df.scale <- scale(my.df)
d <- dist(my.df.scale)
fit <- hclust(d, method = "ward.D")

plot(fit)