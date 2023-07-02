import math as m
no=int(input("Enter no of items:"))
array=[]
for i in range(0,no):
    array.append(int(input("Value "+str(i+1)+":")))
array.sort()
def rearrangeMaxAbs(array):
    if(len(array)<=2):
        return
    mid=m.floor(len(array)/2)
    i=0
    while(mid!=0):
        value=array.pop()
        array.insert(i+1,value)
        i+=2
        mid-=1
rearrangeMaxAbs(array)
print(array)
sum=0
for i in range(0,len(array)-1):
    sum+=abs(array[i]-array[i+1])
sum+=abs(array[0]-array[len(array)-1])
print(f"Max sum is {sum}")