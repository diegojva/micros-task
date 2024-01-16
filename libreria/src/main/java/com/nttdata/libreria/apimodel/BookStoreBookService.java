package com.nttdata.libreria.apimodel;

import com.nttdata.libreria.apimodel.entity.BookStoreBookEntity;

import java.util.List;

public interface BookStoreBookService
{
    List<BookStoreBookEntity> findAll();

    void saveOrUpdate(BookStoreBookEntity bookStoreBookEntity);

    BookStoreBookEntity getById(Integer id);

    List<BookStoreBookEntity> findByLibreriaId(Integer id);

    void deleteAuthor(Integer id);
}
