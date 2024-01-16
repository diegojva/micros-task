package com.nttdata.escuela.autor.apimodel;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("autor")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthorEntity {
    @Id
    private Integer id;

    private String nombre;

    private Integer anoNacimiento;
}
