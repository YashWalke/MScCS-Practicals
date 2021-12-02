from random import randint

def motif(input_file_name : str) -> str:
    with open(input_file_name) as input_file_handle:
        input_file_data = input_file_handle.read()
        input_file_handle.close()
    
    input_file_data = input_file_data.replace("\n", "")
    
    #motif_length = randint(2, len(input_file_data) - 1)
    motif_length = randint(2, 10)
    start_index = randint(0, len(input_file_data) - motif_length)
    
    return input_file_data[start_index : start_index + motif_length]

def search_for_motif(motif : str, search_file_name : str) -> int:
    with open(search_file_name) as search_file_handle:
        search_file_data = search_file_handle.read()
        search_file_handle.close()
    
    search_file_data = search_file_data.replace("\n", "")
    
    index = search_file_data.find(motif)
    
    return index

if __name__ == "__main__":
    input_file_name = input("Enter a file name >\t")
    generated_motif = motif(input_file_name)
    print("\n\nMotif generation successful.")
    print(f"\nMotif length: {len(generated_motif)}")
    print(f"\nMotif: {generated_motif}")
    
    search_file_name = input("Enter a file name to be searched >\t")
    index = search_for_motif(generated_motif, search_file_name)
    
    if index > 0:
        print("Given motif is found at index:\t", index)
    else:
        print("Motif not found in document")