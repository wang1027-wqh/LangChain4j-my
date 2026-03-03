package com.hc.learn.langchain4j.chat;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

//@AiService
public interface AiCodeHelperService {

    @SystemMessage(fromResource = "system-prompt.txt")
    String chat(String message);
}
