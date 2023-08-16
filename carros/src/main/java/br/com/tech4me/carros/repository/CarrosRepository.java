package br.com.tech4me.carros.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.carros.model.Carros;

public interface CarrosRepository extends MongoRepository<Carros, String> {
    
}
