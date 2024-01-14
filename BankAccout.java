public class BankAccout {
    String accNumber;
    String ssNumber;
    int balance=0;
    public BankAccout(String acc,String ss,int bal){
        accNumber=acc;
        ssNumber=ss;
        balance =bal;
    }
    public int deposit(int amount)
    {
        balance +=amount;
        return balance;
    }
    public int withdraw(int amount){
        balance -=amount;
        return balance;
    }
    public int checkMybalance()
    {
        System.out.println("잔액 :"+balance);
        return balance;
    }
}

class PassingRef{
    public static void main(String[] argc)
    {
        BankAccout ref=new BankAccout("12-34-89","990990-1232345",2313);
        ref.deposit(3000);
        ref.withdraw((300));
        check(ref); //참조값 전달
    }
    public static void check(BankAccout acc){
        acc.checkMybalance();
    }
}
