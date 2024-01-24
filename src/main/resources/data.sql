INSERT INTO roles (id_role, name) VALUES (default, 'ADMIN');
INSERT INTO roles (id_role, name) VALUES (default, 'USER');
INSERT INTO users (id_user, username, password) VALUES (default, 'admin', '$2a$12$KLPJeTThcyyc643IEXRq/.lvuENVgFachHQysUL.QaiyX.lqrMb4W');
INSERT INTO roles_users (user_id, role_id) VALUES (1, 1);

INSERT INTO animals("id", "name", "type", "family", "gender", "date") VALUES(default, 'Felix', 'lince', 'félidos', 'M', '2023/01/01');
INSERT INTO animals("id", "name", "type", "family", "gender", "date") VALUES(default, 'Felisa', 'lince', 'félidos', 'H', '2023/01/01');