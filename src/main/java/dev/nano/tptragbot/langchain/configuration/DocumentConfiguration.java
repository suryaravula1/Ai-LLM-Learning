// This class configures document loading and preparation for Langchain4j in OnboardEase
package dev.nano.tptragbot.langchain.configuration;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.UrlDocumentLoader;
import dev.langchain4j.data.document.parser.TextDocumentParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static dev.langchain4j.data.document.loader.FileSystemDocumentLoader.loadDocument;


@Component
public class DocumentConfiguration {
    
    private static final Logger log = LoggerFactory.getLogger(DocumentConfiguration.class);

    public List<Document> documents(List<String> urls, List<String> paths) {

        List<Document> documents = new ArrayList<>();

        // Load documents from URLs
        for (String url : urls) {
            try {
                documents.add(UrlDocumentLoader.load(url, new TextDocumentParser()));
            } catch (Exception e) {
                log.error("Failed to load document from URL: {}", url, e);
                throw new RuntimeException("Failed to load document from " + url, e);
            }
        }

        // Load documents from PDF files
        for (String path : paths) {
            try {
                documents.add(loadDocument(path));
            } catch (Exception e) {
                log.error("Failed to load document from path: {}", path, e);
                throw new RuntimeException("Failed to load document from " + path, e);
            }
        }

        log.info("Total documents loaded: {}", documents.size());
        return documents;
    }
}
