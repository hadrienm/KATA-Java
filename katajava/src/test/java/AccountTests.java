import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.katajava.bank.Account;
import com.katajava.bank.Operation;
import com.katajava.bank.OperationType;

public class AccountTests {

    @Test
    public void updateBalance() throws IllegalAccessException, InvocationTargetException {
        Account account = new Account("adrien", "heros");

        getUpdateBalanceMethod().invoke(account, 20);

        Assertions.assertEquals(getGetBalanceMethod().invoke(account), 20.0);
    }

    @Test
    public void accountInformation()  throws IllegalAccessException, InvocationTargetException {
        Account account = new Account("adrien", "heros");

        Assertions.assertEquals(getGetUsername().invoke(account), "adrien");
        Assertions.assertEquals(getGetPassword().invoke(account), "heros");
        Assertions.assertEquals(getGetBalanceMethod().invoke(account), 0.0);

        ArrayList<Operation> operations = (ArrayList<Operation>) getGetOperations().invoke(account);

        Assertions.assertEquals(operations.size(), 0);
    }

    @Test
    public void addOperation() throws IllegalAccessException, InvocationTargetException {
        Account account = new Account("adrien", "heros");
        Operation operation = new Operation(OperationType.DEPOSIT, 20);

        getAddOperation().invoke(account, operation);
        ArrayList<Operation> operations = (ArrayList<Operation>) getGetOperations().invoke(account);

        Assertions.assertEquals(operations.size(), 1);
    }

    private Method getUpdateBalanceMethod() {
        Method method = null;

        try {
            method = Account.class.getDeclaredMethod("updateBalance", double.class);
            method.setAccessible(true);
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }

        return method;
    }

    private Method getGetUsername() {
        Method method = null;

        try {
            method = Account.class.getDeclaredMethod("getUsername");
            method.setAccessible(true);
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }

        return method;
    }

    private Method getGetPassword() {
        Method method = null;

        try {
            method = Account.class.getDeclaredMethod("getPassword");
            method.setAccessible(true);
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }

        return method;
    }

    private Method getGetOperations() {
        Method method = null;

        try {
            method = Account.class.getDeclaredMethod("getOperations");
            method.setAccessible(true);
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }

        return method;
    }

    private Method getGetBalanceMethod() {
        Method method = null;

        try {
            method = Account.class.getDeclaredMethod("getBalance");
            method.setAccessible(true);
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }

        return method;
    }

    private Method getAddOperation() {
        Method method = null;

        try {
            method = Account.class.getDeclaredMethod("addOperation", Operation.class);
            method.setAccessible(true);
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }

        return method;
    }
}
