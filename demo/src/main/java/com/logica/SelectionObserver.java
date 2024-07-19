package com.logica;

import java.io.IOException;

public interface SelectionObserver {
    void update(int rowIndex) throws IOException;
}
