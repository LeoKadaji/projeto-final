package br.com.tech4me.carros.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.tech4me.carros.shared.CarrosCompletoDto;
import br.com.tech4me.carros.shared.CarrosDto;

@Document("Carros")
public class Carros {
    @Id
    private String id;
    private String nome;
    private String marcaCarro;
    private String ano;

    public Carros(){}

    public Carros(CarrosCompletoDto dto){
        this.id = dto.id();
        this.nome = dto.nome();
        this.marcaCarro = dto.marcaCarro();
        this.ano = dto.ano();
    }

    public Carros(CarrosDto dto){
        this.nome = dto.nome();
        this.marcaCarro = dto.marcaCarro();
        this.ano = dto.ano();
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getMarcaCarro() {
        return marcaCarro;
    }
    public void setMarcaCarro(String marcaCarro) {
        this.marcaCarro = marcaCarro;
    }
    public String getAno() {
        return ano;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }
}
