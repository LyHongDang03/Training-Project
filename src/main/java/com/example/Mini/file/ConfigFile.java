package com.example.Mini.file;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConfigFile {
    @Bean
    public Cloudinary configKey() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dfibxfwot");
        config.put("api_key", "636131119697544");
        config.put("api_secret", "KEY3IjqICF-imgqVmzc22oGOaxc");
        return new Cloudinary(config);
    }
}
