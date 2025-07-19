// This class tracks the progress of document ingestion for each user session in OnboardEase
package dev.nano.tptragbot.common.model;

public class Progress {
    private int current;
    private int total;

    // Increments the progress count and updates the percentage
    public void increment() {
        current++;
    }

    public int getPercentage() {
        return (int) ((double) current / total * 100);
    }
    
    public void setTotal(int total) {
        this.total = total;
    }
}
