package com.academico.gestaoescolar.Service;

import com.academico.gestaoescolar.Dto.AlunoDto;
import com.academico.gestaoescolar.Dto.MediaTurmaDTO;
import com.academico.gestaoescolar.Model.Aluno;
import com.academico.gestaoescolar.Repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository repository;

    public AlunoServiceImpl(AlunoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Aluno salvar(Aluno aluno) {
        return repository.save(aluno);
    }

    @Override
    public List<AlunoDto> listarAlunos() {
        return repository.findAll().stream().map(aluno -> {
            AlunoDto dto = new AlunoDto();
            dto.setId(aluno.getId());
            dto.setNome(aluno.getNome());
            dto.setMedia(mediaAluno(aluno));
            dto.setFrequencia(aluno.getFrequencia());
            return dto;
        }).toList();
    }

    private double mediaAluno(Aluno aluno) {
        return (
                    aluno.getMediaDisciplina1() +
                        aluno.getMediaDisciplina2() +
                        aluno.getMediaDisciplina3() +
                        aluno.getMediaDisciplina4() +
                        aluno.getMediaDisciplina5()
        ) / 5;
    }

    @Override
    public MediaTurmaDTO calcularMediaTurma() {
        List<Aluno> alunos = repository.findAll();
        MediaTurmaDTO dto = new MediaTurmaDTO();

        dto.setMediaDisciplina1(
                alunos.stream().mapToDouble(Aluno::getMediaDisciplina1).average().orElse(0)
        );
        dto.setMediaDisciplina2(
                alunos.stream().mapToDouble(Aluno::getMediaDisciplina2).average().orElse(0)
        );
        dto.setMediaDisciplina3(
                alunos.stream().mapToDouble(Aluno::getMediaDisciplina3).average().orElse(0)
        );
        dto.setMediaDisciplina4(
                alunos.stream().mapToDouble(Aluno::getMediaDisciplina4).average().orElse(0)
        );
        dto.setMediaDisciplina5(
                alunos.stream().mapToDouble(Aluno::getMediaDisciplina5).average().orElse(0)
        );

        return dto;
    }

    @Override
    public List<String> alunosComMediaAcimaDaTurma() {
        double mediaTurma = calcularMediaTurmaGeral();

        List<String> alunos = repository.findAll().stream()
                .filter(aluno -> mediaAluno(aluno) > mediaTurma)
                .map(Aluno::getNome)
                .toList();

        return alunos.isEmpty() ? List.of("") : alunos;
    }
    @Override
    public List<String> alunosComFrequenciaAbaixoDe75() {
        List<String> alunos = repository.findAll().stream()
                .filter(aluno -> aluno.getFrequencia() < 75)
                .map(Aluno::getNome)
                .toList();

        return alunos.isEmpty() ? List.of("") : alunos;
    }
    private double calcularMediaTurmaGeral() {
        return repository.findAll().stream()
                .mapToDouble(this::mediaAluno)
                .average()
                .orElse(0);
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Aluno atualizar(Long id, Aluno aluno) {
        Aluno existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        existente.setNome(aluno.getNome());
        existente.setMediaDisciplina1(aluno.getMediaDisciplina1());
        existente.setMediaDisciplina2(aluno.getMediaDisciplina2());
        existente.setMediaDisciplina3(aluno.getMediaDisciplina3());
        existente.setMediaDisciplina4(aluno.getMediaDisciplina4());
        existente.setMediaDisciplina5(aluno.getMediaDisciplina5());
        existente.setFrequencia(aluno.getFrequencia());

        return repository.save(existente);
    }
}
