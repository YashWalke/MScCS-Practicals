from random import choice, randint
from string import ascii_uppercase

sequence_list = []

def get_sequences() -> tuple[list[str]]:
	sequence_length = randint(8, 50)
	sequence_1 = [choice(ascii_uppercase) for i in range(sequence_length)]
	sequence_2 = [choice(ascii_uppercase) for i in range(sequence_length)]
	
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


def similarity(sequence_1 : list[str], sequence_2 : list[str]) -> tuple[int, list[str]]:
	similarity_list = [1 if i else 0 for i in list(map(check_similarity, sequence_1, sequence_2))]
	similarity_value = sum(similarity_list)
	
	return similarity_value, similarity_list


if __name__ == "__main__":
	sequence_1, sequence_2 = get_sequences()
	print("Sequence 1 is>\n", sequence_1)
	print("Sequence 2 is>\n", sequence_2)
	print("\n")
	
	get_similar_protein_set()
	print("Similar protein sets are>\n", sequence_list)
	print("\n")
	
	similarity_value, similarity_list = similarity(sequence_1, sequence_2)
	print("Similarity list is>\n", similarity_list)
	print(f"Similarity is {round((similarity_value / len(sequence_1)) * 100, 2)}%")
