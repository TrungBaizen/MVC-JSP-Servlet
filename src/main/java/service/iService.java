package service;

import java.util.List;

public interface iService<E> {
    boolean add(E e);
    boolean edit(E e,int id);
    boolean delete(int id);
    int findById(int id);
    List<E> findAll();
    }
