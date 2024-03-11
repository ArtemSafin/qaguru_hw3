package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TestBoxPageObjectTest extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();
    @Test
    void TestBoxPagePositiveTest() {
        textBoxPage.openPage()
                .setFullName("Anton LaVey")
                .setEmail("LaVey@gmail.com")
                .setCurrentAddress("The Black House, San Francisco, California")
                .setPermanentAddressInput("The Black House, San Francisco, California")
                .clickSubmit();
        textBoxPage.checkResult("Name:", "LaVey")
                .checkResult("Email:", "LaVey@gmail.com")
                .checkResult("Current Address :", "The Black House, San Francisco, California")
                .checkResult("Permananet Address :", "The Black House, San Francisco, California");

    }
}
