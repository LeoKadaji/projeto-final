package br.com.tech4me.concessionaria.shared;

import br.com.tech4me.concessionaria.model.TipoDePagamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ConcessionariaCompletoDto(String id,
@NotEmpty(message = "o nome da concessionaria deve ser adicioada!")
String nomeConcessionaria,
@NotBlank(message = "o valor do carro está em branco.")
@Positive(message = "o valor deve ser positivo.")
String valorCarro,
@NotNull(message = "valores válidos: DINHEIRO, CARTAO, BOLETO")
TipoDePagamento tipoDePagamento) {
}
    
