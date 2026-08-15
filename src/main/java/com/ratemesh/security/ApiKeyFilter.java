package com.ratemesh.security;

import com.ratemesh.repository.ClientRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class ApiKeyFilter extends OncePerRequestFilter
{

    private ClientRepository repo;

    @Autowired
    public ApiKeyFilter(ClientRepository repo) {
        this.repo = repo;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
        String apiKey = request.getHeader("X-API-KEY");

        if (request.getRequestURI().equals("/api/add/new")) {
            filterChain.doFilter(request, response);
            return;
        }

        if (apiKey == null || apiKey.isBlank()) {
            response.setStatus(401);
            return;
        }

        if(repo.existsByApiKey(apiKey))
        {
            filterChain.doFilter(request, response);
            return;
        }
        response.setStatus(401);
    }
}
