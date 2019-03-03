package com.douglaslbittencourt.trabalhojava.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@RequestMapping(value="/questaoDois", method=RequestMethod.GET)
	public ResponseEntity<List<Cidade>> findPage() {
		List<Cidade> list = service.findCapitalOrderName();
		return ResponseEntity.ok().body(list);
	}
	
	
	@RequestMapping(value="/questaoTresMax", method=RequestMethod.GET)
	public ResponseEntity<List<Cidade>> findByMaxUf() {
		List<Cidade> list = service.findByMaxUf();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/questaoTresMin", method=RequestMethod.GET)
	public ResponseEntity<List<Cidade>> findByMinUf() {
		List<Cidade> list = service.findByMinUf();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/questaoQuatro", method=RequestMethod.GET)
	public ResponseEntity<List<Cidade>> findByUf() {
		List<Cidade> list = service.findByUf();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/questaoCinco", method=RequestMethod.GET)
	public ResponseEntity<List<Cidade>> findById(@RequestParam("id") String id) {
		List<Cidade> obj = service.findById(Integer.parseInt(id));
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/questaoSeis", method=RequestMethod.GET)
	public ResponseEntity<List<Cidade>> findByNomeInEstados(@RequestParam("uf") String uf) {
		List<Cidade> obj = service.findByNomeInEstados(uf);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value="/questaoSete", method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Cidade obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/questaoOito{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/questaoOnze", method=RequestMethod.GET)
	public ResponseEntity<List<Cidade>> findByCount() {
		List<Cidade> list = service.findByCount();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/questaoDoze", method=RequestMethod.GET)
	public ResponseEntity<List<Cidade>> findByDistance() {
		List<Cidade> list = service.findByDistance();
		return ResponseEntity.ok().body(list);
	}
}
