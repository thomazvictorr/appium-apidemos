package br.com.thomazvictorr.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        String apkPath = Paths.get("src", "test", "resources", "ApiDemos-debug.apk")
                .toAbsolutePath()
                .toString();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UIAutomator2");
        options.setDeviceName("emulator-5554");
        options.setApp(apkPath);
        options.setNoReset(true);
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity(".ApiDemos");
        options.setNewCommandTimeout(Duration.ofMinutes(3));

        URL appiumUrl = new URL("http://127.0.0.1:4723/");
        this.driver = new AndroidDriver(appiumUrl, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Fecha popups de permissão se aparecerem
        try {
            driver.findElement(
                    io.appium.java_client.AppiumBy.id("com.android.permissioncontroller:id/continue_button")
            ).click();
            driver.findElement(
                    io.appium.java_client.AppiumBy.id("android:id/button1")
            ).click();
        } catch (Exception e) {
            System.out.println("Nenhum popup de permissão encontrado, continuando...");
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}