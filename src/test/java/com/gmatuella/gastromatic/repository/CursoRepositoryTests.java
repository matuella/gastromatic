package com.gmatuella.gastromatic.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gmatuella.gastromatic.entity.Curso;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CursoRepositoryTests {

    @Autowired
    private CursoRepository repository;

    @Test
    public void findByUsernameShouldReturnUser() {
    	this.repository.save(new Curso("curso teste", "much details, such wow"));
        Curso curso = this.repository.findByNome("curso teste");
        
        assertThat(curso.getNome()).isEqualTo("curso teste");
        assertThat(curso.getDetalhes()).isEqualTo("much details, such wow");
    }

}
