'''
Created on Oct 1, 2015

@author: santosh.kalsangrah
'''
from HTMLParser import HTMLParser
import urllib2

class MyHTMLParser(HTMLParser):
    def handle_comment(self, data):
        print "Encountered comment:", data
        pos=self.getpos()
        print "At line:", pos[0], " position ", pos[1]
        
def main():
    parser = MyHTMLParser()
#     f = open("sample.html")
#     if f.mode == "r":
#         content=f.read()
#         parser.feed(content)
    weburl = urllib2.urlopen("http://google.co.in")
    if weburl.getcode() == 200:
        #weburl.read()
        c = MyHTMLParser()
        c.handle_comment(weburl.read())
if __name__ == '__main__':
    main()