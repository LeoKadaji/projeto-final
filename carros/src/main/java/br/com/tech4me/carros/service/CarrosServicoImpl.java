package br.com.tech4me.carros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.carros.httpclient.CarClient;
import br.com.tech4me.carros.model.Carros;
import br.com.tech4me.carros.repository.CarrosRepository;
import br.com.tech4me.carros.shared.CarrosCompletoDto;
import br.com.tech4me.carros.shared.CarrosDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CarrosServicoImpl implements CarrosServico {

    @Autowired
    private CarrosRepository repositorio;

    @Autowired
    private CarClient carrosClient;

    @Override
    public CarrosCompletoDto cadastrarCarro(CarrosCompletoDto dto) {
        Carros carros = new Carros(dto);
        repositorio.save(carros);
        return new CarrosCompletoDto(carros.getId(), carros.getNome(), carros.getMarcaCarro(), carros.getAno());
    }

    @Override
    public List<CarrosCompletoDto> obterCarros() {
        return repositorio.findAll()
        .stream()
        .map(p -> new CarrosCompletoDto(p.getId(), p.getNome(), p.getMarcaCarro(), p.getAno()))
        .toList();
    }

    @CircuitBreaker(name = "obterCarros", fallbackMethod = "fallbackCarrosPorId")
    @Override
    public Optional<CarrosDto> obterCarrosPorId(String id) {
        Optional<Carros> carros = repositorio.findById(id);

        if(carros.isPresent()){
            Carros carro = carrosClient.obterCarros(carros.get().getId());
            CarrosDto dtocarros = new CarrosDto(carros.get().getNome(), carros.get().getMarcaCarro(), carros.get().getAno(), carro);
            return Optional.of(dtocarros);
        } else{
            return Optional.empty();
        }
    }

    public Optional<CarrosDto> fallbackCarrosPorId(String id, Exception e) {
        Optional<Carros> carros = repositorio.findById(id);

        if(carros.isPresent()){
            CarrosDto dtocarros = new CarrosDto(carros.get().getNome(), carros.get().getMarcaCarro(), carros.get().getAno(), null);
            return Optional.of(dtocarros);
        } else{
            return Optional.empty();
        }
    }

    @Override
    public void excluirCarro(String id) {
        repositorio.deleteById(id);
    }

    @Override
    public Optional<CarrosDto> atualizarCarrosPorId(String id, CarrosDto dto) {
        Optional<Carros> carros = repositorio.findById(id);

        if(carros.isPresent()){
            Carros carrosAtualizar = new Carros(dto);
            carrosAtualizar.setId(id);
            repositorio.save(carrosAtualizar);
            return Optional.of(dto);
        } else{
            return Optional.empty();
        }
    }
    
}
