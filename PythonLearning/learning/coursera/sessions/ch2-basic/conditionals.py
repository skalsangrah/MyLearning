def conditions(x, y):
    
    if (x < y):
        st = "Less than"
    elif (x > y):
        st = "Greater than"
    else:
        st = "Equal"
    print st
def conditions2(x, y):
    st = "Less than " if x < y else "greater or Equal"
    return st

def main():
    conditions(10, 10)
    conditions(100, 10)
    conditions(10, 100)
    print conditions2(10, 10)
    print conditions2(100, 10)
    print conditions2(10, 100)    
    
            
if __name__ == "__main__":
    main()
