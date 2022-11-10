package day10;

import org.junit.Test;
import utilites.TestBaseBeforeClassAfterClass;

public class C02_IlkTestBaseClass extends TestBaseBeforeClassAfterClass {

    @Test
    public void test1(){
        driver.get("https://www.amazon.com/");

    }
}
