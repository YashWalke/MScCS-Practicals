from random import choice, randint

def get_sequences(no_of_sequences : int) -> list[list[str]]:
	sequence_list = []
	print("Enter the sequences (All sequences should have equal length)>\t")
	
	for i in range(no_of_sequences):
		sequence_list.append(list(input(f"Enter sequence {i + 1}>\t")))
	
	return sequence_list


def get_random_sequences(no_of_sequences : int) -> list[list[str]]:
	sequence_length = randint(8, 20)
	sequence_list = [[choice('ABCDE') for j in range(sequence_length)] for i in range(no_of_sequences)]
	return sequence_list


def multiple_sequence_alignment(sequence_list : list[list[str]]) -> list[str]:
	output_sequence = []
	
	for i in range(len(sequence_list[0])):
		char_list = list()
		
		for j in range(len(sequence_list)):
			char_list.append(sequence_list[j][i])
		
		char_set = set(char_list)
		char_at_pos = ""
		
		if len(char_set) == 1:
			char_at_pos = char_set[0]
			
		elif len(sequence_list) % len(char_set) == 0:
			for i in char_set:
				char_at_pos += f"{i}/"
			char_at_pos = char_at_pos[: -1]
			
		else:
			largest_count = 0
			largest_char = None
			
			for i in char_set:
				if char_list.count(i) >= largest_count:
					largest_char = i
					largest_count = char_list.count(i)
			
			char_at_pos = largest_char.lower()
		
		output_sequence.append(char_at_pos)
		
	return output_sequence


if __name__ == "__main__":
	print("Multiple sequence alignment in Python 3.6+")
	no_of_sequences = int(input("Enter the number of input sequences>\t"))
	
	random_flag = False if input("Do you want the sequences to be randomly generated? [Yes]/No>\t").lower() == "no" else True
	sequence_list = get_random_sequences(no_of_sequences) if random_flag else get_sequences(no_of_sequences)
	
	print("Sequences are as follows:")
	for i in range(len(sequence_list)):
		print(f"Sequence {i + 1}>\t", sequence_list[i])
	
	print("Multiple sequence alignment for given sequences is:\t", multiple_sequence_alignment(sequence_list))
