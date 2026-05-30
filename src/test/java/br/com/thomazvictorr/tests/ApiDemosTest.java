package br.com.thomazvictorr.tests;

import br.com.thomazvictorr.base.BaseTest;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiDemosTest extends BaseTest {

    @Test
    @DisplayName("CT-001 Deve navegar para Hello World e validar texto")
    public void deveNavegaParaHelloWorldEValidarTexto() {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Activity")).click();
        driver.findElement(AppiumBy.accessibilityId("Hello World")).click();

        String texto = driver.findElement(
                AppiumBy.id("io.appium.android.apis:id/text")
        ).getText();

        assertEquals("Hello, World!", texto);
    }

    @Test
    @DisplayName("CT-002 Deve validar activity atual ao abrir Hello World")
    public void deveValidarActivityAtual() {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Activity")).click();
        driver.findElement(AppiumBy.accessibilityId("Hello World")).click();

        String activity = driver.currentActivity();
        assertEquals(".app.HelloWorld", activity);
    }

    @Test
    @DisplayName("CT-003 Deve realizar scroll até WebView na lista de Views")
    public void deveRealizarScrollAteWebView() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(" +
                        "new UiSelector().text(\"WebView\"));"
        ));

        assertTrue(
                driver.findElement(AppiumBy.accessibilityId("WebView")).isDisplayed()
        );
    }

    @Test
    @DisplayName("CT-004 Deve realizar drag and drop entre elementos")
    public void deveRealizarDragAndDrop() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        RemoteWebElement source = (RemoteWebElement) driver.findElement(
                AppiumBy.id("io.appium.android.apis:id/drag_dot_1")
        );
        RemoteWebElement destination = (RemoteWebElement) driver.findElement(
                AppiumBy.id("io.appium.android.apis:id/drag_dot_2")
        );

        driver.executeScript("gesture: dragAndDrop", Map.of(
                "sourceId", source.getId(),
                "destinationId", destination.getId()
        ));

        String resultado = driver.findElement(
                AppiumBy.id("io.appium.android.apis:id/drag_result_text")
        ).getText();

        assertEquals("Dropped!", resultado);
    }

    @Test
    @DisplayName("CT-005 Deve navegar para Views e voltar para tela inicial")
    public void deveNavegaParaViewsEVoltarParaTelaInicial() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        assertTrue(
                driver.findElement(AppiumBy.accessibilityId("Animation")).isDisplayed()
        );

        driver.navigate().back();

        assertTrue(
                driver.findElement(AppiumBy.accessibilityId("App")).isDisplayed()
        );
    }

    @Test
    @DisplayName("CT-006 Deve validar itens principais na tela inicial")
    public void deveValidarItensPrincipaisNaTelaInicial() {
        assertTrue(driver.findElement(AppiumBy.accessibilityId("App")).isDisplayed());
        assertTrue(driver.findElement(AppiumBy.accessibilityId("Views")).isDisplayed());
        assertTrue(driver.findElement(AppiumBy.accessibilityId("Graphics")).isDisplayed());
        assertTrue(driver.findElement(AppiumBy.accessibilityId("Animation")).isDisplayed());
    }
}