package com.yasminarantes.consulta_credito.service;

import com.yasminarantes.consulta_credito.dto.CreditoDTO;
import com.yasminarantes.consulta_credito.model.Credito;
import com.yasminarantes.consulta_credito.repository.CreditoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CreditoServiceTest {

    @Mock
    private CreditoRepository repository;

    @InjectMocks
    private CreditoService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Deve retornar lista de créditos quando NFS-e é válida")
    void deveRetornarListaCreditosQuandoNfseValida() {
        String numeroNfse = "123";
        Credito credito = new Credito(); // Suponha que existe essa entidade
        when(repository.findByNumeroNfse(numeroNfse)).thenReturn(List.of(credito));

        List<CreditoDTO> result = service.obterCreditosPorNfse(numeroNfse);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(repository, times(1)).findByNumeroNfse(numeroNfse);
    }

    @Test
    @DisplayName("Deve lançar IllegalArgumentException quando NFS-e é vazia")
    void deveLancarExcecaoQuandoNfseVazia() {
        assertThrows(IllegalArgumentException.class, () -> service.obterCreditosPorNfse(" "));
    }

    @Test
    @DisplayName("Deve retornar crédito quando número do crédito é válido")
    void deveRetornarCreditoQuandoNumeroValido() {
        String numeroCredito = "456";
        Credito credito = new Credito(); // Suponha que exista um construtor válido
        when(repository.findByNumeroCredito(numeroCredito)).thenReturn(Optional.of(credito));

        CreditoDTO result = service.obterCreditoPorNumero(numeroCredito);

        assertNotNull(result);
        verify(repository).findByNumeroCredito(numeroCredito);
    }

    @Test
    @DisplayName("Deve lançar IllegalArgumentException quando número do crédito é nulo")
    void deveLancarExcecaoQuandoNumeroCreditoNulo() {
        assertThrows(IllegalArgumentException.class, () -> service.obterCreditoPorNumero(null));
    }

    @Test
    @DisplayName("Deve lançar EntityNotFoundException quando crédito não for encontrado")
    void deveLancarExcecaoQuandoCreditoNaoEncontrado() {
        String numeroCredito = "999";
        when(repository.findByNumeroCredito(numeroCredito)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> service.obterCreditoPorNumero(numeroCredito));
    }
}
