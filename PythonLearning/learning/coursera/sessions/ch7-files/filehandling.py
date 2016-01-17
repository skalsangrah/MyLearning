'''
Created on Nov 7, 2015

@author: santosh.kalsangrah
'''
from fileinput import filename

def createfile(fname):
    fout = open(fname, "w")
    print fout
    if fout.mode != "w":
        print "Error in opening file: ", fname
        fout.close()
        
    fout.write("First line in this newly create text file \n")
    fout.write("And this is second \n one having a new file character here\n as well")

def openreadfile_linebyline(fname):
    f=open(fname, "r") # "r" is optional and if omitted, "r" is assumed
    print f
    if f.mode != "r":
        print "Error in opening file: ", fname
        f.close()
    print "-------------read line by line ----------"    
    for line in f:
        print line.rstrip() #remove new line
    f.close()

def openreadfile_allinone(fname):
    f=open(fname, "r") # "r" is optional and if omitted, "r" is assumed
    print f
    if f.mode != "r":
        print "Error in opening file: ", fname
        f.close()
    print "-------------read everythhin in one go ----------"
    print f.read(); # Fails if files is too big, error no memory
    f.close()

def openreadfile_allLines(fname):
    f=open(fname, "r") # "r" is optional and if omitted, "r" is assumed
    print f
    if f.mode != "r":
        print "Error in opening file: ", fname
        f.close()
    print "-------------read all lines in one go and then iterate ----------"
    lines=f.readlines() # Fails is file is too big, errors no memory
    for l in lines:
        print l.rstrip() # remove newline
    f.close()


def deletefiletest(fname):
    #deletefile(fname)
    #openreadfile(fname)
    pass
    
def main():
    fname="test.txt"
    createfile(fname)
    openreadfile_linebyline(fname)
    openreadfile_allinone(fname)
    openreadfile_allLines(fname)
    deletefiletest(fname)
    #morefile()
    
if __name__ == '__main__':
    main()
    