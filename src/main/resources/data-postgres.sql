INSERT INTO usuario (username, password, auth_token) VALUES ('Arthur', 'senha', '4e9394b4d2876b8741b10a');

INSERT INTO grupo (name) VALUES ('Tecnologia');

INSERT INTO categoria (name, id_grupo) VALUES ('Programação', 1);
INSERT INTO categoria (name, id_grupo) VALUES ('Design Patterns', 1);

INSERT INTO video (
    title, description, owner_id, likes, dislikes, vizualizations, category_id
) VALUES ('video 1', 'first video', 1, 10, 25, 10, 1);






