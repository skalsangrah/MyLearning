'''
Created on Oct 1, 2015

@author: santosh.kalsangrah
'''
import os
from os import path
from datetime import datetime, date, time
import time
from sqlite3 import Timestamp

def ostest():
    print (os.name)

def pathtest():
    print ("Item exist?" + str(path.exists("testtextfile.txt")))
    print ("Is file?" + str(path.isfile("testtextfile.txt")))
    print ("Is dir?" + str(path.isdir("testtextfile.txt")))

def pathwork():
    print ("Item path: " + str(path.realpath("testtextfile.txt")))
    print ("Item's path and name: " + str(path.split(path.realpath("testtextfile.txt"))))

def pathlastmodificationtime():
    print ("Item path: " + str(path.realpath("testtextfile.txt")))
    t=time.ctime(path.getmtime("testtextfile.txt"))
    print ("Last modify time: " + t )
    print (datetime.fromtimestamp(path.getmtime("testtextfile.txt")))

def pathhowlongagomodified():
    td=Timestamp.now() - datetime.fromtimestamp(path.getmtime("testtextfile.txt"))
    print ("Its been: ", td)
    print ("In seconds, its been: ", td.seconds)


def main():
    ostest()
    pathtest()
    pathwork()
    pathlastmodificationtime()
    pathhowlongagomodified()
    
if __name__ == '__main__':
    main()