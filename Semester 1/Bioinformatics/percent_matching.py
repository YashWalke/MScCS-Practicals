from random import choice, randint
from string import ascii_uppercase
from operator import eq

sequence_list = []

def get_sequences() -> tuple[list[str]]:
	
	sequence_1 = [choice(ascii_uppercase) for i in range(randint(8, 50))]
	sequence_2 = [choice(ascii_uppercase) for i in range(randint(8, 50))]
	
	return sequence_1, sequence_2


def insert_gap(sequence : list[str]) -> list[str]:
	sequence.insert(randint(0, len(sequence) - 1), '-')
	
	return sequence


def insert_gaps(sequence_1 : list[str], sequence_2 : list[str]) -> tuple[list[str]]:
	while len(sequence_1) != len(sequence_2):
		if len(sequence_1) < len(sequence_2):
			sequence_1 = insert_gap(sequence_1)
		else:
			sequence_2 = insert_gap(sequence_2)
		
	return sequence_1, sequence_2


def get_similar_protein_set():
	sequence_count = int(input("Enter the number of similar protein sets>\t"))
	
	global sequence_list
	for i in range(sequence_count):
		sequence_list.append(list(input(f"Enter similar protein set {i + 1}>\t")))


def check_similarity(char_1 : str, char_2 : str) -> bool:
	global sequence_list
	for i in sequence_list:
		if (char_1 != char_2):
			if char_1 in i and char_2 in i:
				return True
	
	return False


def similarity(sequence_1 : list[str], sequence_2 : list[str]) -> int:
	similarity_list = [1 if i else 0 for i in list(map(check_similarity, sequence_1, sequence_2))]
	similarity_value = sum(similarity_list)
	
	return similarity_value


def identity(sequence_1 : list[str], sequence_2 : list[str]) -> int:
	
	return sum(map(eq, sequence_1, sequence_2))


def count_gaps(sequence_1 : list[str], sequence_2 : list[str]) -> int:
	return sequence_1.count("-") + sequence_2.count("-")


if __name__ == "__main__":
	sequence_1, sequence_2 = get_sequences()
	print("Sequence 1 is>\n", sequence_1)
	print("Sequence 2 is>\n", sequence_2)
	print("\n")
	
	sequence_1, sequence_2 = insert_gaps(sequence_1, sequence_2)
	print("Sequence 1 after adding gaps is>\n", sequence_1)
	print("Sequence 2 after adding gaps is>\n", sequence_2)
	print("\n")
	
	get_similar_protein_set()
	print("\nSimilar protein sets are>\n", sequence_list)
	print("\n")
	
	similarity_value = similarity(sequence_1, sequence_2)
	identity_value = identity(sequence_1, sequence_2)
	gap_count = count_gaps(sequence_1, sequence_2)
	
	print("Similarity value is>\t", similarity_value)
	print("Identity value is>\t", identity_value)
	print("Gap count is>\t", gap_count)
	print("\n")
	
	print(f"Percentage of matching is {round(((similarity_value + identity_value) / (len(sequence_1) - gap_count)) * 100, 2)}%")
