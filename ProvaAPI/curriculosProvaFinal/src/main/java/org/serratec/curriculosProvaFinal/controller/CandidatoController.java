package org.serratec.curriculosProvaFinal.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.curriculosProvaFinal.dto.CandidatoDto;
import org.serratec.curriculosProvaFinal.entities.Escolaridade;
import org.serratec.curriculosProvaFinal.entities.VagaDesejada;
import org.serratec.curriculosProvaFinal.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/curriculo")
public class CandidatoController {

	@Autowired
	private CandidatoService service;

	// C
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CandidatoDto createCandidato(@RequestBody @Valid CandidatoDto dto) {
		return service.createCandidato(dto);
	}

	// R
	@GetMapping
	public List<CandidatoDto> readAllCandidato() {
		return service.readAll();
	}
	

	// R{id}
	@GetMapping("/{id}")
	public ResponseEntity<CandidatoDto> readCandidatoById(@PathVariable Long id) {
		Optional<CandidatoDto> dto = service.readCandidatoById(id);
		if (!dto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(dto.get());
	}
	
	// R{name}
	@GetMapping("/candidato/{nome}")
	public List<CandidatoDto> readCandidatoByNome(@PathVariable String nome) {
		return service.readCandidatoByName(nome);
	}
	//R{escolaridade}
	@GetMapping("/candidato/escolaridade/{escolaridade}")
	public List<CandidatoDto> readCandidatoByEscolaridade(@PathVariable Escolaridade escolaridade){
		return service.readCandidatoByEscolaridade(escolaridade);
	}
	//R{vagaDesejada}
	@GetMapping("/candidato/vaga_desejada/{vagaDesejada}")
	public List<CandidatoDto> readCandidatoByVagaDesejada(@PathVariable VagaDesejada vagaDesejada){
		return service.readCandidatoByVagaDesejada(vagaDesejada);
	}
	
	
	// U
	@PutMapping("/{id}")
	public ResponseEntity<CandidatoDto> updateCandidatoById(@PathVariable Long id,
			@RequestBody @Valid CandidatoDto dto) {
		Optional<CandidatoDto> updatedCandidato = service.updateCandidato(id, dto);
		if (!updatedCandidato.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updatedCandidato.get());
	}
	
	
	// D
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCandidatoById(@PathVariable Long id) {
		if (!service.deleteCandidato(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Candidato não encontrado.");
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Candidato de ID: " + id + " deletado com sucesso.");
	}
}
