package com.nttdata.libreria.service;


import com.nttdata.libreria.apimodel.entity.BookStoreEntity;
import com.nttdata.libreria.apimodel.BookStoreService;
import com.nttdata.libreria.repository.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class BookStoreServiceImpl implements BookStoreService
{
    @Autowired
    private BookStoreRepository repo;


    @Override
    public List<BookStoreEntity> findAll()
    {
        return StreamSupport.stream(repo.findAll().spliterator(), false).toList();
    }

    @Override
    public void saveOrUpdate(final BookStoreEntity libreriaEntity)
    {
        this.repo.save(libreriaEntity);
    }

    @Override
    public BookStoreEntity getById(final Integer id)
    {
        return this.repo.findById(id).orElse(null);
    }

    @Override
    public void deleteAuthor(final Integer id)
    {
        if(this.getById(id) == null)
        {
            throw new RuntimeException("No existe el autor con id: " + id);
        }
        this.repo.deleteById(id);
    }
}
