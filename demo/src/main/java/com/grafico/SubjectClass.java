package com.grafico;

import com.logica.SelectionObserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SubjectClass {
    private List<SelectionObserver> selectionObservers = new ArrayList<>();

    public void addSelectionObserver(SelectionObserver selectionObserver) {
        selectionObservers.add(selectionObserver);
    }

    public void removeSelectionObserver(SelectionObserver selectionObserver) {
        selectionObservers.remove(selectionObserver);
    }

    public void notifySelectionObservers(int rowIndex) throws IOException {
        for (SelectionObserver selectionObserver : selectionObservers) {
            selectionObserver.update(rowIndex);
        }
    }
}
