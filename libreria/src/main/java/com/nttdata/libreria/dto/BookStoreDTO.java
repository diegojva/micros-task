package com.nttdata.libreria.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookStoreDTO
{
    private Integer id;
    private String nombre;
    private String direccion;
}
