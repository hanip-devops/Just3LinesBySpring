package com.jaram.Just3Lines.config;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAiConfig {

    @Value("${OPENAI_API_KEY}")
    private String openAiKey;

    @Bean
    public OpenAIClient openAi(){
        return new OpenAIOkHttpClient.Builder()
                .apiKey(openAiKey)
                .build();
    }
}
