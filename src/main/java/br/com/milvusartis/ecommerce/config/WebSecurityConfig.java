//package br.com.milvusartis.ecommerce.config;
//
//import br.com.milvusartis.ecommerce.service.CustomUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
////
////@EnableWebSecurity
////@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http//HttpSecurity
////                //Pedir que todas as rotas autorizem
////                .authorizeRequests()
////                .antMatchers("/admin/*").hasRole("ADMIN")
////                .anyRequest().hasRole("USER")
//////                .authorizeRequests().anyRequest().authenticated()
//////                  .authorizeRequests().anyRequest().hasRole("ADMIN")
////
////
////                //Tirar a sessão da aplicação.
////                .and()
////                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////
////                //Ligar a config do HTTP basic
////                .and()
////                .httpBasic()
////                //Desabilitar o CSRF token
////                .and()
////                .csrf().disable();
////    }
//
////    @Autowired
////    protected void criarUsuarios(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
////    }
////    @Autowired
////    protected void criarUsuarios(AuthenticationManagerBuilder auth) throws Exception {
////        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
////        auth.inMemoryAuthentication()
////                .withUser("herry@potter.com.br")
////                .password(encoder.encode("segredo")).roles("USER");
////    }
//}