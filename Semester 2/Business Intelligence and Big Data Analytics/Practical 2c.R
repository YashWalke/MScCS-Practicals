library("textreuse")

minhash <- minhash_generator(200, seed = 235)
ats <- TextReuseCorpus(dir = "C:/Temp/input_files/2", tokenizer = tokenize_ngrams, n = 5, minhash_func = minhash)

buckets <- lsh(ats, bands = 50, progress = interactive())
candidates <- lsh_candidates(buckets)
scores <- lsh_compare(candidates, ats, jaccard_similarity, progress = F)
scores

barplot(as.matrix(scores), col = c("#00eb07", "#57ef87", "#ed791a", "#5e5fff", "#1cf1c6", "#5e035b"))