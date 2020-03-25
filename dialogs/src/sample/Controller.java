package sample;

import java.util.List;

public interface Controller <T>{
    //Page<T> getPage(int number, int count);

    void delete(String id);

    T update(T entity);

    void readFromFile(String name);

    void saveFile(String name);
}
