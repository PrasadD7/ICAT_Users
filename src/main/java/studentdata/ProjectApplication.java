package studentdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
@EnableAdminServer
@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
	@Configuration
	public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
		@Override
		protected void configure(HttpSecurity http)throws Exception{
//			http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").permitAll();
//			http.logout().logoutUrl("/logout");
//			http.csrf().disable();
//			http.authorizeRequests().antMatchers("login.html","/**/*.css","/img/**","/third-party/**").permitAll();
//			http.authorizeRequests().antMatchers("/**").authenticated();
//			http.httpBasic();
			
			  http.csrf().
		        disable()
		            .authorizeRequests()
		            .antMatchers(HttpMethod.OPTIONS, "/**")
		            .permitAll()
		            .anyRequest()
		            .authenticated()
		            .and()
		            .httpBasic();
		}
	}

}
