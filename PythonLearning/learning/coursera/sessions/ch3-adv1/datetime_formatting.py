
from datetime import datetime

# y/Y -year, a/A - weekday, b/B-month, d - day
def dateformat1():
    now = datetime.now()
    print now.strftime("%Y")
    print now.strftime("%y")
    print now.strftime("%a:%A %d %b:%B %y:%Y")

# c- locale date and time, x - locale date, X - locate time
def dateformat2():
    now = datetime.now()
    print now.strftime("%c")
    print now.strftime("%x")
    print now.strftime("%X")

# I/H-12/24 hr, M - min, S- sconds, p-locale AM/PM
def timeformat1():
    now = datetime.now()
    print now.strftime("%I:%M:%S  %p")
    print now.strftime("%H:%M:%S")
    
def main():
    # dateformat1()
    # dateformat2()
    timeformat1()


if __name__ == "__main__":
    main()
