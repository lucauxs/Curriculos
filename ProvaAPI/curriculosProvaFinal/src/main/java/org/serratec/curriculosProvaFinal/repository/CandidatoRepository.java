package org.serratec.curriculosProvaFinal.repository;

import java.util.List;

import org.serratec.curriculosProvaFinal.entities.Candidato;
import org.serratec.curriculosProvaFinal.entities.Escolaridade;
import org.serratec.curriculosProvaFinal.entities.VagaDesejada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Long>{
	List<Candidato> findCandidatoByNomeIgnoreCase(String nome);
	List<Candidato> findCandidatoByEscolaridade(Escolaridade escolaridade);
	List<Candidato> findCandidatoByVagaDesejada(VagaDesejada vagaDesejada);
}
