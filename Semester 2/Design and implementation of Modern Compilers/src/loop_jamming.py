from time import time

def test_jamming(array_1 : list[int], array_2 : list[int], array_3 : list[int]):
    start_time = time()
    for l in range(1000000):
        sum = 0
        for i in range(len(array_1)):
            sum += array_1[i]
        for j in range(len(array_2)):
            sum += array_2[j]
        for k in range(len(array_3)):
            sum += array_3[k]
    
    intermediary_time = time()
    
    for l in range(1000000):
        sum = 0
        for i in range(len(array_1)):
            sum += array_1[i]
            sum += array_2[i]
            sum += array_3[i]
    
    end_time = time()
    print(f"Time required to execute loop 1 : {intermediary_time - start_time}")
    print(f"Time required to execute loop 2 : {end_time - intermediary_time}")


if __name__ == "__main__":
    array_1, array_2, array_3 = [[10, 20, 30], [40, 20, 30], [20, 10, 40]]
    test_jamming(array_1, array_2, array_3)