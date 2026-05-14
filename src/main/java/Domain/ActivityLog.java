package Domain;

import java.util.ArrayList;
import java.util.List;

public class ActivityLog {

    private List<String> activityHistory;

    public ActivityLog() {
        activityHistory = new ArrayList<>();
    }

    public void addEntry(String entry) {
        activityHistory.add(entry);
    }

    public List<String> getHistory() {
        return activityHistory;
    }
}
