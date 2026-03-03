package com.hc.learn.langchain4j.chat;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AiCodeHelperServiceTest {

    @Resource
    private AiCodeHelperService aiCodeHelperService;

    @Test
    void chat() {
        String chat = aiCodeHelperService.chat("你好，我是后端工程师花城");
        System.out.println(chat);

    }

    @Test
    void chatWithMessage() {
        String chat = aiCodeHelperService.chat("你好，我是后端工程师花城");
        System.out.println(chat);
        String chat1 = aiCodeHelperService.chat("你好，我是谁来着？");
        System.out.println(chat1);
        String chat2 = aiCodeHelperService.chat("你好，我是谁来着？");
        System.out.println(chat2);
        String chat3 = aiCodeHelperService.chat("你好，我是谁来着？");
        System.out.println(chat3);
        String chat4 = aiCodeHelperService.chat("你好，我是谁来着？");
        System.out.println(chat4);
        String chat5 = aiCodeHelperService.chat("你好，我是谁来着？");
        System.out.println(chat5);

        String chat6 = aiCodeHelperService.chat("你好，我是谁来着？我是什么工程师");
        System.out.println(chat6);
    }
}