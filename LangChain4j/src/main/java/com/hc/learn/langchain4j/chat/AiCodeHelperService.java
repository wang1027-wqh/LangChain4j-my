package com.hc.learn.langchain4j.chat;

import dev.langchain4j.service.Result;
import dev.langchain4j.service.SystemMessage;

import java.util.List;

//@AiService
public interface AiCodeHelperService {

    @SystemMessage(fromResource = "system-prompt.txt")
    String chat(String message);

//    String chat(@MemoryId int memoryId,  String message);

    @SystemMessage(fromResource = "system-prompt.txt")
    Report chatForReport(String message);

    record Report (String name, List<String> suggestionList) {}

    @SystemMessage(fromResource = "system-prompt.txt")
    Result<String> chatWithRag (String userMessage);
}
