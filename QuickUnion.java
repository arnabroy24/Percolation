import javax.sound.midi.SysexMessage;
import java.lang.*;
import java.util.*;

public class QuickUnion {

    private int [] id;

    public QuickUnion(int n)
    {
        id=new int[n];
        for(int i=0;i<n;i++)
            id[i]=i;
    }

    private int root(int i)
    {
        if(i!=id[i])
            i=id[i];
        return i;
    }

    public boolean check(int p,int q)
    {
        if(root(p)==root(q))
            return true;
        else
            return false;
    }

    public void union(int p,int q)
    {
        int i=root(p);
        int j = root(q);
        id[i]=j;
    }

    public static void main(String args[])
    {  int a,b;
        System.out.println("Enter the entries");
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();

        QuickUnion qu =new QuickUnion(n);
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
                         qu.union(a,b);
                         System.out.println("Connection completed");
                         break;
                case 2 : System.out.println("enter the two values");
                          a = sc.nextInt();
                          b = sc.nextInt();


                    if(qu.check(a,b)==true)
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
