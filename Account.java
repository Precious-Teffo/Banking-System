
import java.util.ArrayList;
import java.util.List;


public class Account {
    private int accountNumber;
    private String accountHolder;
    private double balance;
    private List<Transaction> transaction;
    
    public Account(int accountNumber,String accountHolder,double initialBalance){
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
        this.balance=initialBalance;
        
        this.transaction=new ArrayList<>();
    }
    public int getAccountNumber(){
        return accountNumber;
    }
    public String getAccountHolder(){
        return accountHolder;
    }
    public double getBalance(){
       return balance; 
    }
    public void deposit(double amount){
        balance +=amount;
        transaction.add(new Transaction("Deposit", amount));
    }
    public void withdraw(double amount){
        if(balance >= amount){
         balance -= amount;
         
         transaction.add(new Transaction("Withdrawal",amount));
        }else{
            System.out.println("Insufficient balance");
        }
    }
    public void trasfer(Account recipient,double amount){
    if(balance >= amount){
        balance -= amount;
       }else{
        System.out.println("Insufficient balance");
     }
    }
    public void printTransactionHistory(){
        System.out.println("Transaction History for Account" + accountNumber);
        Iterable<Transaction> Transaction = null;
        for(Transaction transaction: Transaction ){
            System.out.println(transaction);
        }
    }
}
