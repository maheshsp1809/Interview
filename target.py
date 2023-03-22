def searchInsert(n,t):
        i=0
        j=len(n)-1    
        while(i<=j):
            mid=i+(j-i)//2
            if t==n[mid]:
               return mid
            elif t>n[mid]:
                i=mid+1
            else:
                j=mid-1
        return i 
n=[-1,0,5]
t=-2
print(searchInsert(n,t))