package configs;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties"})
public interface ProjectConfigs extends Config {

    String authToken();

    String baseUrl();

    String username();

    boolean logging();
}

