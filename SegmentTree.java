/*********************************************************************************************************************
     **
     **  Segment Tree Algorithm
     **  Array is used to store tree
	 **  Tree is start from index 1
     **  Input in the form of array
     **  Output is minimum number between [i,j)
     
     **  Written By:    Akash Vishwas Londhe
     **
*********************************************************************************************************************/

//import package
import java.util.*;
import java.math.*;

public class Main
{
    static int []a;
    static int n;
    static int []tree;
    
    //creation of segment tree
    public static void segTree()
    {
        tree=new int[2*n];
        for(int i=n;i<2*n;i++)
            tree[i]=a[i-n];
        for(int i=n-1;i>0;i--)    
            tree[i]=Math.min(tree[2*i],tree[2*i+1]);
    }
    
    //query to find Minimum
    public static int query(int l,int r)
    {
        l+=n;
        r+=n;
        int sum=Integer.MAX_VALUE;
        while(l<r)
        {
            if((l&1)==1)
            {
                sum=Math.min(sum,tree[l]);
                l++;
            }
            if((r&1)==1)
            {
                r--;
                sum=Math.min(sum,tree[r]);
            }
            l>>=1;
            r>>=1;
        }
        return sum;
    }
    
    //update query
    public static void update(int i,int val)
    {
        i+=n;
        tree[i]=val;
        
        while(i>1)
        {
            i/=2;
            tree[i]=Math.min(tree[2*i],tree[2*i+1]);
        }
    }
    
    //main program
	public static void main(String[] args) 
	{
	    Scanner scan=new Scanner(System.in);
	    
	    //number of elements in an array
	    n=5;//scan.nextInt();
	    a=new int[]{5,2,3,1,4};
	    
	    //for(int i=0;i<n;i++)
	      //  a[i]=scan.nextInt();
	        
	    //create an segment tree     
	    segTree();     
	    
	    //update value in array at index i by value p
	    update(3,10);
	    
	    //number of queries
	    int q=scan.nextInt();
	    for(int i=0;i<q;i++)
	    {
	        int a=scan.nextInt();
	        int b=scan.nextInt();
	        int ans=query(a,b);
	        System.out.println("Minimum of Substring from "+a+" to "+b+" is : "+ans);
	    }
	    
	}
}
