def similarity(sequence_1:str, sequence_2:str) -> tuple[list[int], int]:
    if len(sequence_1) != len(sequence_2):
        return None
    
    similarity_list = [0 for i in range(len(sequence_1))]
    similarity_value = 0
    
    for i in range(len(sequence_1)):
        if sequence_1[i] == sequence_2[i]:
            continue
        
        if sequence_1[i] in ('Q', 'N') and sequence_2[i] in ('Q', 'N'):
            similarity_list[i] = 1
            similarity_value += 1
        
        elif sequence_1[i] in ('I', 'L', 'V') and sequence_2[i] in ('I', 'L', 'V'):
            similarity_list[i] = 1
            similarity_value += 1
        
        elif sequence_1[i] in ('T', 'S') and sequence_2[i] in ('T', 'S'):
            similarity_list[i] = 1
            similarity_value += 1
        
        elif sequence_1[i] in ('W', 'F', 'V') and sequence_2[i] in ('W', 'F', 'V'):
            similarity_list[i] = 1
            similarity_value += 1
        
        elif sequence_1[i] in ('R', 'K') and sequence_2[i] in ('R', 'K'):
            similarity_list[i] = 1
            similarity_value += 1
        
    return similarity_list, similarity_value

if __name__ == "__main__":
    sequence_1 = input("Enter sequence 1>\t")
    sequence_2 = input("Enter sequence 2>\t")
    
    similarity_list, similarity_value = similarity(sequence_1, sequence_2)
    
    print("Similarity sequence is:\t", similarity_list)
    print("Similarity value is:\t", (similarity_value / len(sequence_1)) * 100)