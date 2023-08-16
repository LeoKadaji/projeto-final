package br.com.tech4me.concessionaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.tech4me.concessionaria.model.Concessionaria;
import br.com.tech4me.concessionaria.repository.ConcessionariaRepository;
import br.com.tech4me.concessionaria.shared.ConcessionariaCompletoDto;
import br.com.tech4me.concessionaria.shared.ConcessionariaDto;

public class ConcessionariaServiceImpl implements ConcessionariaService {

    @Autowired
    private ConcessionariaRepository repositorio;

    @Override
    public List<ConcessionariaDto> obterTodas() {
        return repositorio.findAll()
        .stream()
        .map(p -> new ConcessionariaDto(p.getId(), p.getNomeConcessionaria(), p.getValorCarro()))
        .toList();
    }

    @Override
    public Optional<ConcessionariaCompletoDto> obterPorId(String id) {
        Optional<Concessionaria> concessionaria = repositorio.findById(id);

    if(concessionaria.isPresent()){
        return Optional.of(new ConcessionariaCompletoDto(concessionaria.get().getId(),
        concessionaria.get().getNomeConcessionaria(),
        concessionaria.get().getValorCarro(),
        concessionaria.get().getTipoDePagamento()));
    } else{
        return Optional.empty();
    }
    }
    @Override
    public ConcessionariaCompletoDto cadastrar(ConcessionariaCompletoDto dto) {
        Concessionaria concessionaria = new Concessionaria(dto);
        repositorio.save(concessionaria);

        return new ConcessionariaCompletoDto(concessionaria.getId(),
        concessionaria.getNomeConcessionaria(),
        concessionaria.getValorCarro(),
        concessionaria.getTipoDePagamento());
    }

    @Override
    public ConcessionariaCompletoDto atualizarPorId(String id, ConcessionariaCompletoDto dto) {
        Concessionaria concessionaria = repositorio.findById(id).orElse(null);

        if(concessionaria != null){
            Concessionaria concessionariaAtualizar = new Concessionaria(dto);
            concessionariaAtualizar.setId(id);
            repositorio.save(concessionariaAtualizar);
            return new ConcessionariaCompletoDto(concessionariaAtualizar.getId(),
            concessionariaAtualizar.getNomeConcessionaria(),
            concessionariaAtualizar.getValorCarro(),
            concessionariaAtualizar.getTipoDePagamento());
        } else{
            return null;
        }
    }

    @Override
    public void excluirPorId(String id) {
        repositorio.deleteById(id);
    }

    
}
