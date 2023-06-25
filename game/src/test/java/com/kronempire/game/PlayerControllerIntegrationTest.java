package com.kronempire.game;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.kronempire.game.models.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSigninEndpointEmailExists() throws Exception {
        Player player = new Player();
        player.setEmail("lorem2@mail.com");
        player.setPassword_player("azerty");
        player.setPseudo_player("Lorem");
        mockMvc.perform(post("/player/signin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(player)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testSignInEndpoint() throws Exception {
        Player player = new Player();
        player.setEmail("lorem22@mail.com");
        player.setPassword_player("azerty");
        player.setPseudo_player("Lorem");
        mockMvc.perform(post("/player/signin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(player)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testLoginEndpoint() throws Exception {
        Player player = new Player("tata@email.com",
                "123",
                "tata");
        player.setId_player(6);
        player.setDate_player(LocalDate.of(2023,   6, 9));
        player.setLastConnection_player(LocalDateTime.of(2023, 6, 24,1,25,10));
        System.out.println(player);
        mockMvc.perform(post("/player/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(player)))
                .andExpect(status().isOk());
    }


    private static String asJsonString(final Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}