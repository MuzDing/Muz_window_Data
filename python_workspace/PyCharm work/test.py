years_list=[1997,1998,1999,2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010,2011,2012,2013,2014,2015,2016,2017]
print(len(years_list))

print('三岁那年生日是'+str(years_list[3]))
print('年纪最大的是'+ str(years_list[len(years_list)-1]))
thing=['mozzarella','cinderella','salmonella']
print(thing)
thing[0]=thing[0].title()
thing[1]=thing[1].title()
thing[2]=thing[2].title()
print(thing)

thing[thing.index('Mozzarella')]=thing[thing.index('Mozzarella')].upper()
print(thing)

surprise =['Groucho','Chico','Harpo']

e2f={'dog':'chien','cat':'chat','walrus':'morse'}

print(e2f.get('walrus','not a python'))

f2e=e2f.copy()

print(f2e)

print(list(e2f.keys()))

disaster = True
small = False
if disaster:
    print("1")
    if small:
        print("2")
    else :
        print("3")

color = "blue"
if color == "red":
    print("1")
elif color == "green":
    print("2")
elif color == 'blue':
    print("3")