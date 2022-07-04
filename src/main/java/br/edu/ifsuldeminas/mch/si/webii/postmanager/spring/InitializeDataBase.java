package br.edu.ifsuldeminas.mch.si.webii.postmanager.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.Address;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.User;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.repositories.AddressRepository;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.repositories.UserRepository;

@Component
public class InitializeDataBase implements CommandLineRunner{
	
	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private AddressRepository aRepo;
	
	@Override
	public void run(String... args) throws Exception {
		Address aEmerson = new Address();
		aEmerson.setPlace("A");
		aEmerson.setNumber(1);
		aEmerson.setZipCode("123");
		
		Address aLuiza = new Address();
		aLuiza.setPlace("B");
		aLuiza.setNumber(2);
		aLuiza.setZipCode("456");
		
		aRepo.save(aEmerson);
		aRepo.save(aLuiza);
		aRepo.flush();
		
		User emerson = new User();
		emerson.setName("Emerson Assis");
		emerson.setEmail("assis@gmail.com");
		emerson.setGender("M");
		emerson.setAddress(aEmerson);
		
		User luiza = new User();
		luiza.setName("Luiza Carvalho");
		luiza.setEmail("lu@mail.com");
		luiza.setGender("F");
		luiza.setAddress(aLuiza);
		
		uRepo.save(emerson);
		uRepo.save(luiza);
	}
}
