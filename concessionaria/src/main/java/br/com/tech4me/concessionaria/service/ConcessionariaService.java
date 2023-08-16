package br.com.tech4me.concessionaria.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.concessionaria.shared.ConcessionariaCompletoDto;
import br.com.tech4me.concessionaria.shared.ConcessionariaDto;

public interface ConcessionariaService {
    List<ConcessionariaDto> obterTodas();
    Optional<ConcessionariaCompletoDto> obterPorId(String id);
    ConcessionariaCompletoDto cadastrar(ConcessionariaCompletoDto dto);
    ConcessionariaCompletoDto atualizarPorId(String id, ConcessionariaCompletoDto dto);
    void excluirPorId(String id);
}
