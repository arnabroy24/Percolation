import java.util.*;
import java.lang.*;
import java.math.*;


public class Networking {

    private int[] friends;
    private int[] time;
    int tick = 0;

    public Networking(int n) {
        friends = new int[n];
        time = new int[n];
        for (int i = 0; i < n; i++) {
            friends[i] = i;
            time[i] = 0;

        }

    }

    private int root(int p)

    {
        if (p != friends[p])
            p = friends[p];
        return p;

    }

    public void connect(int n)
    {
        ++tick;

        int a = 0+(int)(Math.random()*n);
        int b = 0+(int)(Math.random()*n);
        if (time[a] < time[b]) {
            friends[b] = a;
            time[a] = tick;
        }
        else if (time[a] > time[b]) {
            friends[a] = b;
            time[b] = tick;
        }
        else
        {
            friends[a] = b;
            time[b] = tick;
            time[a] = tick;
        }

        System.out.println("Connection made at  "+a+" and "+b+" at "+ tick);


    }

    public int check(int n)
    {
        int ct=0;
        for(int i=0;i<n;i++)
        {

            if (time[i] > 0)
                ct++;
        }

        if(ct==6)
            return 0;
        else
            return 1;



    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of friends");

        int n = sc.nextInt();

        Networking wq = new Networking(n);

        int choice = 1;


        while(choice!=0)
        {


            wq.connect(n);
          choice= wq.check(n);


        }

        if(choice==0)
            System.out.println("ALl connections are made");


    }

}