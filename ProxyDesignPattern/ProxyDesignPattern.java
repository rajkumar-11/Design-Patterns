interface BankAccount {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}

// RealSubject class
class RealBankAccount implements BankAccount {
    private double balance;

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

// Proxy class
class SecureBankAccountProxy implements BankAccount {
    private RealBankAccount realBankAccount;
    private String password;

    public SecureBankAccountProxy(String password) {
        this.password = password;
        authenticate();
    }

    private void authenticate() {
        if (password.equals("secret")) {
            realBankAccount = new RealBankAccount();
            System.out.println("Authentication successful.");
        } else {
            System.out.println("Authentication failed. Access denied.");
        }
    }

    @Override
    public void deposit(double amount) {
        if (realBankAccount != null) {
            realBankAccount.deposit(amount);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (realBankAccount != null) {
            realBankAccount.withdraw(amount);
        }
    }

    @Override
    public double getBalance() {
        return (realBankAccount != null) ? realBankAccount.getBalance() : 0.0;
    }
}


public class ProxyBankExample {
    public static void main(String[] args) {
        // Using the proxy to access the real bank account
        BankAccount account = new SecureBankAccountProxy("secret");

        // Operations
        account.deposit(1000);
        account.withdraw(500);
        double balance = account.getBalance();

        System.out.println("Current Balance: " + balance);
    }
}
