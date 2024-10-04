public class FixedDepositAccount extends BankAccount {
    private float interest;
    private int duration;
    private boolean interestAndDurationChanged;

    // Constructor with default interest and duration
    public FixedDepositAccount(String name, float balance) {
        super(name, balance);
        this.interest = 3;
        this.duration = 6;
        this.interestAndDurationChanged = false;
    }

    // Constructor with custom interest
    public FixedDepositAccount(String name, float balance, float interest) {
        this(name, balance);
        setInterestAndDuration(interest, 6);
    }

    // Constructor with custom interest and duration
    public FixedDepositAccount(String name, float balance, float interest, int duration) {
        this(name, balance);
        setInterestAndDuration(interest, duration);
    }

    // Method to set interest and duration (can only be set once)
    public void setInterestAndDuration(float interest, int duration) {
        if (interestAndDurationChanged) {
            throw new IllegalArgumentException("Interest and duration can only be set once.");
        }
        this.interest = interest;
        this.duration = duration;
        this.interestAndDurationChanged = true;
    }

    // Override deposit method (NOP)
    @Override
    public void deposit(float amount) {
        logTransaction("Deposit operation is not allowed in FixedDepositAccount.");
    }

    // Override withdraw method (NOP)
    @Override
    public void withdraw(float amount) {
        logTransaction("Withdraw operation is not allowed in FixedDepositAccount.");
    }

    // Override getBalance to include interest
    @Override
    public float getBalance() {
        return super.getBalance() + (super.getBalance() * (interest / 100));
    }
}
