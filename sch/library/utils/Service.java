package sch.library.utils;

import java.util.List;

public interface Service<T> {

    public void add(List<T> iterable);

    public void showAll(List<T> iterable);
}
