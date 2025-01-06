
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class BankingSystem {
    private Map<Integer, Account> accounts;
    public BankingSystem(){
        this.accounts=new HashMap<>();
    }
   public void  createAccount(int accountNumber, String accountHolder,double initialBalance){
       Account account=new Account(accountNumber,accountHolder,initialBalance);
       
       accounts.put(accountNumber, account);
   }
   public void deposit(int accountNumber, double amount){
      Account account=accounts.get(accountNumber);
      if(account != null){
         account.deposit(amount);
      }else{
          System.out.println("Account noy found");
      }
   }
   public void withdraw(int accountNumber, double amount){
       Account account=accounts.get(accountNumber);
       if(account != null){
           account.withdraw(amount);
       }else{
            System.out.println("Account noy found");
       }
   }
   public void transfer(int senderAccountNumber,int recepientAccountNumber,double amount){
      Account sender=accounts.get(senderAccountNumber);
      Account recipient=accounts.get(recepientAccountNumber);
      if(sender !=null && recipient !=null){
         sender.trasfer(recipient, amount);
      }else{
          System.out.println("Account noy found");
      }
   }
   public void printTransactionHistory(int accountNumber){
       Account account=accounts.get(accountNumber);
       if(account !=null){
           account.printTransactionHistory();
       }else{
           System.out.println("Account noy found");
       }
   }
   public void printCustomerInfo(String name){
       Customer customer=customers.get(name);
       if(customer != null){
           System.out.println("Customer name:"+ customer.getName());
           System.out.println("Customer Address" + customer.getAddress());
           System.out.println("Customer phone number" + customer.getPhoneNumber());
       }else{
          System.out.println("Customer not found");
       }
   }
   public static void main(String[] args){
      BankingSystem bankingSystem=new BankingSystem();
      Scanner scanner=new Scanner(System.in);
      while(true){
          System.out.println("1.Create account");
          System.out.println("2.Create customer");
          System.out.println("3.Deposit");
          System.out.println("4.Withdraw");
          System.out.println("5.Transfer");
          System.out.println("6.Print Transaction History");
          System.out.println("7.Print customer info ");
          System.out.println("8..Exit");
          
          System.out.println("Choose an option:");
          
          int option=scanner.nextInt();
          
          switch(option){
              case 1:
                  System.out.println("Enter account number:");
                  int accountNumber=scanner.nextInt();
                  String accountHolder=scanner.next();
                  System.out.println("Enter initial balance");
                  double initialBalance=scanner.nextDouble();
                  bankingSystem.createAccount(accountNumber, accountHolder, initialBalance);
                  break;
              case 2:    
                  System.out.println("Enter customer name");
                  String name=scanner.next();
                  System.out.println("Enter customer address");
                  String address=scanner.next();
                  System.out.println("Enter customer phone number");
                  String phoneNumber=scanner.next();
                  System.out.println("Enter account number");
                  accountNumber=scanner.nextInt();
                  bankingSystem.createCustomer(name,address,phoneNumber,accountNumber);
                  break;
              case 3:
                   System.out.println("Enter account number:");
                   accountNumber=scanner.nextInt();
                   System.out.println("Enter amount to deposit:");
                   double amount=scanner.nextDouble();
                   bankingSystem.deposit(accountNumber, amount);
                   break;
              case 4:
                  System.out.println("Enter account number:");
                  accountNumber=scanner.nextInt();
                  System.out.println("Enter amount to withdraw");
                  amount=scanner.nextDouble();
                  bankingSystem.withdraw(accountNumber, amount);
                  break;
              case 5:
                  System.out.println("Enter sender account number:");
                  int senderAccountNumber= scanner.nextInt();
                  System.out.println("Enter account number:");
                  int receipientAccountNumber=scanner.nextInt();
                  System.out.println("Enter amount to transder:");
                  amount=scanner.nextDouble();
                  bankingSystem.transfer(senderAccountNumber,receipientAccountNumber,amount);
                  break;
              case 6:
                  System.out.println("Enter account number:");
                  accountNumber=scanner.nextInt();
                  bankingSystem.printTransactionHistory(accountNumber);
                  break;
              case 7:
                  System.out.println("Enter customer name:");
                  name=scanner.next();
                  bankingSystem.printCustomerInfo(name);
                  break;
              case 8:
                  System.exit(0);
                  break;
              default:
                  System.out.println("Invaild option");
          }
      }
   }

    private void createCustomer(String name, String address, String phoneNumber, int accountNumber) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
