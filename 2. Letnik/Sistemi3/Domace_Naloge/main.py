import random

def print_something():
    for x in range(5):
        print(x)

def rand_num():
    return random.randint(1,24)

def print_sum():
    prev = 0 
    for x in range(10):
        sum = prev + x
        print(f'Current Number {x} Previous Number {prev} Sum: {sum}')
        prev = x

def remove_chars(string, num):
    return (f'{string[num:]}')

print_something()
print(rand_num())
print_sum()
print(remove_chars("pynative", 4))