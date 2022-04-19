package br.com.fiap.jpa;

import java.time.LocalDate;

import br.com.fiap.jpa.entity.Acessorio;
import br.com.fiap.jpa.entity.Carro;
import br.com.fiap.jpa.entity.Modelo;
import br.com.fiap.jpa.service.impl.ModeloServiceImpl;
import br.com.fiap.jpa.service.impl.CarroServiceImpl;
import br.com.fiap.jpa.service.impl.AcessorioServiceImpl;

public class App {

	public static void main(String[] args) {
		
		AcessorioServiceImpl acessorioService = AcessorioServiceImpl.getInstance();
		ModeloServiceImpl modeloService = ModeloServiceImpl.getInstance();
		CarroServiceImpl carroService = CarroServiceImpl.getInstance();
		
		Acessorio acessorio1 = new Acessorio("Acessorio 1", "modelo 1");
		Acessorio acessorio2 = new Acessorio("Acessorio 2", "modelo 2");
		
		acessorioService.inserir(acessorio1);
		acessorioService.inserir(acessorio2);
		
		acessorioService.listar().forEach(System.out::println);
		
		acessorioService.listar().forEach(System.out::println);
	
	}
}
