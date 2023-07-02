#include <stdio.h>
void select_sort(int s1,int array[s1])
{
    for(int i=0;i<s1-1;i++)
    {
        int small=array[i],index=i;
        for(int j=i+1;j<s1;j++)
        {
            if(small>array[j])
            {
                small=array[j];
                index=j;
            }
        }
        array[index]=array[i];
        array[i]=small;
    }
}
int main()
{
    int s1;
    scanf("%d",&s1);
    int array[s1];
    for(int i=0;i<s1;i++)
        scanf("%d",&array[i]);
    for(int i=0;i<s1;i++)
        printf("%d ",array[i]);
    select_sort(s1, array);
    printf("\n");
    for(int i=0;i<s1;i++)
        printf("%d ",array[i]);
return 0;
}