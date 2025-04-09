package com.yasminarantes.consulta_credito.service;

import com.yasminarantes.consulta_credito.dto.CreditoDTO;
import com.yasminarantes.consulta_credito.repository.CreditoRepository;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditoService {
    @Autowired
    private CreditoRepository repository;

    public List<CreditoDTO> obterCreditosPorNfse(String numeroNfse) {
        return repository.findByNumeroNfse(numeroNfse).stream()
                .map(CreditoDTO::new)
                .collect(Collectors.toList());
    }

    public CreditoDTO obterCreditoPorNumero(String numeroCredito) {
        return repository.findByNumeroCredito(numeroCredito)
                .map(CreditoDTO::new)
                .orElseThrow(() -> new InternalException("Credito não encontrado"));
    }
}
