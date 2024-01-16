package com.nttdata.libreria.service;

import com.nttdata.libreria.apimodel.BookStoreBookService;
import com.nttdata.libreria.apimodel.entity.BookStoreBookEntity;
import com.nttdata.libreria.repository.BookStoreBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class BookStoreBookServiceImpl implements BookStoreBookService
{
    @Autowired
    private BookStoreBookRepository repo;

    @Override
    public List<BookStoreBookEntity> findAll()
    {
        return StreamSupport.stream(repo.findAll().spliterator(), false).toList();
    }

    @Override
    public void saveOrUpdate(BookStoreBookEntity bookStoreBookEntity)
    {
        log.info("BookStoreBookServiceImpl.saveOrUpdate: " + bookStoreBookEntity);
        this.repo.save(bookStoreBookEntity);
    }

    @Override
    public BookStoreBookEntity getById(Integer id) {
        return this.repo.findById(id).orElse(null);
    }

    @Override
    public List<BookStoreBookEntity> findByLibreriaId(Integer id)
    {
        return this.repo.findByLibreriaId(id);
    }

    @Override
    public void deleteAuthor(Integer id)
    {
        if(this.getById(id) == null)
        {
            throw new RuntimeException("No existe el autor con id: " + id);
        }
        this.repo.deleteById(id);
    }
}
