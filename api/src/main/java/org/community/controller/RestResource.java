package org.community.controller;

import java.util.List;

/**
 * Created by frodo on 2017/9/1.
 */
public interface RestResource<T> {
    List<T> list();

    T find(Long id);

    Long add(T entity);

    void delete(Long id);

    Long update(T entity);
}
