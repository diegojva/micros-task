package com.nttdata.escuela.libro.adapter;

import com.nttdata.escuela.libro.apimodel.BookDto;
import com.nttdata.escuela.libro.apimodel.BookEntity;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Objects;

@UtilityClass
public class BookAdapter {


    public static BookEntity adaptToEntity(final BookDto bookDto) {
        if (bookDto == null) {
            return null;
        }
        return BookEntity.builder()
                .id(bookDto.getId())
                .anoPublicacion(bookDto.getAnoPublicacion())
                .nombre(bookDto.getNombre())
                .autorId(bookDto.getIdAutor())
                .build();
    }

    public static List<BookEntity> adaptToEntity(final List<BookDto> bookDtos) {
        // A -> B 
        return bookDtos.stream()//Stream<BookDto>
                .map(BookAdapter::adaptToEntity) // Stream<BookEntity> 
                .filter(Objects::nonNull)
                .toList();
    }


    //Sobrecarga de métodos
    //Firma del método -> Nombre + Argumentos + Tipos de argumentos

    public static BookDto adaptToDto(final BookEntity bookEntity) {
        if (bookEntity == null) {
            return null;
        }
        return BookDto.builder()
                .id(bookEntity.getId())
                .anoPublicacion(bookEntity.getAnoPublicacion())
                .nombre(bookEntity.getNombre())
                .idAutor(bookEntity.getAutorId())
                .build();
    }

    public static List<BookDto> adaptToDto(final List<BookEntity> bookEntities) {
        // A -> B 
        return bookEntities.stream()//Stream<BookEntity>
                .map(BookAdapter::adaptToDto) // Stream<BookDto> 
                .filter(Objects::nonNull)
                .toList();
    }
}
