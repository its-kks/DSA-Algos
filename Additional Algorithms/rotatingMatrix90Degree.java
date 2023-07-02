import java.util.Scanner;
public class rotatingMatrix90Degree {
    public static void flipVertical(int matrix[][]){
        int row=matrix.length;
        int col=matrix[0].length;
        for(int j=0;j<row;j++){
            for(int i=0;i<=(col-1)/2;i++){
                int temp=matrix[j][i];
                matrix[j][i]=matrix[j][col-i-1];
                matrix[j][col-i-1]=temp;
            }
        }
    }
    public static void flipHorizontal(int matrix[][]){
        int row=matrix.length;
        int col=matrix[0].length;
        for(int j=0;j<(row-1)/2;j++){
            for(int i=0;i<col;i++){
                int temp=matrix[j][i];
                matrix[j][i]=matrix[row-j-1][i];
                matrix[row-j-1][i]=temp;
            }
        }
    }
    public static void flipDiagonal(int matrix[][]){
        int row=matrix.length;
        int col=matrix[0].length;
        int i=0;
        int j=0;
        for(;i<row;i++){
            for(;j<col;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
            i++;
            j++;
        }
    }
    public static void rotate(int matrix[][],int angle){
        int row=matrix.length;
        int col=matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("");
        int neg=0;
        if(angle<0){
            neg=1;
            angle*=-1;
        }
        angle=angle%360;
        if(neg==1){
            angle=360-angle;
        }
        if(angle ==90){
            //flipping \ after vertical filpping
            flipVertical(matrix);
            flipDiagonal(matrix);

        }
        else if(angle==180){
            //flipping horizontally after vertical flipping
            flipVertical(matrix);
            flipHorizontal(matrix);
        }
        else if(angle==270){
            //flipping \ after horizontal flipping
            flipHorizontal(matrix);
            flipDiagonal(matrix);
        }
        else{
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }
    public static int valueInput() throws Exception{
        System.out.print("Enter value:");
        Scanner input=new Scanner(System.in);
        int angle=input.nextInt();
        if(angle%90!=0){
            throw new Exception("Invalid Input!");
        }
        return angle;
    }
    public static void main(String args[]){
        //rotate matrix having column==row
        //by any angle given in degree that is multiple of 90
        int matrix[][]=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int angle=0;
        try{
            angle=valueInput();
        }
        catch(Exception e){
            System.out.println(e);
            return;
        }
        rotate(matrix,angle);
    }
}
