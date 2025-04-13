CREATE TABLE credito (
    id BIGINT PRIMARY KEY,
    numero_credito VARCHAR(255),
    numero_nfse VARCHAR(255),
    data_constituicao DATE,
    valor_issqn DECIMAL(10, 2),
    tipo_credito VARCHAR(255),
    simples_nacional BOOLEAN,
    aliquota DECIMAL(5, 2),
    valor_faturado DECIMAL(10, 2),
    valor_deducao DECIMAL(10, 2),
    base_calculo DECIMAL(10, 2)
);

INSERT INTO credito (
    id,
    numero_credito,
    numero_nfse,
    data_constituicao,
    valor_issqn,
    tipo_credito,
    simples_nacional,
    aliquota,
    valor_faturado,
    valor_deducao,
    base_calculo
) VALUES
(
    1,
    '123456',
    '9876',
    '2023-01-15',
    150.75,
    'Ordinário',
    TRUE,
    5.00,
    3000.00,
    200.00,
    2800.00
),
(
    2,
    '56780',
    '9876',
    '2023-02-10',
    180.00,
    'Ordinário',
    FALSE,
    3.00,
    6000.00,
    500.00,
    5500.00
),
(
    3,
    '8765432',
    '156890',
    '2023-03-01',
    200.00,
    'Complementar',
    TRUE,
    2.00,
    7000.00,
    1000.00,
    6000.00
);
