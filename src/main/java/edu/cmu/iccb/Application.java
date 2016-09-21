package edu.cmu.iccb;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableOAuth2Sso
public class Application extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	/*
	@Bean
	CommandLineRunner init() {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
			}
		};

	}*/
		
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
	      .antMatcher("/**")
	      .authorizeRequests()
	        .antMatchers("/", "/github/success", "/webjars/**", "/css", "/js", "/fonts")
	        .permitAll()
	      .anyRequest()
	        .authenticated();
		
/*		  http.authorizeRequests()
		      .antMatchers("/", "/login**", "/w.and().formLogin().loginPage("/login").permitAll()ebjars/**").permitAll() 
		      .anyRequest().authenticated();
		      /**/
		}
	

		
}
