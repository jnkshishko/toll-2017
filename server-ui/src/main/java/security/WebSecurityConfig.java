package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                    .antMatchers("/img", "/css").permitAll()
                    .antMatchers("/", "/home").authenticated()
                    .antMatchers("/registerClient").hasRole("MANAGER")
                    .antMatchers("/registerManager").hasRole("ROOT")
                    .anyRequest().hasRole("CLIENT")
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();


    }

    @Autowired
    public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception {

        auth
                .inMemoryAuthentication()
                .withUser("client").password("clientpassword").roles("CLIENT")
                .and()
                .withUser("manager").password("managerpassword").roles("MANAGER", "CLIENT")
                .and()
                .withUser("root").password("rootpassword").roles("ROOT", "CLIENT", "MANAGER");

    }
}
