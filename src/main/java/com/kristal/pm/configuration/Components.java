package com.kristal.pm.configuration;

import com.kristal.pm.exception.APIExceptionMapper;
import org.springframework.context.annotation.Bean;

public class Components {

    @Bean
    public APIExceptionMapper apiExceptionMapper() {return new APIExceptionMapper();}
}
