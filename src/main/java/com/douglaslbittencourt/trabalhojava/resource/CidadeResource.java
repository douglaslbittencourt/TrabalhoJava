package com.douglaslbittencourt.trabalhojava.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.douglaslbittencourt.trabalhojava.domain.Cidade;
import com.douglaslbittencourt.trabalhojava.service.CidadeService;

@RestController
@RequestMapping(value="/cidades")
public class CidadeResource {

	@Autowired
	private CidadeService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Cidade> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
