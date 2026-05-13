package src.main.java.Domain;

import java.util.ArrayList;
import java.util.List;

public class activityLog {

    private List<String> activityHistory;

    public activityLog() {
        activityHistory = new ArrayList<>();
    }

    public void addEntry(String entry) {
        activityHistory.add(entry);
    }

    public List<String> getHistory() {
        return activityHistory;
    }
}
