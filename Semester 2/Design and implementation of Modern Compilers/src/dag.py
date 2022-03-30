def func_1(x):
    main = []
    for i in range(0, x):
        main.append(input("Enter production " + str(i + 1) + " > ").replace(" ", ""))
    print("Label \t Operator \t Left \t Right")
    for i in range(x):
        q = main[i]
        if q[0] not in res:
            res.append(q[0])
        
        if(len(q) > 3):
            print(str(q[0]) + " \t " + str(q[3]) + " \t\t " + str(q[2]) + " \t " + str(q[4]))
        else:
            print(str(q[0]) + " \t " + str(q[1]) + " \t " + str(q[2]) + " \t " + "-")
        
    print(main)
    print(res)

x = int(input("Enter number of three address codes > "))
res = []
func_1(x)