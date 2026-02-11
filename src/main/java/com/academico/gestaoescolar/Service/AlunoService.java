package com.academico.gestaoescolar.Service;

import com.academico.gestaoescolar.Dto.AlunoDto;
import com.academico.gestaoescolar.Dto.MediaTurmaDTO;
import com.academico.gestaoescolar.Model.Aluno;

import java.util.List;


public interface AlunoService {

    Aluno salvar(Aluno aluno);

    List<AlunoDto> listarAlunos();

    MediaTurmaDTO calcularMediaTurma();

    List<String> alunosComMediaAcimaDaTurma();

    List<String> alunosComFrequenciaAbaixoDe75();

    void deletar(Long id);
    Aluno atualizar(Long id, Aluno aluno);

}
