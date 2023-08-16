package br.com.tech4me.concessionaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.concessionaria.service.ConcessionariaService;
import br.com.tech4me.concessionaria.shared.ConcessionariaCompletoDto;
import br.com.tech4me.concessionaria.shared.ConcessionariaDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/concessionaria")
public class ConcessionariaController {
    
    @Autowired
    private ConcessionariaService servico;

    @GetMapping("/porta")
    private String obterPorta(@Value("${local.server.port}") String porta){
        return "A instância que respondeu a requisição está rodando na porta " + porta;
    }
    
    @GetMapping
    private ResponseEntity<List<ConcessionariaDto>> obterConcessionarias(){
        return new ResponseEntity<>(servico.obterTodas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<ConcessionariaCompletoDto> obterConcessionariaPorId(@PathVariable String id){
        Optional<ConcessionariaCompletoDto> concessionaria = servico.obterPorId(id);

        if (concessionaria.isPresent()){
            return new ResponseEntity<>(concessionaria.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    private ResponseEntity<ConcessionariaCompletoDto> cadastrarConcessionaria(@RequestBody @Valid ConcessionariaCompletoDto concessionaria){
        return new ResponseEntity<>(servico.cadastrar(concessionaria), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> excluirConcessionariaPorId(@PathVariable String id){
        servico.excluirPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    private ResponseEntity<ConcessionariaCompletoDto> atualizarConcessionaria(@PathVariable String id, @RequestBody @Valid ConcessionariaCompletoDto concessionaria){
        ConcessionariaCompletoDto concessionariaAtualizada = servico.atualizarPorId(id, concessionaria); 

        if (concessionariaAtualizada != null){
            return new ResponseEntity<>(concessionariaAtualizada, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    } 

}
