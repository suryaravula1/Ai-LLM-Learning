// This class represents the sources (URLs and file paths) for documents ingested by OnboardEase
package dev.nano.tptragbot.common.model;

import java.util.List;

public class DocumentSources {
    private List<String> urls;
    private List<String> paths;

    public DocumentSources(List<String> urls, List<String> paths) {
        this.urls = urls;
        this.paths = paths;
    }

    // Returns the list of URLs for document sources
    public List<String> getUrls() {
        return urls;
    }

    public List<String> getPaths() {
        return paths;
    }
}
