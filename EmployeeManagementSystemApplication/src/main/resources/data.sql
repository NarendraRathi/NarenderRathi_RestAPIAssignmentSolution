insert into roles (name) values ('ADMIN');
INSERT INTO USERS VALUES (1,'$2a$12$xSEX.8ZuIl10GbzGnqaiM.RgTOacXtv2/mAcHWaLAZVVZV5wqwF5O','admin');
insert into users_roles (user_id, role_id) values (1, 1);
insert into roles (name) values ('USER');
INSERT INTO USERS VALUES (2,'$2a$12$WTyIOUyJ4ZRqzNOHeHNgjOLLt3E6ABUDLDSUQx.Pi11GRx3jMbogG','user');
insert into users_roles (user_id, role_id) values (2, 2);
