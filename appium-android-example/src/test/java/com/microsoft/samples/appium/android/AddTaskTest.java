package com.microsoft.samples.appium.android;

import com.xamarin.testcloud.appium.EnhancedAndroidDriver;
import com.xamarin.testcloud.appium.Factory;
import io.appium.java_client.MobileElement;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AddTaskTest {
    @Rule
    public TestWatcher watcher = Factory.createWatcher();

    private static EnhancedAndroidDriver<MobileElement> driver;

    @Before
    public void before() throws Exception {
        File app = new File("com.xamarin.samples.taskyandroid.apk");
        String appPackage = "com.xamarin.samples.taskyandroid";
        
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", appPackage);

        URL url = new URL("http://localhost:4723/wd/hub");

        driver = Factory.createAndroidDriver(url, capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void after() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void canAddTask() throws Exception {
    }
}