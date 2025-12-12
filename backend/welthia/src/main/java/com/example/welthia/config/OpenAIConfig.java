package com.example.welthia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.openai.OpenAI;

@Configuration
public class OpenAIConfig {

    @Bean
    public OpenAI openAI() {
        return new OpenAI(System.getenv("import org.springframework.context.annotation.Bean;\r\n" + //
                        "import org.springframework.context.annotation.Configuration;\r\n" + //
                        "\r\n" + //
                        "import com.openai.OpenAI;\r\n" + //
                        "\r\n" + //
                        "@Configuration\r\n" + //
                        "public class OpenAIConfig {\r\n" + //
                        "\r\n" + //
                        "    @Bean\r\n" + //
                        "    public OpenAI openAI() {\r\n" + //
                        "        return new OpenAI(System.getenv(\"OPENAI_API_KEY\"));\r\n" + //
                        "    }\r\n" + //
                        "}\r\n" + //
                        ""));
    }
}
