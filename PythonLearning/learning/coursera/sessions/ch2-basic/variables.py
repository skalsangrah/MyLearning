f = 10
print f

f = "abc"

print f

# different types can not be combined
# print "Now adding a number to this string" + 123

print "Now adding a number to this string " + str(123)

# global vs local varaibles

def someFun():
    f = "def"
    print f
    
someFun()
print f

def someFun2():
    global f
    f = "def"
    print f
    
someFun2()
print f

del f
print f
