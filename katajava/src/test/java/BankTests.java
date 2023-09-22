import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.katajava.bank.Bank;

public class BankTests {
    @Test
    public void authenticate() throws IllegalAccessException, InvocationTargetException {
        Bank bank = new Bank();

        Assertions.assertEquals(bank.authenticate("adrien", "heros"), null);

        bank.createAccount("adrien", "heros");

        Assertions.assertNotEquals(bank.authenticate("adrien", "heros"), null);
    }

    @Test
    public void makeDeposit() throws IllegalAccessException, InvocationTargetException {
        Bank bank = new Bank();

        bank.createAccount("adrien", "heros");

        Assertions.assertEquals(bank.makeDeposit("token", 20), false);
        Assertions.assertEquals(bank.makeDeposit("token", -20), false);

        String token = bank.authenticate("adrien", "heros");

        Assertions.assertEquals(bank.makeDeposit(token, -20), false);
        Assertions.assertEquals(bank.makeDeposit(token, 20), true);
    }

    @Test
    public void makeWithdrawal() throws IllegalAccessException, InvocationTargetException {
        Bank bank = new Bank();

        bank.createAccount("adrien", "heros");

        Assertions.assertEquals(bank.makeWithdrawal("token", 20), false);
        Assertions.assertEquals(bank.makeWithdrawal("token", -20), false);

        String token = bank.authenticate("adrien", "heros");

        Assertions.assertEquals(bank.makeWithdrawal(token, 20), true);
        Assertions.assertEquals(bank.makeWithdrawal(token, -20), false);
    }

    @Test
    public void getCreateAccount() throws IllegalAccessException, InvocationTargetException {
        Bank bank = new Bank();

        Assertions.assertEquals(bank.createAccount("adrien", "heros"), true);
        Assertions.assertEquals(bank.createAccount("adrien", "heros"), false);
    }
}
