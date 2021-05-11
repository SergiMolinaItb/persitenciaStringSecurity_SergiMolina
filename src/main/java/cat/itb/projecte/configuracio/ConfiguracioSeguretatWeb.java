package cat.itb.projecte.configuracio;

import cat.itb.projecte.servei.ElMeuUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class ConfiguracioSeguretatWeb extends WebSecurityConfigurerAdapter {

    @Autowired
    private ElMeuUserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/register","/templates/**","/error","/errorlogin","/login")
                .permitAll()

                .antMatchers("/empleats/eliminar/**").hasRole("ADMIN")
                .antMatchers("/empleats/new/**").hasRole("ADMIN")
                .antMatchers("/webjars/**", "/css/**","/login","/", "/register/**").permitAll()

                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/home",true)
                .failureUrl("/login?error")
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();

    }

}