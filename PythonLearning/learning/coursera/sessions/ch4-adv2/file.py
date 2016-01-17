'''
Created on Oct 1, 2015

@author: santosh.kalsangrah
'''
def filewrite():
    f=open("testtextfile.txt", "w")
    for i in range(1,101):
        f.write(str(i) + " of 100\n")
    f.close()

def fileappend():
    f=open("testtextfile.txt", "a+")
    for i in range(101,201):
        f.write(str(i) + " of 200\n")
    f.close()

def fileread():
    f=open("testtextfile.txt", "r")
    if f.mode == 'r':
        print (f.read())
    f.close()

def fileread_LineByLine():
    f=open("testtextfile.txt", "r")
    if f.mode == 'r':
        lines=f.readlines() # read into a list
        for i, l in enumerate(lines):
            print (i, l)
    f.close()
    
def main():
#     filewrite()
#     fileappend()
#     fileread()
    fileread_LineByLine()

if __name__ == '__main__':
    main()