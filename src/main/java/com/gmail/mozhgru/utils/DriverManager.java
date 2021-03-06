package com.gmail.mozhgru.utils;

import com.gmail.mozhgru.exceptions.DriverNotInitializedException;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Optional;

public class DriverManager {

    private static ThreadLocal<RemoteWebDriver> driverContainer = new ThreadLocal<>();

    public synchronized static RemoteWebDriver get() {
        return Optional.ofNullable(driverContainer.get()).orElseThrow(DriverNotInitializedException::new);
    }
}
