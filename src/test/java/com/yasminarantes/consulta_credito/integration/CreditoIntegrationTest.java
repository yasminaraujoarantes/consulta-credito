package com.yasminarantes.consulta_credito.integration;

import com.yasminarantes.consulta_credito.dto.CreditoDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("tests")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CreditoIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getBaseUrl() {
        return "http://localhost:" + port + "/api/creditos";
    }

    @Test
    @Order(1)
    @DisplayName("GET /{numeroNfse} deve retornar lista de créditos")
    void testBuscarCreditosPorNfse() {
        ResponseEntity<CreditoDTO[]> response = restTemplate.getForEntity(
                getBaseUrl() + "/9876",
                CreditoDTO[].class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().length);
    }

    @Test
    @Order(2)
    @DisplayName("GET /credito/{numeroCredito} deve retornar um crédito")
    void testBuscarCreditoPorNumero() {
        ResponseEntity<CreditoDTO> response = restTemplate.getForEntity(
                getBaseUrl() + "/credito/123456",
                CreditoDTO.class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("123456", response.getBody().getNumeroCredito());
    }

    @Test
    @Order(3)
    @DisplayName("GET /credito/{numeroCredito} deve retornar 404 se não encontrado")
    void testBuscarCreditoNaoEncontrado() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                getBaseUrl() + "/credito/000043",
                String.class
        );

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
