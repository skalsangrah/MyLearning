from datetime import date
from datetime import time
from datetime import datetime
from datetime import timedelta

print timedelta(days=365, hours=5, minutes=1)
print "Today is " + str(datetime.now())

# delta one year from today
print "one year from now would be " + str(datetime.now() + timedelta(days=365))

print "2 weeks and 2 days from now would be " + str(datetime.now() + timedelta(weeks=2, days=2))

# one week ago and formatted
t = datetime.now() - timedelta(weeks=1)
 
print "1 weeks ago from now was " + t.strftime("%A %B %d, %Y")

# when is next april fool day, 1at April every year
today = date.today()
afd = date(today.year, 4, 1)

if (afd < today):
    print "AFD is gone for this year " + str(today.year) + " by " + str ((afd - today).days) + " days"
    afd.replace(year=today.year + 1)

print str(abs(afd - today).days) + " days to go for next april fool day"
