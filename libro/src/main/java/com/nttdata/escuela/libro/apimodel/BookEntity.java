package com.nttdata.escuela.libro.apimodel;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("libro")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookEntity {

    @Id
    private Integer id;

    private String nombre;

    private Integer anoPublicacion;

    private Integer autorId;
}
