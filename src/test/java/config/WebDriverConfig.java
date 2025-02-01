package config;


import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${env}.properties", "classpath:local.properties"})

public interface WebDriverConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://studio.faphouse.com")
    String getBaseUrl();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("browserName")
    @DefaultValue("chrome")
    String getBrowserName();

    @Key("browserVersion")
    @DefaultValue("132.0")
    String getBrowserVersion();
}
