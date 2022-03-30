def func_1(x):
    main = []
    for i in range(0, x):
        main.append(input("Enter production " + str(i + 1) + " > ").replace(" ", ""))
    print("Address \t Operator \t Argument1 \t Argument2")
    for i in range(x):
        q = main[i]
        if q[0] not in res:
            res.append(q[0])
        e = func_2(q[2])
        if(len(q) > 3):
            r = func_2(q[4])
            print(str(i) + " \t " + str(q[3]) + "\t\t " + str(e) + "\t\t " + str(r))
        else:
            print(str(i) + "\t\t " + str(q[1]) + "\t\t " + str(e) + "\t\t " + "-")
    print(main)
    print(res)

def func_2(q):
    try:
        return res.index(q)
    except:
        return q

x = int(input("Enter number of productions > "))
res = []
func_1(x)