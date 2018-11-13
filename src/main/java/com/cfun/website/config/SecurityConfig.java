package com.cfun.website.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.cfun.website.service.CompanyUserService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
  @Autowired
  CompanyUserService companyUserService;
  
  @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {		
	
		 auth.userDetailsService(companyUserService);  
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		  .formLogin()
		  .loginPage("/login").defaultSuccessUrl("/admin").failureUrl("/loginError")
		  .and()
		  .rememberMe().tokenValiditySeconds(2419200).key("cfunKey")         //cookie中的jielongKey保存四周时间
		  .and()
		  .authorizeRequests()
		  .antMatchers("/admin").authenticated()
		  .anyRequest().permitAll();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	
	}
	
}
