package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Configuration.remote;

public class WebDriverProvider {

    public static WebDriverConfig PROPERTIES = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public static void setupConfig() {

        Configuration.browser = PROPERTIES.getBrowserName().toLowerCase();
        Configuration.baseUrl = PROPERTIES.getBaseUrl();
        Configuration.browserVersion = PROPERTIES.getBrowserVersion();
        Configuration.browserSize = PROPERTIES.getBrowserSize();
        Configuration.pageLoadTimeout = PROPERTIES.getPageLoadTimeout();
        Configuration.timeout = PROPERTIES.getTimeout();
        remote = PROPERTIES.getRemoteUrl();

        if (remote != null) {
            Configuration.remote = PROPERTIES.getRemoteUrl() + "/wd/hub";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of("enableVNC", true, "enableVideo", true));
            Configuration.browserCapabilities = capabilities;
        }
    }
}
