package com.kovalev007.selenium7821;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.collect.ImmutableMap;

public class TestApp {

    private static String HUB_IP = "192.168.56.1";

    public static void main(String[] args) throws MalformedURLException {
        Capabilities capabilities = null;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        capabilities = options;

        CustomOkHttpClientFactory factory = new CustomOkHttpClientFactory();
        HttpCommandExecutor executor = new HttpCommandExecutor(ImmutableMap.of(), new URL("http://" + HUB_IP + ":9999"), factory);
        WebDriver webDriver = new RemoteWebDriver(executor, capabilities);
        webDriver = new Augmenter().augment(webDriver);

        webDriver.manage().window().setSize(new Dimension(1920, 1080));
        webDriver.get("https://www.selenium.dev/");
        webDriver.quit();
    }

}