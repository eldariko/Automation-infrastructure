package extentions;

import io.qameta.allure.Step;
import org.testng.Assert;
import utilities.CommonOps;

public class VerificationActions extends CommonOps {
    @Step("Assert true")
    public static void assertTrue(boolean flag){
        Assert.assertTrue(flag);
    }
    @Step("Assert if numbers are equals")
    public static void assertEquals(int number1,int number2){
        Assert.assertEquals(number1,number2);
    }
    @Step("Assert if strings are equals")
    public static void assertEquals(String str1,String str2){
        Assert.assertEquals(str1,str2);
    }
}
