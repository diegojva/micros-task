package com.nttdata.libreria.adapt;

import com.nttdata.libreria.apimodel.entity.BookStoreBookEntity;
import com.nttdata.libreria.dto.BookStoreBookDTO;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class BookStoreBookAdapt
{
    public static List<BookStoreBookDTO> convertToDto(List<BookStoreBookEntity> bookStoreBookEntityList)
    {
        return bookStoreBookEntityList.stream().map(BookStoreBookAdapt::convertToDto).toList();
    }

    public static BookStoreBookDTO convertToDto(BookStoreBookEntity bookStoreBookEntity)
    {
        return BookStoreBookDTO.builder()
                .idLibro(bookStoreBookEntity.getLibroId())
                .precio(bookStoreBookEntity.getPrecio())
                .build();
    }

    public static BookStoreBookEntity convertToEntity(BookStoreBookDTO dto, Integer idLibreria)
    {
        return BookStoreBookEntity.builder()
                .libroId(dto.getIdLibro())
                .libreriaId(idLibreria)
                .precio(dto.getPrecio())
                .build();
    }
}
