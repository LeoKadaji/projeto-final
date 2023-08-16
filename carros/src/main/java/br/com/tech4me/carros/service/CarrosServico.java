package br.com.tech4me.carros.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.carros.shared.CarrosCompletoDto;
import br.com.tech4me.carros.shared.CarrosDto;

public interface CarrosServico {
    CarrosCompletoDto cadastrarCarro(CarrosCompletoDto dto);
    List<CarrosCompletoDto> obterCarros();
    Optional<CarrosDto> obterCarrosPorId(String id);
    void excluirCarro(String id);
    Optional<CarrosDto> atualizarCarrosPorId(String id, CarrosDto dto);
    
}
