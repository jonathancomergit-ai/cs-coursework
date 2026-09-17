public class bankAccount
{
    private int balance = 0;

    bankAccount(int startingBalance)
    {
        this.balance = startingBalance;
    }

    public static void main(String[] args)
    {
        bankAccount myAccount = new bankAccount(500);
        myAccount.deposit(1245);
        myAccount.withdraw(10000);
        System.out.println("Balance: " + myAccount.getBalance());

    }

    public void deposit(int amount)
    {
        balance = balance + amount;
    }

    public void withdraw(int amount)
    {
        if (balance >= amount)
        {
            balance = balance - amount;
        } else
        {
            System.out.println("Insufficient Funds");
        }

    }

    public int getBalance()
    {
        return balance;
    }
}
