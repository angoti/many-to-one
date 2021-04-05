package com.professorangoti;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.professorangoti.domain.Categoria;
import com.professorangoti.domain.Item;
import com.professorangoti.repository.CategoriaRepository;
import com.professorangoti.repository.ItemRepository;

@SpringBootApplication
public class AulaManyToOneApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository catRepo;
	
	@Autowired
	ItemRepository itemRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(AulaManyToOneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Limpa a base de dados. 
		// A ordem importa aqui. Primeiro deve-se excluir todos os items antes de excluir todas as categorias.
		itemRepo.deleteAll();
		catRepo.deleteAll();
		
		Categoria cat1 = new Categoria(null, "Papelaria");
		
		Item i1 = new Item(null, "caneta bic", 0.50, LocalDate.of(2021, Month.MARCH, 15), cat1);
		Item i2 = new Item(null, "lápis 2B", 1.50, LocalDate.of(2021, Month.MARCH, 15), cat1);
		
		catRepo.save(cat1);
		itemRepo.save(i1);
		itemRepo.save(i2);
		
	}

}
