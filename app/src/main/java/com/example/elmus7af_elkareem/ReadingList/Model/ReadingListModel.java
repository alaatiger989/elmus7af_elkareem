package com.example.elmus7af_elkareem.ReadingList.Model;

import java.util.ArrayList;
import java.util.List;

public class ReadingListModel {
    private List<Integer> originalIndexForReadingList = new ArrayList<>();

    public List<Integer> getOriginalIndexForReadingList() {
        return originalIndexForReadingList;
    }

    public void setOriginalIndexForReadingList(List<Integer> originalIndexForReadingList) {
        this.originalIndexForReadingList = originalIndexForReadingList;
    }
}
