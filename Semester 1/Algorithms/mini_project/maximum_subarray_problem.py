from math import inf

def max_crossing_sublist(input_list : list[int], low : int, mid : int, high : int) -> tuple[int]:
    left_sum = -1 * inf
    right_sum = -1 * inf
    sum = 0
    max_left = -1 * inf
    max_right = -1 * inf
    
    for i in range(mid, low - 1, -1):
        sum += input_list[i]
        if sum > left_sum:
            max_left = i
            left_sum = sum
    
    sum = 0
    for j in range(mid + 1, high + 1):
        sum += input_list[j]
        if sum > right_sum:
            max_right = j
            right_sum = sum
    
    return max_left, max_right, left_sum + right_sum


def max_subarray_problem(input_list : list[int], low : int, high : int) -> tuple[int]:
    if low == high:
        return low, high, input_list[low]
    else:
        mid = int((low + high) / 2)
        left_low, left_high, left_sum = max_subarray_problem(input_list, low, mid)
        right_low, right_high, right_sum = max_subarray_problem(input_list, mid +  1, high)
        cross_low, cross_high, cross_sum = max_crossing_sublist(input_list, low, mid, high)
        
        if left_sum >= right_sum and left_sum >= cross_sum:
            return left_low, left_high, left_sum
        elif right_sum >= left_sum and right_sum >= cross_sum:
            return right_low, right_high, right_sum
        else:
            return cross_low, cross_high, cross_sum


if __name__ == "__main__":
    from random import randrange
    input_list = [randrange(-100, 100) for i in range(20)]
    print("Input array is >", input_list)
    
    low_index, high_index, max_sum = max_subarray_problem(input_list, 0, len(input_list) - 1)
    print("Maximum sum is: ", max_sum, "with ", low_index, "and", high_index, 'as the lower and upper bounds.')