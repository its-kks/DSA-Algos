#calculating nCr using pascals triangle
import math as m
def nCr(n, r):
    if(r>n or n<0 or r<0):
        return None
    minVal = min(r,n-r)
    arr = [0,1]
    for i in range(1,minVal+1):
        arr.append(0)
    for j in range(0,n):
        for i in range(len(arr)-1,0,-1):
            new = arr[i]+arr[i-1]
            arr[i] = new
    return arr[minVal+1]
def factorial(n):
    #tabulated
    dp = [-1 for i in range(n+1)]
    for i in range(0,n+1):
        if(i==0 or i==1):
            dp[i] = 1
            continue
        dp[i] = i*dp[i-1]
    return dp[n]
def nPr(n,r):
    #since nPr = r! * nCr
    return factorial(r) * nCr(n,r)
print(nPr(5,3))