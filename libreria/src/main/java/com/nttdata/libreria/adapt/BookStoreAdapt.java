package com.nttdata.libreria.adapt;

import com.nttdata.libreria.apimodel.entity.BookStoreEntity;
import com.nttdata.libreria.dto.BookStoreDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BookStoreAdapt
{
    public static BookStoreEntity convertToEntity(BookStoreDTO dto)
    {
        return BookStoreEntity.builder()
                .id(dto.getId())
                .nombreBazar(dto.getNombre())
                .direccion(dto.getDireccion())
                .build();
    }
}
