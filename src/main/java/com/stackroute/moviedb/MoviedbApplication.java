package com.stackroute.moviedb;

import com.stackroute.moviedb.domain.Movie;
import com.stackroute.moviedb.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MoviedbApplication implements ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {

	@Autowired
	private MovieRepository movieRepository;
	public static void main(String[] args) {
		SpringApplication.run(MoviedbApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		Movie m1=new Movie("tt22015","Dosti","http://dosti.jpg",7.4,"2012","agd");
		movieRepository.save(m1);
		Movie m2=new Movie("tt23226","DDLJ","http://ddlj.jpg",9.5,"2014","dsgdsa");
		movieRepository.save(m2);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		Movie m1=new Movie("tt23025","Faasle","http://fasle.jpg",5.2,"2004","vds");
		movieRepository.save(m1);
		Movie m2=new Movie("tt23026","Yaariyan","http://yaariyan.jpg",7.2,"2014","vgda");
		movieRepository.save(m2);


	}
}
