CREATE TABLE permission(
                             id bigint auto_increment,
                             role varchar(255),
                             primary key (id)
);

CREATE TABLE users (
                         id bigint auto_increment,
                         email varchar(255),
                         full_name varchar(255),
                         password varchar(255),
                         primary key (id)
);

CREATE TABLE users_permissions(
                                    user_id bigint,
                                    permissions_id bigint
);

CREATE TABLE offers(
                          id bigint auto_increment,
                          name varchar(255),
                          description text,
                          price int,
                          type_id bigint,
                          primary key (id)
);

CREATE TABLE comments(
                       id bigint auto_increment,
                       text varchar(255),
                       offer_id bigint,
                       user_id bigint,
                       primary key (id)
);

CREATE TABLE types(
                         id bigint auto_increment,
                         name varchar(255),
                         primary key (id)
);

CREATE TABLE offers_user(
                                  offers_id bigint,
                                  user_id bigint
);

ALTER TABLE offers_user
    ADD CONSTRAINT fk_offers_user_offers_id
        FOREIGN KEY (offers_id) REFERENCES offers(id)
            ON DELETE CASCADE;

ALTER TABLE offers_user
    ADD CONSTRAINT fk_offers_user_user_id
        FOREIGN KEY (user_id) REFERENCES users(id)
            ON DELETE CASCADE;



ALTER TABLE users_permissions
    ADD CONSTRAINT fk_users_permissions_user_id
        FOREIGN KEY (user_id) REFERENCES users(id)
            ON DELETE CASCADE;

ALTER TABLE users_permissions
    ADD CONSTRAINT fk_users_permissions_permissions_id
        FOREIGN KEY (permissions_id) REFERENCES permission(id)
            ON DELETE CASCADE;