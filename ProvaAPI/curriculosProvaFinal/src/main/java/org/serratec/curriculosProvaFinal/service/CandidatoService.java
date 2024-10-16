package org.serratec.curriculosProvaFinal.service;

import java.util.List;
import java.util.Optional;

import org.serratec.curriculosProvaFinal.dto.CandidatoDto;
import org.serratec.curriculosProvaFinal.entities.Candidato;
import org.serratec.curriculosProvaFinal.entities.Escolaridade;
import org.serratec.curriculosProvaFinal.entities.VagaDesejada;
import org.serratec.curriculosProvaFinal.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatoService {
	
	@Autowired
	private CandidatoRepository repository;
	
	//C
	public CandidatoDto createCandidato(CandidatoDto dto) {
		return CandidatoDto.toDto(repository.save(dto.toEntity()));
	}
	
	//R
	public List<CandidatoDto> readAll() {
		return repository.findAll().stream().map(c -> CandidatoDto.toDto(c)).toList();
	}
	//R{id}
	public Optional<CandidatoDto> readCandidatoById(Long id){
		if (!repository.existsById(id)) {
			return Optional.empty();
		}
		return Optional.of(CandidatoDto.toDto(repository.findById(id).get()));
	}
	//R{nome}
	public List<CandidatoDto> readCandidatoByName(String name) {
		List<Candidato> candidato = repository.findCandidatoByNomeIgnoreCase(name);
		return candidato.stream().map(c -> CandidatoDto.toDto(c)).toList();
	}
	//R{escolaridade}
	public List<CandidatoDto> readCandidatoByEscolaridade(Escolaridade escolaridade){
		List<Candidato> candidato = repository.findCandidatoByEscolaridade(escolaridade);
		return candidato.stream().map(c -> CandidatoDto.toDto(c)).toList();
	}
	//R{vagaDesejada}
	public List<CandidatoDto> readCandidatoByVagaDesejada(VagaDesejada vagaDesejada) {
		List<Candidato> candidato = repository.findCandidatoByVagaDesejada(vagaDesejada);
		return candidato.stream().map(c -> CandidatoDto.toDto(c)).toList();
	}
	
	//U
	public Optional<CandidatoDto> updateCandidato(Long id, CandidatoDto dto){
		if (!repository.existsById(id)) {
			return Optional.empty();
		}
		Candidato candidatoEntity = dto.toEntity();
		candidatoEntity.setId(id);
		repository.save(candidatoEntity);
		return Optional.of(CandidatoDto.toDto(candidatoEntity));
	}
	
	//D
	public Boolean deleteCandidato(Long id) {
		if (!repository.existsById(id)) {
			return false;
		}
		repository.deleteById(id);
		return true;
	}
}
