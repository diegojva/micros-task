package com.nttdata.libreria.apimodel.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("libreria")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookStoreEntity
{
    @Id
    private Integer id;
    private String nombreBazar;
    private String direccion;
}
