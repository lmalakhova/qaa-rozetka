package io.github.lmalakhova;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Reloadable;

/**
 * Java interface associated to a properties file.
 **/
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources("classpath:config.properties")
public interface BaseConfig extends Config, Reloadable {
    BaseConfig BASE_CONFIG = ConfigFactory.create(BaseConfig.class, System.getenv(), System.getProperties());

    @DefaultValue("3")
    @Key("explicit.wait.timeout")
    long waitTimeOut();

    @DefaultValue("http://localhost")
    @Key("url")
    String url();
}
