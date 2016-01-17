'''
Created on Nov 6, 2015

@author: santosh.kalsangrah
'''
def basicoperation():
    hello="Testing basic operations"
    print "Provided String:", hello
    print "length : ", len(hello)
    print "Number of spaces: ", hello.count(' ')
    print "String in All capital: ", hello.upper()
    print "String in All lower: ", hello.lower()

def findreplace(sentence):
    testword='Hello'
    print "Is '", testword, "' in ", sentence, ": ", sentence.find(testword)
    print "Replace 't' by 'T'", sentence.replace('t', 'T')
    print " Though this sentence is in mix case but would be printed in All Capital ".upper().lstrip().rstrip().strip()
    
def slicing(word):
    print "------Slicing:"
    another='test'
    print "Slicing:", word.find(another)
    if len(word)/2 > 0:
        hello1=word[:len(word)/2]
        hello2=word[len(word)/2:]
        hello3=hello1[:]+hello2[:]
        hello4=word[:555]
        print "Are equal:", word==hello3
        print "Length:", len(hello4)     
def intest(word):
    print "------------in tests-------------"
    print "test" in word
    print "Test" in word
        
def startwithTest():
    print "--------start with tests---------"
    line = 'Please have a nice day'
    print line.startswith('Please')
    print line.startswith('p')


def comparisions(word):
    print "-------------- compares  --------------"

    if word < 'banana':
        print 'Your word, ' + word + ' , comes before banana.'
    elif word > 'banana':
        print 'Your word, ' + word + ' , comes after banana.'
    else:
        print 'All right, bananas.'
    
def misc(word):
    print "Type of word is: ", type(word)
    print dir(word)

def looping_in(word):
    print "-------------- string having char per line --------------"
    index=0
    for letter in word:
        print index,letter
        index = index + 1 
def main():
    sentence = "hello, this I mean this: Hello, This sentence is not and not suppose to follow all English GiraMMer:)"
    basicoperation()
    findreplace(sentence)
    slicing(sentence)
    intest(sentence)
    startwithTest()
    comparisions(sentence)
    misc(sentence)
    looping_in("This test goes in loop test.")

print(__name__)
if __name__ == '__main__':
    main()