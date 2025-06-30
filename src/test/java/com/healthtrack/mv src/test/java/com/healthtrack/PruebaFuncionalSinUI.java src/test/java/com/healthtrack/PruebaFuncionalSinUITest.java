package com.healthtrack;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PruebaFuncionalSinUITest {


    @Test
    public void testPaginaExample() {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("https://example.com");
        String titulo = driver.getTitle();

        System.out.println("[✅] Prueba funcional sin UI: título obtenido -> " + titulo);

        assertTrue(titulo.contains("Example"));

        driver.quit();
    }
}
