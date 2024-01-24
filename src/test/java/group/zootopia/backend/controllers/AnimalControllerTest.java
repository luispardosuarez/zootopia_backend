package group.zootopia.backend.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import group.zootopia.backend.models.Animal;
import group.zootopia.backend.service.AnimalService;

@WebMvcTest(controllers = AnimalController.class)
@AutoConfigureMockMvc(addFilters = false) // no security
public class AnimalControllerTest {

  @Autowired
  MockMvc mockMvc; // mock request http

  @MockBean
  AnimalService service; // mock service

  @Autowired
  ObjectMapper mapper;

  @Test
  void testIndex() throws Exception {
    // Given
    List<Animal> animals = new ArrayList<>();
    Animal mouse = new Animal(1L, "mickey", "felidos", "mouse", 'M', "2023/01/01");
    Animal minnie = new Animal(2L, "minnie", "felidos", "mouse", 'H', "2023/01/01");
    animals.add(mouse);
    animals.add(minnie);

    when(service.getAll()).thenReturn(animals);
    MockHttpServletResponse response = mockMvc.perform(get("/api/v1/animals/all")
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andReturn()
      .getResponse();

    assertEquals(200, response.getStatus());
    assertThat(response.getContentAsString()).contains("mickey");
    assertThat(response.getContentAsString()).contains("minnie");

  }
}
