package com.nttdata.escuela.libro.apimodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Integer id;

    private String nombre;

    private Integer anoPublicacion;

    private Integer idAutor;
    
}
