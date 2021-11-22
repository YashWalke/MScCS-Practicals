from random import randint, choice
from math import inf

def generate_sequences() -> tuple[list[str]]:
	sequence_1 = [choice(('A', 'C', 'T', 'G')) for i in range(randint(6, 7))]
	sequence_2 = [choice(('A', 'C', 'T', 'G')) for i in range(randint(6, 7))]
	
	return sequence_1, sequence_2


class GlobalAlignment:
	
	@staticmethod
	def generate_scoring_matrix(sequence_1:list[str], sequence_2:list[str]) -> list[list[list[int, list[str]]]]:
		sequence_1.insert(0, '-')
		sequence_2.insert(0, '-')
		result_matrix = [[[0] for i in range(len(sequence_2))] for j in range(len(sequence_1))]
		
		for i in range(1, len(sequence_1)):
			result_matrix[i][0][0] = result_matrix[i - 1][0][0] - 2
			result_matrix[i][0].append(["up"])
			
		for j in range(1, len(sequence_2)):
			result_matrix[0][j][0] = result_matrix[0][j - 1][0] - 2
			result_matrix[0][j].append(["besides"])
			
		for i in range(1, len(sequence_1)):
			for j in range(1, len(sequence_2)):
				besides_value = result_matrix[i][j - 1][0] - 2
				up_value = result_matrix[i - 1][j][0] - 2
				diagonal_value = result_matrix[i - 1][j - 1][0]
				
				additive_value = None
				direction = []
				
				if(sequence_1[i] == '-') or (sequence_2[j] == '-'):
					additive_value = - 2
				elif (sequence_1[i] != sequence_2[j]):
					additive_value = - 1
				elif (sequence_1[i] == sequence_2[j]):
					additive_value = 1
					
				diagonal_value += additive_value
				
				largest_value = besides_value
				direction.append("besides")
				
				if (largest_value < up_value):
					largest_value = up_value
					direction[0] = "up"
					
				elif (largest_value == up_value):
					direction.append("up")
				
				if (largest_value < diagonal_value):
					largest_value = diagonal_value
					direction[0] = "diagonal"
					if len(direction) > 1:
						direction.pop()
					
				elif (largest_value == diagonal_value):
					largest_value = diagonal_value
					direction.append("diagonal")
				
				
				result_matrix[i][j][0] = largest_value
				result_matrix[i][j].append(direction)
				
		return result_matrix
	
	@staticmethod
	def print_scoring_matrix(result_matrix:list[list[list[int, list[str]]]]):
		for i in range(len(result_matrix)):
			print(result_matrix[i])
			print("\n")


if __name__ == "__main__":
	sequence_1, sequence_2 = generate_sequences()
	
	print("Sequence 1 is:\t", sequence_1)
	print("Sequence 2 is:\t", sequence_2)
	
	result_matrix = GlobalAlignment.generate_scoring_matrix(sequence_1, sequence_2)
	print("Scoring matrix is:")
	GlobalAlignment.print_scoring_matrix(result_matrix)
