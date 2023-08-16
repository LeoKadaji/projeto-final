package br.com.tech4me.concessionaria.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.concessionaria.model.Concessionaria;

public interface ConcessionariaRepository extends MongoRepository<Concessionaria, String> {
    
}
