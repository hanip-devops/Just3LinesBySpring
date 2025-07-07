package com.jaram.Just3Lines.service;

import com.jaram.Just3Lines.domain.Language;
import com.openai.client.OpenAIClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
@RequiredArgsConstructor
@Builder
public class MainService {

      private final OpenAIClient client;

      public List<String> summarizeText(String content, String language){

            String prompt = String.format("You are a professional news article summarizer. Summarize t" +
                    "he given article in exactly 3 lines in %s. Make each line informative and concise.",language);

            ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                    .model(ChatModel.GPT_3_5_TURBO)
                    .maxCompletionTokens(300)
                    .addDeveloperMessage(prompt)
                    .addUserMessage(content)
                    .build();


            ChatCompletion chatCompletion = client.chat().completions().create(params);
            String text = chatCompletion.choices().getFirst().message().content()
                    .orElseThrow(()->new RuntimeException("값이 없습니다"));

            return Arrays.stream(text.strip().split("\\R"))
                    .map(String::strip)
                    .filter(line -> !line.isEmpty())
                    .limit(3)
                    .toList();

      }

}
