


 INSERT INTO USER (user_id, password, email, username, login, lastname, active)
 VALUES (1, '12345', 'jenia@gmail.com', 'Jenia', 'Jeka', 'Skoriy', 1);

 INSERT INTO USER (user_id, password, email, username, login, lastname, active)
 VALUES (2, '54321', 'jenis@gmail.com', 'Evghenii', 'Evhe', 'Aleks', 2);

 insert into ROLE(role,role_id)
 VALUES ('PUBLISHER',1);

 insert into USER_ROLE(user_id,role_id)
 values (1,1);
 insert into USER_ROLE(user_id,role_id)
 values (2,1);

 insert into POST(id_post,title,body,user_id)
 values (1,'Post','My first post, AWESOME!',1);

 insert into POST(id_post,title,body,user_id)
 values (2,'Post','My second post, DOUBLE AWESOME!',1);

 insert into POST(id_post,title,body,user_id)
 values (3,'My favorite post','Girl"s post!',2);
