-- V2: a primeira evolucao de verdade do banco em producao.
-- Queremos registrar QUANDO cada tarefa foi criada.
-- Em vez de deixar o Hibernate adivinhar, a mudanca fica escrita,
-- numerada e revisavel. O Flyway roda este arquivo UMA vez e anota
-- na tabela flyway_schema_history que a versao 2 ja foi aplicada.

ALTER TABLE tarefa ADD COLUMN data_criacao TIMESTAMP;
