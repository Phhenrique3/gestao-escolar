package com.academico.gestaoescolar.Controller;


import com.academico.gestaoescolar.Dto.AlunoDto;
import com.academico.gestaoescolar.Dto.MediaTurmaDTO;
import com.academico.gestaoescolar.Model.Aluno;
import com.academico.gestaoescolar.Service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/alunos")
public class AlunoController {

   private  final AlunoService service;

   public AlunoController(AlunoService alunoService) {
       this.service = alunoService;
   }

   @PostMapping
    public ResponseEntity<Aluno> salvar(@RequestBody Aluno aluno){
       return ResponseEntity.status(HttpStatus.CREATED)
               .body(service.salvar(aluno));
   }

   @GetMapping
    public ResponseEntity<List<AlunoDto>> listar(){
       return ResponseEntity.ok(service.listarAlunos());
   }

   @GetMapping("/acima-media")
    public ResponseEntity<List<String>> listarAcimaMedia(){
       return ResponseEntity.ok(service.alunosComMediaAcimaDaTurma());
   }

   @GetMapping("/frequenciaBaixa")
    public ResponseEntity<List<String>> listarFrequenciaBaixa(){
       return ResponseEntity.ok(service.alunosComFrequenciaAbaixoDe75());
   }

    @GetMapping("/media-turma")
    public ResponseEntity<MediaTurmaDTO> mediaTurma() {
        return ResponseEntity.ok(service.calcularMediaTurma());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(
            @PathVariable Long id,
            @RequestBody Aluno aluno
    ) {
        return ResponseEntity.ok(service.atualizar(id, aluno));
    }



}
