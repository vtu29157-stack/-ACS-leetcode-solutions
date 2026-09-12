import java.util.ArrayList;
import java.util.List;

class BrowserHistory {
    private List<String> history;
    private int current;
    private int maxBoundary;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        current = 0;
        maxBoundary = 0;
    }
    
    public void visit(String url) {
        current++;
        // If current index is within existing list size, update the element
        if (current < history.size()) {
            history.set(current, url);
        } else {
            history.add(url);
        }
        // Visiting a new page clears all forward history
        maxBoundary = current;
    }
    
    public String back(int steps) {
        // Move back at most to index 0
        current = Math.max(0, current - steps);
        return history.get(current);
    }
    
    public String forward(int steps) {
        // Move forward at most to maxBoundary
        current = Math.min(maxBoundary, current + steps);
        return history.get(current);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
