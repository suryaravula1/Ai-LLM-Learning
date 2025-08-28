// Service for handling question answering logic using Langchain4j in OnboardEase
package dev.nano.tptragbot.langchain.service;

import dev.nano.tptragbot.langchain.agent.OnboardTrainingAssistant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TPTBotService {
    
    private static final Logger log = LoggerFactory.getLogger(TPTBotService.class);

    private final OnboardTrainingAssistant chain;
    
    public TPTBotService(OnboardTrainingAssistant chain) {
        this.chain = chain;
    }

    public String askQuestion(String question) {
        log.debug("======================================================");
        log.debug("Question: " + question);
        
        try {
            String answer = chain.chat(question);
            log.debug("Answer: " + answer);
            log.debug("======================================================");
            return answer;
        } catch (Exception e) {
            log.error("Error processing question: {}", question, e);
            return "I apologize, but I encountered an error while processing your question. Please try again.";
        }
    }
}
