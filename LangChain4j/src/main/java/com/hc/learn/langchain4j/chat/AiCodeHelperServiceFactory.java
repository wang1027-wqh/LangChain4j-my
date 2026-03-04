package com.hc.learn.langchain4j.chat;


import com.hc.learn.langchain4j.ai.tools.InterviewQuestionTool;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.mcp.McpToolProvider;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiCodeHelperServiceFactory {

    @Resource
    private ChatModel qwenChatModel;

//    @Resource
//    private EmbeddingStore embeddingStore;

    @Resource
    private ContentRetriever contentRetriever;

    @Resource
    private McpToolProvider mcpToolProvider;

    @Bean
    public AiCodeHelperService aiCodeHelperService (){
        // 会话记忆
        ChatMemory chatMemory  = MessageWindowChatMemory.withMaxMessages(10);
        // 构造AIService
        AiCodeHelperService service = AiServices.builder(AiCodeHelperService.class)
                .chatModel(qwenChatModel)
                .chatMemory(chatMemory)
//                .chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(10))
                .contentRetriever(contentRetriever) // RAG检索增强生成
                .tools(new InterviewQuestionTool()) // 工具调用
                .toolProvider(mcpToolProvider) // MCP 工具调用
                .build();
        return service;

        // 简易版RAG
//        ChatMemory chatMemory  = MessageWindowChatMemory.withMaxMessages(10);
//        List<Document> documentList = FileSystemDocumentLoader.loadDocuments("src/main/resources/doc");
//        EmbeddingStoreIngestor.ingest(documentList);
//        AiCodeHelperService service = AiServices.builder(AiCodeHelperService.class)
//                .chatModel(qwenChatModel)
//                .chatMemory(chatMemory)
////              .chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(10))
//                .contentRetriever(EmbeddingStoreContentRetriever.from(embeddingStore))
//                .build();
//        return service;
    }


}
