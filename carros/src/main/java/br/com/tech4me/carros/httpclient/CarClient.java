package br.com.tech4me.carros.httpclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.tech4me.carros.model.Carros;

@FeignClient("carros")
public interface CarClient {
    @RequestMapping(method = RequestMethod.GET, value = "/carros/{id}")
    Carros obterCarros(@PathVariable String id);
    
}
