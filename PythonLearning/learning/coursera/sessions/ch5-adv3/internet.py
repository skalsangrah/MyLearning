'''
Created on Oct 1, 2015

@author: santosh.kalsangrah
'''
import urllib2

def getpage():
    weburl=urllib2.urlopen("http://google.co.in/")
    print ("Result code is :" + str(weburl.getcode()))
    print (weburl.read())
  

def main():
    getpage()
if __name__ == '__main__':
    main()