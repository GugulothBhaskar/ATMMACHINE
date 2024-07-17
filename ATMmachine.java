import java.time.LocalDate;
import java.util.*;
public class ATMmachine//MAIN CLASS
{
 
public static void main(String args[])//MAIN METHOD
{
  
  ATM obj=new ATM();//CREATING OBJECT BY ATM CLASS
obj.pinchecker();//CALLING METHOD USING OBJECT
}
}
class ATM
{
  int count=0; //INITIALISNIG COUNT TO 0
int transactions=0;//INITIALISING  TRANSACTIONS TO 0
String transactionhistory= "";//INITIALISING TRANSACTIONHISTORY TO EMPTY
float balance;//INITIALISING BALANCE OF TYPE FLOAT
Scanner sc=new Scanner(System.in);
LocalDate date= LocalDate.now();
public int pin=7890;//INITIALISING PIN TO 7890
 void pinchecker()//METHOD TO CHECK WHETHER THE PIN IS CORRECT OR NOT
{
 
System.out.println("Please,Enter your ATM pin to continue...");
int pinn=sc.nextInt();
if(pinn==pin)
{
menu();
}
else if(count<=2)
{
  count++;
System.out.println("INVALID ATM PIN");
   pinchecker();
}
else
{
  System.out.println("Your Account is BLOCKED,You have entered WRONG PIN too many times");
}
}

public void menu()
{
System.out.println("Welcome to ATM Banking!!...");
Scanner sc=new Scanner(System.in);
System.out.println("Select the operation you want to perform...");
System.out.println("1. Account balance inquiry");
System.out.println("2. Cash withdrawal");
System.out.println("3. Cash deposit");
System.out.println("4. PIN change");
System.out.println("5. Transaction history");
System.out.println("6. EXIT");
System.out.println(" ");
int opt=sc.nextInt();
if(opt==1)
{
  System.out.println(" ");
balanceinquiry();
}
else if(opt==2)
{
  System.out.println(" ");
cashwithdrawal();
}
else if(opt==3)
{
  System.out.println(" ");
cashdeposit();
}
else if(opt==4)
{
pinchange();
}
else if(opt==5)
{
  System.out.println(" ");
ministatement();
}
else if(opt==6)
{
   System.exit(0);
}
else
{
System.out.println("Please,Enter a valid option to perform the operation");
menu();
}
}
void balanceinquiry()//METHOD TO DISPLAY A/C BALANCE
{
  System.out.println("ACCOUNT BALANCE "+balance);
  System.out.println(" ");
  menu();
  
}
void cashwithdrawal()//METHOD TO WITHDRAW MONEY
{
  System.out.println("Enter Amount to Withdraw");
  System.out.println("Only multiples of 100");

  int amount=sc.nextInt();
  try
  {
  if(amount<=balance&&amount%100==0)//CONDITIONS FOR WITHDRAW
  {
    transactions++;//INCREMENT
    System.out.println("COLLECT CASH");
    balance-=amount;
    System.out.println("Dear user your A/C debited for RS:"+amount+" on "+date+"\n");
    System.out.println("Current balance "+balance);
    String str = amount + "Rs Withdrawn on "+date+"\n";
    transactionhistory=transactionhistory.concat(str);
    System.out.println(" ");
    menu();
  }
  else if(amount%100!=0)
  {
    System.out.println("Enter only multiples of 100");
    menu();
  }
  else 
  {
      System.out.println("INSUFFICIENT BALANCE!!...");
      System.out.println(" ");
      menu();
  }
}
catch (Exception e)
{

}

}
void cashdeposit()//METHOD TO DEPOSIT MONEY
{
  try 
  {
    
  System.out.println("Enter Amount to Deposit");
  System.out.println("Only multiples of 100");
  int amount=sc.nextInt();
  if(amount%100==0)
  {
  transactions++;
  balance+=amount;
  System.out.println("Dear user your A/C credited RS: "+amount+" on "+date+"\n");
  System.out.println("Current balance "+balance);
  String str = amount + "Rs Cashdeposited on "+date+"\n";
    transactionhistory=transactionhistory.concat(str);
  System.out.println(" ");
  menu();
  }
  else
  {
    System.out.println("Enter only multiples of 100");
    System.out.println(" ");
    menu();
  }
  }

  catch (Exception e)
  {

  }
}
 void pinchange()//METHOD TO CREATE NEW PIN
{
  System.out.println("Enter new pin to change");
  int pinn=sc.nextInt();
  System.out.println("Confirm your pin");
  int enteredpin=sc.nextInt();
  if(pinn==enteredpin)
  {
    pin=pinn;
    System.out.println("PIN CHANGED SUCCESSFULLY");
    System.out.println(" ");
    menu();
  }
  else
  {
    System.out.println("WRONG PIN");
    System.out.println(" ");
    menu();
  }
}
void ministatement()//METHOD TO DISPLAY TRANSACTON HISTORY
{
  if(transactions==0)
  {
    System.out.println("YOU HAVE NO PREVIOUS TRANSACTIONS");
    
  }
  else
  {
    System.out.println("TRANSACTION DEATAILS");
    System.out.println("\n"+transactionhistory);
    menu();
  }
}

}

