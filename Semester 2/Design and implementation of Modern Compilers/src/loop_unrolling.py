from datetime import datetime

if __name__ == "__main__":
    array_1 = array_2 = []
    
    start_time = datetime.now().microsecond
    for i in range(0, 1000):
        array_1.insert(0, i)
    intermediary_time = datetime.now().microsecond
    for i in range(0, 1000, 4):
        array_2.insert(0, i)
        array_2.insert(0, i + 1)
        array_2.insert(0, i + 2)
        array_2.insert(0, i + 3)
    end_time = datetime.now().microsecond
    
    print(f"Time to run 1st loop > {intermediary_time - start_time}")
    print(f"Time to run 2nd loop > {end_time - intermediary_time}")