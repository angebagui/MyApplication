package com.example.android.myapplication.ormlite.dao;

import java.util.List;

public interface BaseDao<T> {
    public boolean save(final T entity);

    public boolean update(final T entity);

    public boolean delete(final T entity);

    public List<T> findAll();

    public T findOneById(final long id);

    public long countAll();

    public List<T> findAllByLimit(final long currentPage, final long size);

}