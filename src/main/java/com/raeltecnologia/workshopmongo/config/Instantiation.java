package com.raeltecnologia.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.raeltecnologia.workshopmongo.domain.Post;
import com.raeltecnologia.workshopmongo.domain.User;
import com.raeltecnologia.workshopmongo.repository.PostRepository;
import com.raeltecnologia.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post (null, sdf.parse("26/10/2022"), "Partiu Viagem", "Vou viajar para São Paulo abraços!", maria);
		
		Post post2 = new Post (null, sdf.parse("27/10/2022"), "Bom dia", "Acordei feliz hoje!", maria);
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
