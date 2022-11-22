package br.com.cronopedia.paginasapi.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.cronopedia.paginasapi.security.UserCredentials;

public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {

    // @Autowired
    private JwtUtils jwtUtils;

    public JwtLoginFilter(String path, JwtUtils jwtUtils,  AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher(path), authenticationManager);
        this.jwtUtils = jwtUtils;
        // this.setAuthenticationManager(authenticationManager);
    }
    
    // @Override
    // public void setAuthenticationManager(AuthenticationManager authenticationManager) {
    //     super.setAuthenticationManager(authenticationManager);
    // }

    // public JwtLoginFilter(String url, AuthenticationManager authenticationManager) {
    //     super(new AntPathRequestMatcher(url), authenticationManager);
    // }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
         // Copia o conteúdo do JSON enviado pelo cliente para dentro um objeto
         /*
         * Ex: {
                username: email,
                password: senha
             }
             irá virar o objeto UserCredentials
         */ 
         UserCredentials credenciais = new ObjectMapper().readValue(request.getInputStream(), UserCredentials.class);
        //  return getAuthenticationManager().authenticate(
        //      new UsernamePasswordAuthenticationToken(credenciais.getUsername(), credenciais.getPassword()));
         return getAuthenticationManager().authenticate(
             new UsernamePasswordAuthenticationToken(credenciais.getUsername(), credenciais.getPassword()));
    }

    // Vai ser invocado caso o método attemptAuthentication seja executado sem erros.
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        System.out.println("Credenciado...");
        // O método generateJwtString vai inserir o Token Jwt na resposta HTTP com base no nome de usuário.
        jwtUtils.generateJwtString(response, authResult.getName());
    }
}
