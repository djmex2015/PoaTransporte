package com.mex.SpringBootProject.configuration;

import com.mex.SpringBootProject.repositories.IItineraryRepository;
import com.mex.SpringBootProject.repositories.ILineRepository;
import com.mex.SpringBootProject.repositories.LineRepository;
import com.mex.SpringBootProject.entities.Itinerary;
import com.mex.SpringBootProject.entities.Line;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableJpaRepositories(basePackageClasses = {LineRepository.class, ILineRepository.class, IItineraryRepository.class})
@ComponentScan(basePackages = {"basepackage"})
public class RestConfig implements RepositoryRestConfigurer {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", config);
        System.out.println("CORS CONFIGURATED");
        return new CorsFilter(source);
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        System.out.println("EXPOSE IDS");
        config.exposeIdsFor(Line.class, Itinerary.class);
    }
}
