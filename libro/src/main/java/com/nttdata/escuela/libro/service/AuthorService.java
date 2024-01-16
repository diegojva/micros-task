package com.nttdata.escuela.libro.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class AuthorService {

    @Autowired
    private RestTemplate restTemplate;

    //@CircuitBreaker(name = "author-client", fallbackMethod = "fallbackIfAuthorIsDown")
    public Boolean existsAuthorById(final Integer idAuthor) {
        log.info("AuthorService.existsAuthorById, {}", idAuthor);
        return this.restTemplate.getForEntity("http://author-service/api/v1/author/exists/" + idAuthor, Boolean.class)
                .getBody();
    }

    public Boolean fallbackIfAuthorIsDown(Throwable throwable) {
        log.error(throwable.getMessage());
        return Boolean.FALSE;
    }

}
