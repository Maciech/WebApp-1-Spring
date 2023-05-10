package io.github.mat3e.hello.lang;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
class LangServlet {
    private final Logger logger = LoggerFactory.getLogger(LangServlet.class);

    private LangService service;

    LangServlet(LangService service) {
        this.service = service;
    }

    @GetMapping("/langs")
    ResponseEntity<List<LangDTO>> findAllLangs(){
        logger.info("Request got");
        return ResponseEntity.ok(service.findAll());
    }
}
