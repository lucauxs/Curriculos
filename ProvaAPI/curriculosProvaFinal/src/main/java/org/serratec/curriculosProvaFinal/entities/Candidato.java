package org.serratec.curriculosProvaFinal.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
public class Candidato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(min = 3, max = 50, message = "O nome deve conter de 3 a 50 caracteres")
	private String nome;
	@NotNull
	@Past(message = "A data de nascimento deve ser uma data anterior")
	private LocalDate dataNascimento;
	@NotBlank
	@Size(min = 11, max = 14, message = "O cpf deve conter de 11 a 14 caracteres")
	private String cpf;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Escolaridade escolaridade;
	@NotNull
	@Enumerated(EnumType.STRING)
	private VagaDesejada vagaDesejada;
	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusCurriculo statusCurriculum;
	
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public Escolaridade getEscolaridade() {
		return escolaridade;
	}
	public VagaDesejada getVagaDesejada() {
		return vagaDesejada;
	}
	public StatusCurriculo getStatusCurriculum() {
		return statusCurriculum;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}
	public void setVagaDesejada(VagaDesejada vagaDesejada) {
		this.vagaDesejada = vagaDesejada;
	}
	public void setStatusCurriculum(StatusCurriculo statusCurriculum) {
		this.statusCurriculum = statusCurriculum;
	}
}
