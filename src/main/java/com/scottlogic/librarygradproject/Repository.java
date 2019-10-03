package com.scottlogic.librarygradproject;

import java.util.List;
import java.util.Optional;

public interface Repository<T,S> {
    Optional<T> get(S id);
    List<T> getAll();
    S add(T entity);
    S remove(S id);
}
