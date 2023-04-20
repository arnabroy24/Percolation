import java.lang.*;
import java.util.*;

public class QuickFindUF {
    private int[] entries;

    public QuickFindUF(int n) {
        entries = new int[n];
        for (int i = 0; i < n; i++) {
            entries[i] = i;
        }
    }

    public boolean isConnected(int p, int q) {
        if (entries[p] == entries[q])
            return true;
        else
            return false;


    }

    public void Union(int p, int q) {
        int pid = entries[p];
        int qid = entries[q];
        for (int i = 0; i < entries.length; i++)
            if (entries[i] == pid)
                entries[i] = qid;

    }


    public static void main(String args[])
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Emter the number of entries");
        int n = obj.nextInt();
        QuickFindUF qk =new QuickFindUF(n);
       int choice=1;
       while(choice!=0) {
           System.out.println("ENter 1 for perform Union and 2 for check and 0 to exit");
           choice = obj.nextInt();

           System.out.println("Enter the 2 values");
           int p = obj.nextInt();
           int q = obj.nextInt();
           switch (choice) {
               case 1:
                   qk.Union(p, q);
                   System.out.println("Connection done");
                   break;
               case 2:
                   boolean condn = qk.isConnected(p, q);
                   if (condn == true)
                       System.out.println("Yes Connection is present");
                   else
                       System.out.println("No connection is present");
                   break;
               case 0:
                   System.exit(0);
           }
       }

    }
}


