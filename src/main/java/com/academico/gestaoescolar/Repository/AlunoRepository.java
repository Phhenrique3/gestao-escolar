package com.academico.gestaoescolar.Repository;

import com.academico.gestaoescolar.Model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
