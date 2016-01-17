
import calendar
# c = calendar.TextCalendar(calendar.SUNDAY)
# str = c.formatmonth(2013, 1, 0, 0)
# print str

# c = calendar.HTMLCalendar(calendar.SUNDAY)
# str = c.formatmonth(2013, 1, 0, 0)
# print str

# c = calendar.TextCalendar(calendar.SUNDAY)
# for i in c.itermonthdays(2013, 8):
#     print i

# for name in calendar.month_name:
#     print name
#     
# for day in calendar.day_name:
#     print day

# First friday comes evey month

for m in range (1, 13):
    cal = calendar.monthrange(2015, m)
    
    weekone = cal[0]
    weektwo = cal[1]
    if weekone[calendar.FRIDAY] != 0 :
        meetday = weekone[calendar.FRIDAY]
    else:
        # if first friday isnt in first week then it must be in second
        meetday = weektwo[calendar.FRIDAY]
    print ("%10s %2d" % (calendar.month_name[m], meetday))
    
