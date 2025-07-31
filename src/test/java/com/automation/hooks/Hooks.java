package com.automation.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.automation.utils.DriverFactory;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        // Modo incógnito
        options.addArguments("--incognito");

        if (System.getenv("CI") != null) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }


        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        DriverFactory.setDriver(driver);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.log("Scenario failing, please refer to the image attached to this report");

            try {
                // Tomar screenshot como bytes (para adjuntar al reporte)
                final byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshotBytes, "image/png", "Screenshot of the error");

                // Crear carpeta screenshots si no existe
                Files.createDirectories(Paths.get("screenshots"));

                // Guardar la screenshot en archivo físico para GitHub Actions
                File screenshotFile = new File("screenshots/" + scenario.getName().replaceAll(" ", "_") + ".png");
                Files.write(screenshotFile.toPath(), screenshotBytes);

            } catch (IOException e) {
                System.out.println("Error al guardar screenshot: " + e.getMessage());
            }
        }

        if (driver != null) {
            driver.quit();
        }
    }
}
