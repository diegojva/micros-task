package com.nttdata.libreria.client;

import com.nttdata.libreria.apimodel.BookClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookClientImpl implements BookClient
{

    @Autowired
    private RestTemplate rest;

    @Override
    public Boolean existsById(Integer id)
    {
        return this.rest.getForEntity("http://book-service/api/v1/book/exists/" + id, Boolean.class)
                .getBody();
    }
}
