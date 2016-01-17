def whileloop(x):
    while (x < 5):
        print x
        x = x + 1

def forloop(x):
    for i in range(x):
        print i
        i = i + 1
    print "++++"
    for j in range (5, x):
        print j
        j = j + 1

def forloop_over_collection(x):
    for d in x:
        print d

def loop_break(x):
    for j in range (5, x):
        if (j == 7):
            break
        print j   

def loop_continue(x):
    for j in range (5, x):
        if (j % 2 == 0):
            continue
        print j

def loop_enumerate(x):
    for i, d in enumerate(x):
        print i, d

def main():
    days = ["sun", "mon", "tue", "wed", "thu", "fri", "sat"]
    loop_enumerate(days)
#     whileloop(1)
#     print "------------------"
#     forloop(7)
#     forloop_over_collection(days)
#    loop_break(10)
#    loop_continue(10)
    loop_enumerate(days)
    
if __name__ == "__main__":
    main()
