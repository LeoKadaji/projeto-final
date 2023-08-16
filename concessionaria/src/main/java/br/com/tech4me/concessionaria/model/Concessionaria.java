package br.com.tech4me.concessionaria.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.tech4me.concessionaria.shared.ConcessionariaCompletoDto;

@Document("Concessionaria")
public class Concessionaria {
    @Id
    private String id;
    private String nomeConcessionaria;
    private String valorCarro;
    private TipoDePagamento tipoDePagamento;

    public Concessionaria(){}

    public Concessionaria(ConcessionariaCompletoDto dto){
        this.id = dto.id();
        this.nomeConcessionaria = dto.nomeConcessionaria();
        this.valorCarro = dto.valorCarro();
        this.tipoDePagamento = dto.tipoDePagamento();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNomeConcessionaria() {
        return nomeConcessionaria;
    }
    public void setNomeConcessionaria(String nomeConcessionaria) {
        this.nomeConcessionaria = nomeConcessionaria;
    }
    public String getValorCarro() {
        return valorCarro;
    }
    public void setValorCarro(String valorCarro) {
        this.valorCarro = valorCarro;
    }
    public TipoDePagamento getTipoDePagamento() {
        return tipoDePagamento;
    }
    public void setTipoDePagamento(TipoDePagamento tipoDePagamento) {
        this.tipoDePagamento = tipoDePagamento;
    }
}
