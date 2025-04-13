package com.yasminarantes.consulta_credito.service;

import com.yasminarantes.consulta_credito.dto.CreditoDTO;
import com.yasminarantes.consulta_credito.repository.CreditoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditoService {
    @Autowired
    private CreditoRepository repository;

    /**
     * Obtém uma lista de créditos associados a uma NFS-e específica.
     *
     * Este método consulta o repositório para buscar todos os créditos relacionados ao número da NFS-e
     * fornecido e retorna uma lista de objetos {@link CreditoDTO}.
     *
     * A entrada do número da NFS-e não pode ser nula ou vazia.
     *
     * @param numeroNfse o número da NFS-e a ser pesquisado. Não pode ser nulo ou vazio.
     * @return uma lista de objetos {@link CreditoDTO} contendo os créditos encontrados associados à NFS-e fornecida.
     * @throws IllegalArgumentException se o número da NFS-e for nulo ou vazio.
     */
    public List<CreditoDTO> obterCreditosPorNfse(String numeroNfse) {
        if (numeroNfse == null || numeroNfse.trim().isEmpty()) {
            throw new IllegalArgumentException("Número da NFS-e não pode ser nulo ou vazio.");
        }

        return repository.findByNumeroNfse(numeroNfse).stream()
                .map(CreditoDTO::new)
                .collect(Collectors.toList());
    }

    /**
     * Obtém um crédito específico baseado no número do crédito.
     *
     * Este método consulta o repositório para buscar um crédito relacionado ao número de crédito fornecido.
     * Se o crédito não for encontrado, uma exceção {@link EntityNotFoundException} é lançada.
     *
     * A entrada do número do crédito não pode ser nula ou vazia.
     *
     * @param numeroCredito o número do crédito a ser pesquisado. Não pode ser nulo ou vazio.
     * @return um objeto {@link CreditoDTO} com os dados do crédito encontrado.
     * @throws IllegalArgumentException se o número do crédito for nulo ou vazio.
     * @throws EntityNotFoundException se o crédito não for encontrado no repositório.
     */
    public CreditoDTO obterCreditoPorNumero(String numeroCredito) {
        if (numeroCredito == null || numeroCredito.trim().isEmpty()) {
            throw new IllegalArgumentException("Número do crédito não pode ser nulo ou vazio.");
        }

        return repository.findByNumeroCredito(numeroCredito)
                .map(CreditoDTO::new)
                .orElseThrow(() -> new EntityNotFoundException("Crédito não encontrado"));
    }
}
