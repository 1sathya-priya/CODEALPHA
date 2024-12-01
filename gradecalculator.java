import java.io.*;
import java.lang.*;
import java.util.Scanner;
public class gradecalculator
{
    public static void main(String args[])throws Exception
    {   
        int n,min,max;
        int avg;
        String res;
        String grade;
        Scanner s=new Scanner(System.in);
        System.out.println("Enter no.of marks:");
        n=s.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++)
        {
            System.out.print("Enter Mark "+(i+1)+" = ");
            a[i]=s.nextInt();
        }
        int sum=0;
        for(int j=0;j<n;j++)
        {
            sum=sum+a[j];
        }
        max=a[0];
        min=a[0];
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>max)
            {
                max=a[i];
            }
        }
        for(int i=0;i<a.length;i++)
        {
            if(a[i]<min)
            {
                min=a[i];
            }
        }
        avg=sum/n;
        res="PASS";
        for(int r=0;r<n;r++)
        {
            if(a[r]<40)
            {
                res="FAIL";
                break;
            }
        }
        if(res.equals("FAIL"))
        {
            grade="FAIL";
        }
        else if(avg>=90)
        {
            grade="O GRADE";
        }
        else if(avg>=80 && avg<90)
        {
            grade="A GRADE";
        }
        else if(avg>=70 && avg<80)
        {
            grade="B GRADE";
        }
        else if(avg>=60 && avg<70)
        {
            grade="C GRADE";
        }
        else if(avg>=50 && avg<60)
        {
            grade="D GRADE";
        }
        else
        {
            grade="E GRADE";
        }
        System.out.println("The Sum of "+n+" marks     = "+sum);
        System.out.println("Highest Marks Secured  = "+max);
        System.out.println("Lowest Marks Secured   = "+min);
        System.out.println("The Average of "+n+" marks = "+avg);
        System.out.println("The Grade for "+n+" marks  ="+grade);

    }
}