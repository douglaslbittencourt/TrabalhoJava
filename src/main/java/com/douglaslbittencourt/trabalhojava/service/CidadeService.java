package com.douglaslbittencourt.trabalhojava.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.douglaslbittencourt.trabalhojava.domain.Cidade;
import com.douglaslbittencourt.trabalhojava.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo;
	
	private EntityManager em;
	
	/**
	 * Questão 01
	 * Retorna todas as Cidades contidas no banco de dados
	 * @return List<Cidade>
	 */
	public List<Cidade> findAll() {
		return repo.findAll();
	}
	
	/**
	 * Questão 02
	 * Retorna somente as cidades que são capitais ordenadas por nome
	 * 
	 * @param boolean
	 * @return List<Cidade>
	 */
	public List<Cidade> findCapitalOrderName() {
		return repo.findByCapital();
	}
	
	/**
	 * Questão 03 Min
	 * Retorna o estado com a menor quantidade de cidades
	 * 
	 * @return List<Cidade>
	 */
	public List<Cidade> findByMinUf() {
		PageRequest pageRequest = PageRequest.of(0, 1);
		return repo.findByMinUf(pageRequest);
	}

	/**
	 * Questão 03 Max
	 * Retorna o estado com a maior quantidade de cidades
	 * 
	 * @return List<Cidade>
	 */
	public List<Cidade> findByMaxUf() {
		PageRequest pageRequest = PageRequest.of(0, 1);
		return repo.findByMaxUf(pageRequest);
	}
	
	/**
	 * Questão 04
	 * Retornar a quantidade de cidades por estado
	 * 
	 * @return List<Cidade>
	 */
	public List<Cidade> findByUf() {
		return repo.findByUf();
	}
	
	/**
	 * Questão 05
	 * Retorna a Cidade de acordo com o Id passado por parametro
	 * 
	 * @param Integer id
	 * @return List<Cidade>
	 */
	public List<Cidade> findById(Integer id) {
		return repo.findById(id);
	}
	
	/**
	 * Questão 06
	 * Retornar o nome das cidades baseado em um estado selecionado
	 * 
	 * @param String uf
	 * @return List<Cidade>
	 */
	public List<Cidade> findByNomeInEstados(String uf) {
		return repo.findByNomeInEstados(uf);
	}
	
	/**
	 * Questão 07
	 * Insere uma nova pessoa
	 * 
	 * @param Cidade obj
	 * @return Cidade
	 */
	public Cidade insert(Cidade obj) {
		return repo.save(obj);
	}
	
	/**
	 * Questão 08
	 * Deleta uma pessoa pelo id
	 * 
	 * @param Integer id
	 */
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	/**
	 * Questão 11
	 * Retornar a quantidade de registros total;
	 * 
	 * @return List<Cidade>
	 */
	public List<Cidade> findByCount() {
		return repo.findByCount();
	}
	
	/**
	 * Questão 12
	 * Dentre todas as cidades, Retorna as duas cidades mais distantes uma da outra com base na localização
	 * 
	 * @return List<Cidade>
	 */
	public List<Cidade> findByDistance() {
		return repo.findByDistance();
	}
	
}
