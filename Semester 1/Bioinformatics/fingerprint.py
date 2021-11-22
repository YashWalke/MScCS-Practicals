from random import choice, randint
import sys

def generate_sequences() -> list[list[str]]:
	sequence_length = randint(8, 20)
	sequence_count = randint(8, 20)
	
	return [[choice("ACTG") for i in range(sequence_length)] for j in range(sequence_count)]


def calculate_fingerprint(sequence_list:list[list[str]]) -> list[dict[str, int]]:
	fingerprint_list = []
	
	for j in range(len(sequence_list[0])):
		finger_print_dict = dict()
		
		for i in range(len(sequence_list)):
			finger_print_dict[sequence_list[i][j]] = finger_print_dict.get(sequence_list[i][j], 0) + 1
		
		for i in 'ACTG':
			if i not in finger_print_dict:
				finger_print_dict[i] = 0
		
		fingerprint_list.append(finger_print_dict)
	
	return fingerprint_list


def print_result(fingerprint_list:list[dict[str, int]]):
	
	print("+-------+-------+-------+-------+-------+")
	print("|Col\t|A\t|C\t|G\t|T\t|")
	print("+-------+-------+-------+-------+-------+")
	
	for i in range(len(fingerprint_list)):
		print(f"|{i + 1}\t|{fingerprint_list[i]['A']}\t|{fingerprint_list[i]['C']}\t|{fingerprint_list[i]['G']}\t|{fingerprint_list[i]['T']}\t|")
	
	print("+-------+-------+-------+-------+-------+")


if __name__ == "__main__":
	sequence_list = generate_sequences()
	
	for i in range(len(sequence_list)):
		print(f"Sequence {i + 1} is>\n", sequence_list[i], "\n")
	
	fingerprint_list = calculate_fingerprint(sequence_list)
	print_result(fingerprint_list)
