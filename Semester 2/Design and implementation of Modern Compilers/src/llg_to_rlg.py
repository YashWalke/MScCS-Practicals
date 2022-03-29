# Converting Left Linear Grammer to Right Linear Grammer



def get_transitions(rules):

    my_dict = res = dict()
    ld = r = str()

    for i in rules:
        try:
            my_dict[i[0]] = [i[1][1], i[1][0]]
        except IndexError:
            continue
    
    for sub in my_dict:
        if isinstance(my_dict[sub], list):
            res[sub] = ld.join([str(ele) for ele in my_dict[sub]])
    
    print("Left Linear grammer is:")
    for item in res:
        print(r, item, "->", res[item])


if __name__ == "__main__":
    rule_count = int(input("Enter rule count>\t"))
    rules = []

    for i in range(rule_count):
        rules.append(input("Enter right linear grammer" + str(i + 1) + ">\t"))
    
    rules = [i.split("->") for i in rules]
    print(rules)
    get_transitions(rules)