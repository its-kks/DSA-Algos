import sys
noInputs=int(input("No of inputs:"))
def maxDifference(array):
    array.sort()
    if(len(array)==1):
        return array[0]
    max=sys.maxsize*-1-1
    for i in range(0,len(array)-1):
        if(max<array[i+1]-array[i]-1):
            max=array[i+1]-array[i]-1
    return max
while(noInputs!=0):
    noInputs-=1
    whn=input("whn:")
    whn=whn.split(' ')
    width=int(whn[0])
    height=int(whn[1])
    noTowers=int(whn[2])
    widths=[]
    heights=[]
    widths.append(0)
    heights.append(0)
    for i in range(0,noTowers):
        wh=input("wh:")
        wh=wh.split(' ')
        widths.append(int(wh[0]))
        heights.append(int(wh[1]))
    widths.append(width+1)
    heights.append(height+1)
    print(maxDifference(widths)*maxDifference(heights))