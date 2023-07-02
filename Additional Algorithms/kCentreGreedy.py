def selectKcities(n, weights,k):
    dist=[0]*n
    centres=[]
    for i in range(n):
        dist[i]=10**9
    max=0