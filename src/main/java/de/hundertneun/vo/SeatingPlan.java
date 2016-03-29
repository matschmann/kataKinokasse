package de.hundertneun.vo;

import java.util.List;
import java.util.Map;

public class SeatingPlan {
    
    private Map<Integer, List<Integer>> row;

    public SeatingPlan() {
    }

    public Map<Integer, List<Integer>> getRow() {
        return row;
    }

    public void setRow(Map<Integer, List<Integer>> row) {
        this.row = row;
    }
}
