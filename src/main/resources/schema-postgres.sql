DROP TABLE IF EXISTS APP_USER;
CREATE TABLE APP_USER(id serial PRIMARY KEY, username VARCHAR(100), password VARCHAR(100), is_deleted boolean);

DROP TABLE IF EXISTS app_role;
CREATE TABLE app_role(id serial PRIMARY KEY, name VARCHAR(100), is_deleted boolean);

DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role(user_id int REFERENCES app_user (id) ON UPDATE CASCADE ON DELETE CASCADE, role_id int REFERENCES app_role (id) ON UPDATE CASCADE, is_deleted boolean, CONSTRAINT user_role_pkey PRIMARY KEY (user_id, role_id));