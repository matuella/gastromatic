INSERT INTO curso (nome,detalhes) VALUES ('Culinária Tailandesa','Curso básico sobre a culinária tailandesa');


INSERT INTO roteiro (nome,detalhes,curso_id) VALUES ('Roteiro semana 1','Semana sobre molho curry',1);
INSERT INTO roteiro (nome,detalhes,curso_id) VALUES ('Roteiro semana 2','Semana sobre saladas',1);


INSERT INTO aula (nome,detalhes,usuario) VALUES ('Curry apimentado','Aula para fazer um curry com certos níveis de pimenta', 'administrador');
INSERT INTO aula (nome,detalhes,usuario) VALUES ('Curry com temperos','Aula para fazer um curry e combinar com outros temperos', 'administrador');
INSERT INTO aula (nome,detalhes,usuario) VALUES ('Saladas agridoces','Receita para fazer saladas agridoces', 'administrador');


INSERT INTO roteiro_aulas (roteiros_id, aulas_id) VALUES (1,1);
INSERT INTO roteiro_aulas (roteiros_id, aulas_id) VALUES (1,2);
INSERT INTO roteiro_aulas (roteiros_id, aulas_id) VALUES (2,3);


INSERT INTO receita (nome) VALUES ('Curry levemente apimentado');
INSERT INTO receita (nome) VALUES ('Curry muito apimentado');
INSERT INTO receita (nome) VALUES ('Curry moderadamente apimentado');
INSERT INTO receita (nome) VALUES ('Curry e tempero verde');
INSERT INTO receita (nome) VALUES ('Curry e açafrão');
INSERT INTO receita (nome) VALUES ('Salada de alface com abacaxi e figo');
INSERT INTO receita (nome) VALUES ('Salada com molho tailandes');
INSERT INTO receita (nome) VALUES ('Salada com camarão e mel');


INSERT INTO aula_receitas (aulas_id, receitas_id) VALUES (1,1);
INSERT INTO aula_receitas (aulas_id, receitas_id) VALUES (1,2);
INSERT INTO aula_receitas (aulas_id, receitas_id) VALUES (1,3);


INSERT INTO aula_receitas (aulas_id, receitas_id) VALUES (2,4);
INSERT INTO aula_receitas (aulas_id, receitas_id) VALUES (2,5);


INSERT INTO aula_receitas (aulas_id, receitas_id) VALUES (3,6);
INSERT INTO aula_receitas (aulas_id, receitas_id) VALUES (3,7);
INSERT INTO aula_receitas (aulas_id, receitas_id) VALUES (3,8);


INSERT INTO insumo (nome, qtd_minima, qtd_atual, perecivel) VALUES ('Cebola', 20, 100, FALSE); 
INSERT INTO insumo (nome, qtd_minima, qtd_atual, perecivel) VALUES ('Maionese', 20, 100, FALSE); 
INSERT INTO insumo (nome, qtd_minima, qtd_atual, perecivel) VALUES ('Tomate', 20, 100, FALSE); 
INSERT INTO insumo (nome, qtd_minima, qtd_atual, perecivel) VALUES ('Pimenta do Reino', 20, 100, FALSE); 
INSERT INTO insumo (nome, qtd_minima, qtd_atual, perecivel) VALUES ('Abacate', 20, 100, TRUE); 
INSERT INTO insumo (nome, qtd_minima, qtd_atual, perecivel) VALUES ('Tempero Verde', 20, 100, TRUE); 
INSERT INTO insumo (nome, qtd_minima, qtd_atual, perecivel) VALUES ('Camarão', 20, 100, TRUE); 



INSERT INTO receita_insumo (insumo_id, receita_id, qtd_insumo) VALUES (1,1,2);
INSERT INTO receita_insumo (insumo_id, receita_id, qtd_insumo) VALUES (3,1,3);

INSERT INTO receita_insumo (insumo_id, receita_id, qtd_insumo) VALUES (5,2,250);

INSERT INTO receita_insumo (insumo_id, receita_id, qtd_insumo) VALUES (3,3,5);
INSERT INTO receita_insumo (insumo_id, receita_id, qtd_insumo) VALUES (4,3,100);
INSERT INTO receita_insumo (insumo_id, receita_id, qtd_insumo) VALUES (5,3,3);


INSERT INTO receita_insumo (insumo_id, receita_id, qtd_insumo) VALUES (2,4,300);
INSERT INTO receita_insumo (insumo_id, receita_id, qtd_insumo) VALUES (7,4,800);

INSERT INTO receita_insumo (insumo_id, receita_id, qtd_insumo) VALUES (6,5,2);

INSERT INTO receita_insumo (insumo_id, receita_id, qtd_insumo) VALUES (1,6,3);
INSERT INTO receita_insumo (insumo_id, receita_id, qtd_insumo) VALUES (2,6,200);
INSERT INTO receita_insumo (insumo_id, receita_id, qtd_insumo) VALUES (3,6,4);
INSERT INTO receita_insumo (insumo_id, receita_id, qtd_insumo) VALUES (7,6,300);

INSERT INTO receita_insumo (insumo_id, receita_id, qtd_insumo) VALUES (5,7,2);