package com.nttdata.libreria.apimodel.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("libreria_libro")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookStoreBookEntity
{
    @Id
    private Integer id;
    private Integer libroId;
    private Integer libreriaId;
    private double precio;
}
