import java.lang.*;
import java.util.*;
// Weighted Quick Union Creates a tree which is quite evenly weighted out
public class WeightedQU {

    private int[] id;
    private int[] size;

    public WeightedQU(int n)
    {
        id =new int[n];
        size = new int[n];

        for (int i=0;i<n;i++)
        {
            id[i]=i;
            size[i]=1;
        }
    }

    private int root(int p)
    {
        if(p!=id[p])
            p=id[p];
        return p;
    }

    public boolean check(int p, int q)
    {
        if(root(p)==root(q))
            return true;
        else
            return false;
    }

    public void union(int p , int q)
    {
        int a =root(p);
        int b = root(q);
        if(size[a]<size[b])
        {
            id[b]=a;
            size[a]+=size[b];
        }
        else if ( size[a]>size[b])
        {
            id[a]=b;
            size[b]+=size[a];
        }
        else
        {
            id[a]=b;
            size[b]+=1;
        }

    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of entries");
        int n=sc.nextInt();

        WeightedQU wq = new WeightedQU(n);
        int a ,b;
        int choice =1;

        while(choice!=0)
        {
            System.out.println("Enter 1 for connection and 2 for checking connections , 0 for exit");

            choice = sc.nextInt();



            switch (choice)
            {
                case 0: choice =0;
                    break;
                case 1 :  System.out.println("enter the two values");
                    a = sc.nextInt();
                    b = sc.nextInt();
                    wq.union(a,b);
                    System.out.println("Connection completed");
                    break;
                case 2 : System.out.println("enter the two values");
                    a = sc.nextInt();
                    b = sc.nextInt();


                    if(wq.check(a,b)==true)
                        System.out.println("Connection Presenet");
                    else
                        System.out.println("Nt present");
                    break;


            }
            if ( choice==0)
                break;
        }
    }

    }










