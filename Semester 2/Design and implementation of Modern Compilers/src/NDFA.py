from automata.fa.nfa import NFA

class NDFA:
    def __init__(self):
        state_set = set(input("Enter state set>\t"))
        input_symbols = set(input("Enter input symbol set>\t"))
        initial_state = input("Enter the initial state>\t")
        final_states = set(input("Enter the final state(s)>\t"))
        rule_count = int(input("Enter the number of rules you want to add>\t"))
        rules = []
        for counter in range(rule_count):
            rules.append(input(f"Enter rule {counter + 1}>\t"))
        rules = self.get_transitions(rules)
        
        self.nfa = NFA(
            states = state_set,
            input_symbols = input_symbols,
            transitions = rules,
            initial_state = initial_state,
            final_states = final_states
        )
        
        del state_set, input_symbols, initial_state, final_states, rules
    
    
    def get_transitions(self, rules : list[str]) -> dict[str, dict[str, str]]:
        rules = [i.split("-") for i in rules]
        rules_dict = {}
        
        for rule in rules:
            if rule[0] not in rules_dict:
                rules_dict[rule[0]] = {rule[1][0]:rule[1][1]}
            else:
                rules_dict[rule[0]][rule[1][0]] = rule[1][1]
        
        return rules_dict
    
    
    def print_stats(self):
        print("\n\nSet of states are > ", self.nfa.states)
        print("Input symbols are > ", self.nfa.input_symbols)
        print("Transitions are > ")
        for transition in self.nfa.transitions:
            print(transition, self.nfa.transitions[transition])
        print("Initial state > ", self.nfa.initial_state)
        print("Final states > ", self.nfa.final_states)
    
    
    def print_transition_table(self):
        input_symbols = list(self.nfa.input_symbols)
        transitions = self.nfa.transitions
        
        print("\n\nTransition table is > ")
        print(f"States\t\t{input_symbols[0]}\t\t{input_symbols[1]}")
        for transition in transitions:
            for input_symbol in input_symbols:
                try:
                    temp = transitions[transition][input_symbol]
                    del temp
                except KeyError:
                    transitions[transition][input_symbol] = "-"
            print(f"{transition}\t\t{transitions[transition][input_symbols[0]]}\t\t{transitions[transition][input_symbols[1]]}")
        del input_symbols, transitions


if __name__ == "__main__":
    ndfa = NDFA()
    ndfa.print_stats()
    ndfa.print_transition_table()