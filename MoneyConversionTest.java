import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoneyConversionTest {
    @Test
    public void testConvertMoneyFromStringToNumberMethod() throws Exception {
        MoneyConversion moneyConversion = new MoneyConversion();
        Response response = moneyConversion.convertMoneyFromStringToNumber("-1D -10C");

        Assert.assertEquals(-1.10, response.amtGiven,0.0);
    }

    @Test
    public void testConvertMoneyFromNumberToStringMethod() throws Exception {
        MoneyConversion moneyConversion = new MoneyConversion();
        String actualAns = moneyConversion.convertMoneyFromNumberToString(1.10);

        Assert.assertEquals("1D 10C", actualAns);
    }
}