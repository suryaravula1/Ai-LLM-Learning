// This class tracks the progress of document ingestion for each user session in OnboardEase
package dev.nano.tptragbot.common.model;

import lombok.Setter;

public class Progress {
    private int current;

    @Setter
    private int total;

    public void increment() {
        current++;
    }

    public int getPercentage() {
        return (int) ((double) current / total * 100);
    }
}
