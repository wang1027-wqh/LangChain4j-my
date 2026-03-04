package com.hc.learn.langchain4j.chat;

import dev.langchain4j.service.Result;
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

    @Test
    void chatForReport() {
        String userMessage = "你好，我是程序员花城，Java后端开发工程师，请帮我制定AI学习报告";
        AiCodeHelperService.Report report = aiCodeHelperService.chatForReport(userMessage);
        System.out.println(report);
    }

    @Test
    void chatWithRag() {
        String userMessage = "怎么学习Java，有哪些常见的面试题?";
        String chat = aiCodeHelperService.chat(userMessage);
        System.out.println(chat);

    }

    @Test
    void chatWithRagResult() {
        String userMessage = "怎么学习Java，有哪些常见的面试题?";
        Result<String> chat = aiCodeHelperService.chatWithRag(userMessage);
        System.out.println(chat.sources());
        System.out.println(chat.content());
    }

    @Test
    void chatWithTools() {
        String userMessage = "有哪些常见的计算机网络和Java面试题?";
        String chat = aiCodeHelperService.chat(userMessage);
        System.out.println(chat);
    }

    @Test
    void chatWithMCP() {
        String userMessage = "路 飞的CSDN地址是什么？";
        String chat = aiCodeHelperService.chat(userMessage);
        System.out.println(chat);
    }
}