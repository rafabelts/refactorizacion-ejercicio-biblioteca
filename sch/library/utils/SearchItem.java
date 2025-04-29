package sch.library.utils;

import java.util.List;

public class SearchItem<T extends Identifiable> {

    public T search(int idToFound, List<T> items) {
        int index = 0;

        while (index < items.size()) {

            T item = items.get(index);

            if (item.getId() == idToFound) {
                break;
            }

            index++;
        }

        return items.get(index);
    }
}
