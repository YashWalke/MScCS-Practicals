from random import randint, choice

def generate_sequences():
    sequence_1 = [choice(('A', 'C', 'T', 'G')) for i in range(randint(8, 20))]
    sequence_2 = [choice(('A', 'C', 'T', 'G')) for i in range(randint(8, 20))]
    
    return sequence_1, sequence_2

def gap(sequence_1, sequence_2):
    if len(sequence_1) < len(sequence_2):
        sequence_1.insert(randint(0, len(sequence_1) - 1), " ")
    else:
        sequence_2.insert(randint(0, len(sequence_2) - 1), " ")
    
    return sequence_1, sequence_2

def pairwise_alignment(sequence_1, sequence_2):
    while len(sequence_1) != len(sequence_2):
        sequence_1, sequence_2 = gap(sequence_1, sequence_2)
    
    print("Sequence 1 after applying gaps:\t", sequence_1)
    print("Sequence 2 after applying gaps:\t", sequence_2)
    
    identity_value = 0
    identity_matrix = [[0 for j in range(len(sequence_1))] for i in range(len(sequence_2))]
    
    for i in range(len(sequence_2)):
        for j in range(len(sequence_1)):
            if sequence_2[i] == sequence_1[j]:
                identity_matrix[i][j] = 1
                identity_value += 1
    
    print("Identity matrix is:\t", identity_matrix)
    print("Identity value is:\t", (identity_value / (len(sequence_1) ** 2)) * 100)

sequence_1, sequence_2 = generate_sequences()
print("Generated sequence 1 is:\t", sequence_1)
print("Generated sequence 2 is:\t", sequence_2)

pairwise_alignment(sequence_1, sequence_2)
