package com.academico.gestaoescolar.Dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
@NoArgsConstructor
public class AlunoDto {

    private Long id;
    private String nome;
    private double media;
    private double frequencia ;

}
