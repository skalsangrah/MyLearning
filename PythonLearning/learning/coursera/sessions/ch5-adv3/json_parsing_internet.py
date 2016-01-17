'''
Created on Oct 1, 2015

@author: santosh.kalsangrah
'''
import urllib2
import json
from _ast import Str

def printResults(jsondata):
    #print(jsondata)
    theJSON=json.loads(jsondata)
    if "title" in theJSON["metadata"]:
        print (theJSON["metadata"]["title"])
    count = (theJSON["metadata"]["count"])
    print (str(count) + " events recorded")
    
    for i in theJSON["features"]:
        print (i["properties"]["place"])
        
    for i in theJSON["features"]:
        if i["properties"]["mag"] >=4.0:
            print ("%2.1f" % i["properties"]["mag"] + " " + i["properties"]["place"])
    
    for i in theJSON["features"]:
        feltReports=i["properties"]["felt"]
        if ((feltReports != None ) and (feltReports > 0)):
            print "%2.1f" % i["properties"]["mag"], i["properties"]["place"], " reported " + str(feltReports) + " times"

            
def getjson():
    urldata="http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_day.geojson"
    weburl=urllib2.urlopen(urldata)
    if (weburl.getcode() == 200):
        print ("Response code is : " + str(weburl.getcode()))
        printResults(weburl.read())
    else:
        print ("Error in reading URL: ", urldata) 
    
def main():
    getjson()
    
if __name__ == '__main__':
    main()