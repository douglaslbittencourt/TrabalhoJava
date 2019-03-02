package com.douglaslbittencourt.trabalhojava.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglaslbittencourt.trabalhojava.domain.Cidade;
import com.douglaslbittencourt.trabalhojava.repositories.CidadeRepository;

@Service
public class DBService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	/**
	 * Instancia o arquivo csv no banco, para isso é necessario que o arquivo esteja na na pasta C: e tenha o nome Trabalho Java - Cidades.csv
	 * @throws IOException
	 */
	public void instantiateDatabase() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:/Trabalho Java - Cidades.csv")));
		String linha = null;
		String primeiraLinha = reader.readLine();
		
		while ((linha = reader.readLine()) != null) {
			String[] csv = linha.split(",");
			Cidade cidade = new Cidade(Integer.parseInt(csv[0]), csv[1], csv[2], csv[3], Double.parseDouble(csv[4]), Double.parseDouble(csv[5]), csv[6], csv[7], csv[8], csv[9]);
			cidadeRepository.save(cidade);
		}
		reader.close();
	}

}
