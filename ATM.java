import java.io.*;
import java.util.*;
public class ATM 
{
    public int pinid,count;
    public String cname;
    private int pin,amt;
    private String name;
public void createAccount(int amt,String name)
{
    this.name=name;
    Scanner s=new Scanner(System.in);
    System.out.print("Name : "+this.name+"\n");
    this.pin=new Random().nextInt(1000,9999);
    System.out.print("Your PIN number : "+this.pin+"\n");
    System.out.print("Ace deposit : Rs."+amt+"\n");
    System.out.println("Account Created Successfully !");
}
public void DepositAmount(int amt)
{
    Scanner s=new Scanner(System.in);
    count=0;
    while (true) {
        count=count+1;
        System.out.println("Enter PIN number : ");
        pinid=s.nextInt();
        System.out.println("Enter Name : ");
        cname=s.next();
        if(pinid==this.pin && cname.equals(this.name))
        {
            this.amt+=amt;
            System.out.println("Account Deposited Successfully !");
            break;
        }
        else if(count==3)
        {
            System.out.println("Your card is blocked...try again");
            break;
        }
        else
        {
            System.out.println("Invalid name or pin id entered..");
        }
    }
}
public void WithdrawAmount(int amt)
{
    count=0;
    Scanner s=new Scanner(System.in);
    while (true) 
    {
        count=count+1;
        System.out.println("Enter PIN number : ");
        pinid=s.nextInt();
        System.out.println("Enter Name : ");
        cname=s.next();
        if(pinid==this.pin && cname.equals(this.name))
        {
            if(this.amt<amt)
            {
                System.out.println("Inavailable fund..try again");
            }
            else
            {
            this.amt-=amt;
            System.out.println("Account Withdrawn Successfully !");
            }
            break;
        }
        else if(count==3)
        {
            System.out.println("Your card is blocked...try again");
            break;
        }
        else
        {
            System.out.println("Invalid name or pin id entered..");
        }
    }
}
public void Balance()
{
    count=0;
    Scanner s=new Scanner(System.in);
    while (true) {
        count=count+1;
        System.out.println("Enter PIN number : ");
        pinid=s.nextInt();
        System.out.println("Enter Name : ");
        cname=s.next();
        if(pinid==this.pin && cname.equals(this.name))
        {
            System.out.println("Your Current Balance : "+this.amt );
            break;
        }
        else if(count==3)
        {
            System.out.println("Your card is blocked...try again");
            break;
        }
        else
        {
            System.out.println("Invalid name or pin id entered..");
        }
    }
}
    public static void main(String[] args) 
    {
    int ch,amts;
    String name;    
    ATM m=new ATM();
    Scanner s=new Scanner(System.in);
    boolean flag=true;
    do
    {
        System.out.println("************************");
        System.out.println("1.Create Account");
        System.out.println("2.Deposit Amount");
        System.out.println("3.Withdraw Account");
        System.out.println("4.Current Balance");
        System.out.println("5.Exit");
        System.out.println("************************");
        System.out.println("Enter your choice : ");
        ch=s.nextInt();
        if(ch==5)
        {
            System.out.println("Exit..");
            flag=false;
            break;
        }
        else
        {
        switch (ch) 
        {
            case 1:
                System.out.println("Enter Ace Deposit : ");
                amts=s.nextInt();
                System.out.println("Enter Name : ");
                name=s.next();
                m.createAccount(amts,name);
                break;
             case 2:
                System.out.println("Enter Deposit amount : ");
                amts=s.nextInt();
                m.DepositAmount(amts);
                break;
            case 3:
                System.out.println("Enter Withdraw amount : ");
                amts=s.nextInt();
                m.WithdrawAmount(amts);
                break;  
            case 4:
                m.Balance();
                break; 
            default:
                System.out.println("Ivalid Input..");
                break;
        }
    }
  }while(flag=true);
}
}