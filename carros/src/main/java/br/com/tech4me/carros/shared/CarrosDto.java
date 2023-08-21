package br.com.tech4me.carros.shared;

import br.com.tech4me.carros.model.Carros;

public record CarrosDto(String nome, String marcaCarro, String ano, Carros carro) {
    
}
