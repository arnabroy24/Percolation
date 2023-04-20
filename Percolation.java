import java.util.Scanner;

public class Percolation {

    private int[][] array;
    int open_counter=0;
    int size;

    public Percolation(int n)
    {
        size=n;
        array=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                array[i][j] = 1;     //1 stands for blocked and 0 for open
        }
    }

    public void open(int row,int column)
    {
        array[row][column]=0;
        open_counter++;
    }

    public boolean isOpen(int row,int column)
    {
        if(array[row][column]==0)
            return true;
        else
            return false;
    }

    public boolean isClose(int row,int column)
    {
        if(array[row][column]==1)
            return true;
        else
            return false;
    }

    public int numberOfOpen()
    {
        return open_counter;
    }

    public boolean percolates()
    {
        int ct=0;
        for (int i=0;i<size;i++) {
            for (int j = 0; j < size; j++) {

                int row1 = j;
                int column1 = i;

                while (isOpen(row1, column1) == true && (ct!=(size-1))) {
                    ct += 1;
                    if (column1 == 0) {
                        if (isOpen(row1 + 1, column1) == true)
                            row1 += 1;
                        if (isOpen(row1 + 1, column1 + 1)) {
                            row1 += 1;
                            column1 += 1;
                        }

                    } else if (column1 == (size - 1)) {
                        if (isOpen(row1 + 1, column1) == true)
                            row1 += 1;
                        if (isOpen(row1 + 1, column1 - 1)) {
                            row1 += 1;
                            column1 -= 1;
                        }

                    }
                    else if(row1==(size-1))
                    {
                        break;



                    }






                    else {
                        if (isOpen(row1 + 1, column1) == true)
                            row1 += 1;
                        else if (isOpen(row1 + 1, column1 + 1)) {
                            row1 += 1;
                            column1 += 1;
                        }
                        else {
                            row1 += 1;
                            column1 -= 1;
                        }


                    }


                }
            }
        }

        if(ct==(size-1))
            return  true;
        else
            return  false;

    }


    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the the n for the N X N matrix");
        int n=sc.nextInt();

        Percolation pc=new Percolation(n);

        int choice =1;

        while(choice!=0)
        {   int row,column;
            System.out.println("Press 1 to perform joining");
            System.out.println("Press 2 to check if open");
            System.out.println("Press 2 to check if close");
            System.out.println("Press 4 to check if percolates");
            System.out.println("Press 5 to print table");

            choice=sc.nextInt();

            switch (choice)
            {

                case 1: System.out.println("Enter the row and column");
                         row=sc.nextInt();
                         column= sc.nextInt();

                        pc.open(row,column);
                        break;
                case 2: System.out.println("Enter row and column");
                         row=sc.nextInt();
                         column= sc.nextInt();
                         if(pc.isOpen(row,column)==true)
                             System.out.println("The cell is open");
                         else
                             System.out.println("The cell is not open");
                         break;
                case 3: System.out.println("Enter row and column");
                        row=sc.nextInt();
                        column= sc.nextInt();
                        if(pc.isClose(row,column)==true)
                        System.out.println("The cell is close");
                         else
                         System.out.println("The cell is not close");
                         break;
                case 4: if(pc.percolates()==true)
                         System.out.println("Yes it percolates \n");
                         else
                           System.out.println("No it doesnt percolate\n");
                         break;
                case 5:
                        for(int i=0;i<n;i++)
                        { for(int j=0;j<n;j++)
                                System.out.print(pc.array[i][j]);
                        System.out.println("\n");}
                        break;

            }




        }
    }



}


