package com.douglaslbittencourt.trabalhojava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.douglaslbittencourt.trabalhojava.domain.Cidade;
import com.douglaslbittencourt.trabalhojava.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo;
	
	/**
	 * Retorna todas as Cidades contidas no banco de dados
	 * @return List<Cidade>
	 */
	public List<Cidade> findAll() {
		return repo.findAll();
	}
	
	/**
	 * Retorna somente as cidades que são capitais ordenadas por nome
	 * 
	 * @param boolean
	 * @return List<Cidade>
	 */
	public Page<Cidade> findCapitalOrderName(String capital, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findByCapital(capital, pageRequest);
	}
}
