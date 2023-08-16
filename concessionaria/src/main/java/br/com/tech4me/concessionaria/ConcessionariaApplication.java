package br.com.tech4me.concessionaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConcessionariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcessionariaApplication.class, args);
	}

}
