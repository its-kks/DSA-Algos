def partition(left,right,arr):
    pivot=arr[right]
    i,j=left-1,left
    while(j!=right):
        if(arr[j]<pivot):#for smallest
        # if(arr[j]>pivot):#for largest
            #swap
            i+=1
            arr[i],arr[j]=arr[j],arr[i]
        j+=1
    arr[i+1],arr[j]=arr[j],arr[i+1]
    return i+1
def quickSelect(k,arr,left,right):
    if(k>len(arr) or k<=0):
        print("k is out of bound")
    else:
        pvIndex=partition(left,right,arr)
        if(pvIndex==k-1):
            return arr[pvIndex]
        elif(pvIndex>k-1):
            return quickSelect(k,arr,left,pvIndex-1)
        else:
            return quickSelect(k,arr,pvIndex+1,right)
arr = [5, 2, 9, 1, 7, 6, 3]
k = 3  # Finding the 3rd smallest element

result = quickSelect(k, arr, 0, len(arr) - 1)
print(f"The {k}th smallest/largest element is: {result}")