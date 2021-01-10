package com.example.demo.services;

public interface BaseService<T> {

    Iterable<T> all();

    T getById(Long id) throws Exception;

    T save(T object);

    void delete(Long id);
}
