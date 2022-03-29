def postfix_evaluation(input_string):
    postfix_expr = input_string.split()
    stack = []

    for i in postfix_expr:
        if i.isdigit() or i[1 : ].isdigit():
            stack.append(i)
            continue
        else:
            operand_2 = stack.pop()
            operand_1 = stack.pop()
            stack.append(str(eval(f"{operand_1}{i}{operand_2}")))
    
    return stack.pop()

if __name__ == "__main__":
    input_string = input("Enter a postfix expression seperated by spaces>\t")
    print(input_string)
    print(postfix_evaluation(input_string))