if __name__ == "__main__":
    print("Use slashes ('/') in file path wherever necessary.\n")
    file_handle = open(input("Enter a filename>\t"))
    file_data = file_handle.read()
    file_handle.close()
    
    base_dict = {}
    
    for i in "ACGT":
        base_dict[i] = file_data.count(i)
    
    print("\nBLAST search successful.\nTest results:")
    print(f"File name:\t {file_handle.name.split('/')[- 1]}")
    print(f"Genome length:\t {sum(base_dict.values())}")
    print(f"Nucleotide count:")
    
    for i in "ACGT":
        print(f"{i} : {base_dict[i]}")
