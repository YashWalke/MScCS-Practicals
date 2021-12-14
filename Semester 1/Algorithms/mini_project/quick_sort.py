def partition(start_index, end_index, input_list):
    
    pivot_index = start_index
    pivot_value = input_list[pivot_index]
    
    while start_index < end_index:
        while start_index < len(input_list) and input_list[start_index] <= pivot_value:
            start_index += 1
        
        while input_list[end_index] > pivot_value:
            end_index -= 1
        
        if start_index < end_index:
            input_list[start_index], input_list[end_index] = input_list[end_index], input_list[start_index]
    
    input_list[end_index], input_list[pivot_index] = input_list[pivot_index], input_list[end_index]
    
    return end_index

def quicksort(start_index, end_index, input_list):
    
    if start_index < end_index:
        p = partition(start_index, end_index, input_list)
        
        quicksort(start_index, p - 1, input_list)
        quicksort(p + 1, end_index, input_list)

if __name__ == "__main__":
    from random import randrange
    
    input_list = [randrange(10, 100) for i in range(50)]
    print("Input list is", input_list)
    print()
    quicksort(0, len(input_list) - 1, input_list)
    print("Sorted list is", input_list)