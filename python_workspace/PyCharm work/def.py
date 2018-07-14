
def add(arg1,arg2):
    print(arg1+arg2)
def run_something_with_args(a,arg1,arg2):
    a(arg1,arg2)
run_something_with_args(add,14,1)


def run_with_positional_args(func,*args):
    return func(*args)
def sum_args(*args):
    return sum(args)
print(run_with_positional_args(sum_args,1,2,33))

def document_it(func):
    def new_function(*args,**kwargs):
        print('running :',func.__name__)
        print('ppsitional arguments:',args)
        print('keyword:',kwargs)
        result=func(*args,**kwargs)
        print('result:',result)
        return result
    return new_function
@document_it
def mult_ints(a,b):
    return a-b

#cooler_mult_ints=document_it(mult_ints)
#cooler_mult_ints(9,8)

print(mult_ints(5,3))

print('globals:',globals())