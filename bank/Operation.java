package bank;
import java.sql.Timestamp;

public class Operation {
    private OperationType type;
    private double amount;
    private Timestamp date;

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
