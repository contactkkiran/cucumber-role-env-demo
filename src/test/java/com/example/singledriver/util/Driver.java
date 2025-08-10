package com.example.singledriver.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    private static WebDriver DRIVER;

    public static synchronized WebDriver get() {
        if (DRIVER == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions opts = new ChromeOptions();
            String headless = Env.get("HEADLESS", "true");
            if ("true".equalsIgnoreCase(headless)) {
                opts.addArguments("--headless=new");
            }
            DRIVER = new ChromeDriver(opts);
            DRIVER.manage().window().maximize();
        }
        return DRIVER;
    }

    public static synchronized void quit() {
        if (DRIVER != null) {
            DRIVER.quit();
            DRIVER = null;
        }
    }
}
