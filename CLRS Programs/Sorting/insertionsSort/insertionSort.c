#include <stdio.h>
void insertionSort(int ar[],int size){
    int i,j;
    for(i=1;i<size;i++){
        int temp=ar[i];
        for(j=i-1;j>=0 && ar[j]>temp;j--){
            ar[j+1]=ar[j];

        }
        ar[j+1]=temp;
    }
}
int main()
{
    int s1;
    scanf("%d",&s1);
    int array[s1];
    for(int i=0;i<s1;i++)
        scanf("%d",&array[i]);
    insertionSort(array,s1);
    for(int i=0;i<s1;i++)
        printf("%d ",array[i]);
return 0;
}