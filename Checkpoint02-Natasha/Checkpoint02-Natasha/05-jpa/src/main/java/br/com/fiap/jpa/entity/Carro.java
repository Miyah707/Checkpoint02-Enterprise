package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tb_carro")
public class Carro implements Serializable{

	private static final long serialVersionUID = 4073510199087371083L;

	private Acessorio acessorio;
	
	public Carro() {
		this.ativo = true;
	}
	
	public Carro(Acessorio acessorio, String placa, String cor, String chassi) {
		this();
		this.acessorio = acessorio;
		this.placa = placa;
		this.cor = cor;
		this.chassi = chassi;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Carro")
	private Long id;
	
	@Column(name = "dt_acessorio", nullable = false)
	private LocalDate dataAcessorio;
	
	@Column(name = "st_ativo")
	private Boolean ativo;
	
	@Column(name = "dt_placa")
	private LocalDateTime dataplaca;
	
	@Column(name = "dt_cor")
	private LocalDateTime datacor;
	
	@Column(name = "dt_chassi")
	private LocalDateTime datachassi;
	
	@OneToOne(mappedBy = "acessorio", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Acessorio Acessorio;
	
	@ManyToOne
	@JoinColumn(name = "acessorio_id")
	private Acessorio acessorio1;
	
	@ManyToOne
	@JoinColumn(name = "modelo_id")
	private Modelo modelo;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Acessorio getAcessorio() {
		return acessorio;
	}

	public void setAcessorio(Acessorio acessorio) {
		this.acessorio = acessorio;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	@Override
	public String toString() {
		return "\nAcessorio: " + this.getAcessorio().getDescricao()
				+ "\nModelo: " + this.getModelo().getDescricao()
	}

}
