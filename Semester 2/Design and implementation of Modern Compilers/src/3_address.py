if __name__ == "__main__":
    postfix_expr = input("Enter postfix expression > ").split()
    operator_set = ('+', '-', '/', '*', '^')
    stack = []
    result = str1 = " "
    count = 0
    print("Three address code")
    for i in postfix_expr:
        if i not in operator_set:
            stack.append(i)
            print("Stack:", stack)
        else:
            operand2 = stack.pop()
            operand1 = stack.pop()
            result = operand1 + i + operand2
            stack.append("T" + str(count))
            print("T", count, "=", result)
            count += 1