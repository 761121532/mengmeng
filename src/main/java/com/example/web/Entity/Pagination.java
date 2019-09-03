package com.example.web.Entity;

public class Pagination {
    private int action;
    private int end;

    @Override
    public String toString() {
        return "Pagination{" +
                "action=" + action +
                ", end=" + end +
                '}';
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
