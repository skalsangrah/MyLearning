'''
Created on Oct 1, 2015

@author: santosh.kalsangrah
'''
import os
from os import path
import shutil
from shutil import make_archive
from zipfile import ZipFile

def duplicateFile():
    if path.exists("testtextfile.txt"):
        src=path.realpath("testtextfile.txt")
        bpath, fname=path.split(src)
        dst=src +".bak"
        print("srcpath: " + bpath + " srcfile: " + fname + "\ndst name: " + dst)
        shutil.copy(src, dst)
        shutil.copystat(src, dst)

def renameFile():
    if path.exists("testtextfile.txt.bak"):
        os.renames("testtextfile.txt.bak", "newfile.txt")

def zipFile():
    if path.exists("testtextfile.txt"):
        p,f=path.realpath("testtextfile.txt").split("testtextfile.txt")
        if (path.exists(p) and path.isdir(p)):
            # now zip all text files
            ### folliwing zips everything in p
            #shutil.make_archive("archive", "zip", p)
            with ZipFile("testzip.zip", "w") as newzip:
                newzip.write("testtextfile.txt")
                newzip.write("newfile.txt")
        
def main():
    #duplicateFile()
    #renameFile()
    zipFile()

if __name__ == '__main__':
    main()