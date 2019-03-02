package com.douglaslbittencourt.trabalhojava.repositories;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.douglaslbittencourt.trabalhojava.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Serializable> {

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Cidade obj WHERE obj.capital = :capital ORDER BY obj.name ")
	Page<Cidade>findByCapital(@Param("capital") String capital, Pageable pageRequest);


}