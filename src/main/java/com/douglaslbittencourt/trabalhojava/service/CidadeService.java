package com.douglaslbittencourt.trabalhojava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
