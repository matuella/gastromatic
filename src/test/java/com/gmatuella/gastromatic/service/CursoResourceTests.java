package com.gmatuella.gastromatic.service;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.gmatuella.gastromatic.Main;
import com.gmatuella.gastromatic.entity.Curso;

@RunWith(SpringRunner.class)
@WebMvcTest(Main.class)
@ContextConfiguration(classes = {Main.class})
public class CursoResourceTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CursoService cursoService;

    @Test
    public void getCursoTest() throws Exception {
    	
        given(this.cursoService.findCurso(1L))
            .willReturn(new Curso("Curso teste", "much details such wow"));

        this.mvc.perform(get("/cursos/" + 1L)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json("{'nome':'Curso teste','detalhes':'much details such wow'}"));
    }
}
