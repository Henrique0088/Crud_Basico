package br.com.senai.teste.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.teste.service.AlunoService;
import br.com.senai.teste.model.Aluno;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<Aluno> cadastrar
    (@RequestBody Aluno aluno) {
        Aluno novoAluno = alunoService.cadastrar(aluno);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
    }
}
