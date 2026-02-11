package com.academico.gestaoescolar.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private double mediaDisciplina1;
    private double mediaDisciplina2;
    private double mediaDisciplina3;
    private double mediaDisciplina4;
    private double mediaDisciplina5;

    private double frequencia;

}
