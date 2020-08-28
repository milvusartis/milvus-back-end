package br.com.milvusartis.ecommerce.config;

import br.com.milvusartis.ecommerce.security.JWTAuthenticationFilter;
import br.com.milvusartis.ecommerce.security.JWTAuthorizationFilter;
import br.com.milvusartis.ecommerce.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    protected void criarUsuarios(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println(auth);
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }


//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
//                .and()
//                .csrf().disable()
//                .httpBasic()
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//
//                .authorizeRequests()
//
//                //CONFIGURAÇÃO DE REQUEST
//                .anyRequest().permitAll()
//                .and().headers().frameOptions()
//                //Disable para desbloquar o formulário do H2
//                .disable();
//    }

    @Autowired
    private Environment env;

    private static final String[] PUBLIC_MATCHERS = {
            "/h2/**",
            "/h2-console/**",
            "/auth/user",
            "/swagger-ui.html/**",
            "/swagger.json/**"
    };

    private static final String[] PUBLIC_MATCHERS_GET = {
            "/produtos/**",
            "/categorias/**",
    };

    private static final String[] PUBLIC_MATCHERS_POST = {
            "/clientes/**",
            "/auth/forgot/**",
            "/enviarcontato"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        if (Arrays.asList((env.getActiveProfiles())).contains("test") || Arrays.asList((env.getActiveProfiles())).contains("dev")) {
            http.headers().frameOptions().disable();
        }

        http.cors().and().csrf().disable();
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
                .antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
                .antMatchers(PUBLIC_MATCHERS).permitAll()
                .anyRequest().authenticated();
        http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
        http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {;
        CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
        configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}