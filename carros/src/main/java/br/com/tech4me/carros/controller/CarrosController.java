package br.com.tech4me.carros.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.tech4me.carros.service.CarrosServico;
import br.com.tech4me.carros.shared.CarrosCompletoDto;
import br.com.tech4me.carros.shared.CarrosDto;

@RestController
@RequestMapping("/carros")
public class CarrosController {
    @Autowired
    private CarrosServico servico;

    @PostMapping
    public ResponseEntity<CarrosCompletoDto> cadastrarCarro(@RequestBody CarrosCompletoDto carro){
        return new ResponseEntity<>(servico.cadastrarCarro(carro), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<CarrosCompletoDto>> obterCarros(){
        return new ResponseEntity<>(servico.obterCarros(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarrosDto> obterCarroPorId(@PathVariable String id){
        Optional<CarrosDto> retorno = servico.obterCarrosPorId(id);

        if(retorno.isPresent()){
            return new ResponseEntity<>(retorno.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCarro(@PathVariable String id){
        servico.excluirCarro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarrosDto> atualizarCarro(@PathVariable String id, @RequestBody CarrosDto carro){
        Optional<CarrosDto> retorno = servico.atualizarCarrosPorId(id, carro);

        if(retorno.isEmpty()){
            return new ResponseEntity<>(retorno.get(), HttpStatus.ACCEPTED);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

}