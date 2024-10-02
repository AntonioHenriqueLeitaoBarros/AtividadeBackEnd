package com.antonio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antonio.dto.PessoaDTO;
import com.antonio.entity.Pessoa;
import com.antonio.repository.PessoaRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;



@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setCpf(pessoaDTO.getCpf());
        pessoa.setIdade(pessoaDTO.getIdade());
        pessoaRepository.save(pessoa);
        return ResponseEntity.ok(pessoa);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("Endpoint funcionando");
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> obterPessoaPorId(@PathVariable Long id) {
        Optional<Pessoa> pessoaOpt = pessoaRepository.findById(id);
        return pessoaOpt.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
