package katajava.src.main.java.com.katajava.bank;
import java.sql.Timestamp;

public class Operation {
    private OperationType type;
    private double amount;
    private Timestamp date;

    public Operation(OperationType type, double ammount) {
        this.amount = ammount;
        this.type = type;
        this.date = new Timestamp(System.currentTimeMillis());
    }

    protected OperationType getType() {
        return type;
    }

    protected double getAmount() {
        return amount;
    }

    protected Timestamp getDate() {
        return date;
    }
}
