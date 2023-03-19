//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class Functions {
//
//    private WebElement waitElementPresentByXpath(String xpath, String error_message, long timeoutInSeconds)
//    {
//        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
//        wait.withMessage(error_message + "\n");
//        By by = By.xpath(xpath);
//        return wait.until(
//                ExpectedConditions.presenceOfElementLocated(by)
//        );
//    }
//
//    private WebElement waitElementPresentByXpath(String xpath, String error_message)
//    {
//        return waitElementPresentByXpath(xpath, error_message, 5);
//    }
//// Один метод, перезапуск метода }}
//
//    private WebElement waitForElementByXpathAndClick(String xpath, String error_message, long timeoutInSeconds)
//    {
//        WebElement element = waitElementPresentByXpath(xpath, error_message, timeoutInSeconds);
//        element.click();
//        return element;
//    }
//
//    private WebElement waitForElementByXpathAndSendKeys(String xpath, String value, String error_message, long timeoutInSeconds)
//    {
//        WebElement element = waitElementPresentByXpath(xpath, error_message, timeoutInSeconds);
//        element.sendKeys(value);
//        return element;
//    }
//
//    private WebElement waitElementPresentById(String id, String error_message, long timeoutInSeconds) {
//        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
//        wait.withMessage(error_message + "\n");
//        By by = By.id(id);
//        return wait.until(
//                ExpectedConditions.presenceOfElementLocated(by)
//        );
//    }
//
//    private WebElement waitElementPresentByClassName(String className, String error_message, long timeoutInSeconds)
//    {
//        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
//        wait.withMessage(error_message + "\n");
//        By by = By.className(className);
//        return wait.until(
//                ExpectedConditions.presenceOfElementLocated(by)
//        );
//    }
//
//    private WebElement waitElementPresentByClassName(String className, String error_message)
//    {
//        return waitElementPresentByClassName(className, error_message, 5);
//    }
//
//    private WebElement waitForElementByClassNameAndClick(String className, String error_message, long timeoutInSeconds)
//    {
//        WebElement element = waitElementPresentByClassName(className, error_message, timeoutInSeconds);
//        element.click();
//        return element;
//    }
//
//    private WebElement waitForElementByClassNameAndSendKeys(String className, String value, String error_message, long timeoutInSeconds)
//    {
//        WebElement element = waitElementPresentByClassName(className, error_message, timeoutInSeconds);
//        element.sendKeys(value);
//        return element;
//    }
//}
