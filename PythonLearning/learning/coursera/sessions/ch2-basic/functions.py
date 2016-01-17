def fun1():
    print "I am a function"
    
fun1()
print fun1()
print fun1

fun2 = fun1
fun2()

def fun3(arg1, arg2):
    print arg1, arg2
fun3("one", 1)
print fun3("two", 2)
print fun3

def cub(x):
    return x * x * x

print cub(3)
print cub

def power(num, x=1):
    result = 1
    for i in range(x):
        result = result * num
    return result

print power(2)
print power(2, 3)
print power(x=3, num=4)



def multi_add(*args):
    result = 0
    for x in args:
        result = result + x
    return result;

print multi_add(1, 2, 3, 4)
print multi_add(1, 2, 3, 4, 5)
