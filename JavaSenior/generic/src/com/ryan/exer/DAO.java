package com.ryan.exer;

import java.util.*;

/**
 * @author RyanL
 * @description
 * @create 2022/7/24
 */
public class DAO<T> {

    private Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        if (map.containsKey(id))
            map.put(id, entity);
    }

    public List<T> list() {
        Collection<T> values = map.values();
        return new ArrayList<>(values);
    }

    public void delete(String id) {
        map.remove(id);
    }

}
