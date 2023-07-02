#using efficient implementatio using 3 arrays
class KStacks:
    def __init__(self,k,n):
        self.k=k #k=no of stack
        self.arrayTop=[]
        self.arrayMain=[i+1 for i in range(n-1)]
        self.arrayMain.append(-1)
        self.top=[-1]*k
        

