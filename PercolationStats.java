import java.util.*;

public class PercolationStats {

    private int[][] array;

    int size; int trialss;

    private int[] fractions;

    public PercolationStats(int n,int trials)
    {
        trialss=trials;
        size=n;
        array=new int[n][n];
        fractions = new int[n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                array[i][j] = 1;     //1 stands for blocked and 0 for open
        }
        for(int k=0;k<trials;k++) {
            int counter=0;
            do {
                int row = 0 + (int) (Math.random() * (n-1));
                int column = 0 + (int) (Math.random() * (n-1));
                open(row,column);
                counter+=1;
            } while (percolates() != true);
            System.out.println("Percolation is completed");
            fractions[k]=counter;
        }
    }

    public void open(int row,int column)
    {
        array[row][column]=0;

    }

    public boolean isOpen(int row,int column)
    {
        if(array[row][column]==0)
            return true;
        else
            return false;

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

    public double mean()
    {
        double summ=0;
      for(int i=0;i<trialss;i++)
      {
        summ+=fractions[i] ;
      }

      summ=summ/(trialss*trialss);
      return summ;

    }

    public double stddev()
    {
        double mean=mean();

        double std=0;
        for(int i=0;i<trialss;i++)
        {
            std+=Math.pow(fractions[i]-mean,2);
        }

        std=Math.sqrt(std/(trialss-1));

        return std;
    }

    public double ConfidenceLo()
    {
       double mean,stddev,lo;
       mean=mean();
       stddev=stddev();

       lo= mean - ((1.96*stddev)/Math.sqrt(trialss));

       return lo;

    }

    public double ConfidenceHi()
    {
        double mean,stddev,lo;
        mean=mean();
        stddev=stddev();

        lo= mean + ((1.96*stddev)/Math.sqrt(trialss));

        return lo;

    }

    public static void main(String args[])
    {
        Scanner sc =new Scanner(System.in);
        int size,stats;
        System.out.println("Enter the lattice size and the number of times it is to be used to calculate stats");
        size=sc.nextInt();
        stats=sc.nextInt();

        PercolationStats ps = new PercolationStats(size,stats);

        System.out.println("The mean for the "+stats+" number if trials is "+ ps.mean());
        System.out.println("The standard deviation for the "+stats+" number if trials is "+ ps.stddev());
        System.out.println("The ConfidenceLo for the "+stats+" number if trials is "+ ps.ConfidenceLo());
        System.out.println("The ConfidenceHi for the "+stats+" number if trials is "+ ps.ConfidenceHi());
    }










































}
