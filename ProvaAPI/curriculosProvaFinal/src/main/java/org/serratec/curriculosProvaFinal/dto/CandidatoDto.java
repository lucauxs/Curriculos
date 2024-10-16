package org.serratec.curriculosProvaFinal.dto;

import java.time.LocalDate;

import org.serratec.curriculosProvaFinal.entities.Candidato;
import org.serratec.curriculosProvaFinal.entities.Escolaridade;
import org.serratec.curriculosProvaFinal.entities.StatusCurriculo;
import org.serratec.curriculosProvaFinal.entities.VagaDesejada;

public record CandidatoDto(
		Long id,
		String nome,
		LocalDate dataNascimento,
		String cpf,
		Escolaridade escolaridade,
		VagaDesejada vagaDesejada,
		StatusCurriculo statusCurriculo
		) {
	public Candidato toEntity() {
		Candidato candidato = new Candidato();
		candidato.setId(this.id);
		candidato.setNome(this.nome);
		candidato.setDataNascimento(this.dataNascimento);
		candidato.setCpf(this.cpf);
		candidato.setEscolaridade(this.escolaridade);
		candidato.setVagaDesejada(this.vagaDesejada);
		candidato.setStatusCurriculum(this.statusCurriculo);
		return candidato;
	}
	public static CandidatoDto toDto(Candidato candidato) {
		return new CandidatoDto(
				candidato.getId(),
				candidato.getNome(), 
				candidato.getDataNascimento(), 
				candidato.getCpf(), 
				candidato.getEscolaridade(), 
				candidato.getVagaDesejada(), 
				candidato.getStatusCurriculum());
	}
}
