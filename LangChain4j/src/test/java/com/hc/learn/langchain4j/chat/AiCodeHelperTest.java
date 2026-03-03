package com.hc.learn.langchain4j.chat;


import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AiCodeHelperTest {

    @Resource
    private AiCodeHelper aiCodeHelper;


    @Test
    void testChat() {
        aiCodeHelper.chat("你好，我是code，你是谁啊");
    }

    @Test
    void testChatUserMessage() {
        UserMessage userMessage = UserMessage.from(
                TextContent.from("帮我描述一下这张图片"),
                ImageContent.from("https://pic4.zhimg.com/v2-01d6cc783d3f47bc73e6fe2b860c5f43_r.jpg")
        );
        aiCodeHelper.chat(userMessage);
    }

    @Test
    void chatBySystem() {
        aiCodeHelper.chatBySystem("你好，我是code");

        aiCodeHelper.chatBySystem("我想知道redis相关的知识");

    }
}
