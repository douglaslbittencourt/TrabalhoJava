package com.douglaslbittencourt.trabalhojava.repositories;

import java.io.Serializable;
import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.douglaslbittencourt.trabalhojava.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Serializable> {

	/**
	 * Questão 02
	 * Retorna somente as cidades que são capitais ordenadas por nome
	 */
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Cidade obj WHERE obj.capital = 'true' ORDER BY obj.name ")
	List<Cidade>findByCapital();


	/**
	 * Questão 03 MAX
	 * Retorna o estado com a maior quantidade de cidades
	 */
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj.uf, COUNT(1) FROM Cidade obj GROUP BY 1 ORDER BY 2 DESC")
	List<Cidade>findByMaxUf(Pageable pageRequest);

	/**
	 * Questão 03 MIN
	 * Retorna o estado com a menor quantidade de cidades
	 */
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT c.uf, COUNT(1) FROM Cidade c GROUP BY 1 ORDER BY 2 ")
	List<Cidade>findByMinUf(Pageable pageRequest);
	
	/**
	 * Questão 04
	 * Retornar a quantidade de cidades por estado
	 */
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj.uf as uf, COUNT(1) as contador FROM Cidade obj GROUP BY obj.uf ")
	List<Cidade>findByUf();
	
	/**
	 * Questão 05
	 * Retorna a Cidade de acordo com o Id passado por parametro
	 */
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Cidade obj WHERE obj.id = :id ")
	List<Cidade>findById(@Param("id") Integer id);
	
	/**
	 * Questão 06
	 * Retornar o nome das cidades baseado em um estado selecionado
	 */
	@Transactional(readOnly=true)
	@Query("SELECT obj.name FROM Cidade obj WHERE obj.uf =:uf ")
	List<Cidade>findByNomeInEstados(@Param("uf") String uf);
	
	/**
	 * Questao 11
	 * Retornar a quantidade de registros total;
	 */
	@Transactional(readOnly=true)
	@Query("SELECT COUNT(1) FROM Cidade obj ")
	List<Cidade>findByCount();
	
	/**
	 * Questao 12
	 * Dentre todas as cidades, Retorna as duas cidades mais distantes uma da outra com base na localização
	 */
	@Transactional(readOnly=true)
	@Query("SELECT MAX(6371*ACOS(COS(PI()*(90-c2.lat)/180)*COS((90-c1.lat)*PI()/180)+SIN((90-c2.lat)*PI()/180)*SIN((90-c1.lat)*PI()/180)*COS((c1.lon-c2.lon)*PI()/180))), c1.name, c2.name FROM Cidade c1, Cidade c2 where NOT(c1.id = c2.id) ")
	List<Cidade>findByDistance();

}