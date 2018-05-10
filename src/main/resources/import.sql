-- Password are hashed using a BCrypt hash with a cost of 10
-- password = 'password' BCrypt 10 hashed
insert into user(username, password, authorities, enabled) values('mbecca', '$2a$10$KoxHNdhOe6OY88Ybq6T2d.SGp6lVfj5ynY/QwaO5SRk998TgnYayi', 'USER', true); 
