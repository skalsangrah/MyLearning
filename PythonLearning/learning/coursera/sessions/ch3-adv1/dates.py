from datetime import date
from datetime import time
from datetime import datetime

def date1():
    today = date.today()
    print "today's date is ", today
    print "TODAY: parts ", today.day, today.month, today.year
    print "TODAY:weekday ", today.weekday()

        
def datetime1():
    today = datetime.now()
    print "Current date and time  is ", today
    t = datetime.time(datetime.now())
    print "Current time is ", t

def datetime2():
    today = datetime.now()
    wd = date.weekday(today)
    
    days = ["Monday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"]
    
    print "Today is day number %d" % wd
    print "Which is a " + days[wd]
    
def main():
    # date1()
    # datetime1()
    datetime2()


if __name__ == "__main__":
    main()
