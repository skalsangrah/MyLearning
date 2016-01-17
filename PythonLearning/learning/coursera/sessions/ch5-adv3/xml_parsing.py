'''
Created on Oct 1, 2015

@author: santosh.kalsangrah
'''
import xml.dom.minidom

def parseXml():
    doc=xml.dom.minidom.parse("sample.xml")
    print doc.nodeName
    print doc.firstChild.tagName
    skills=doc.getElementsByTagName("skill")
    print "%d skills:" % skills.length
    for sk in skills:
        print sk.getAttribute("name")
    print "-----------------"
    newSkill = doc.createElement("skill")
    newSkill.setAttribute("name", "JQuery")
    doc.firstChild.appendChild(newSkill)
    skills=doc.getElementsByTagName("skill")
    print "%d skills:" % skills.length
    for sk in skills:
        print sk.getAttribute("name")

def main():
    parseXml()

if __name__ == '__main__':
    main()