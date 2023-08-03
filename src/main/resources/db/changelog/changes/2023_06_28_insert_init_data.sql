INSERT INTO permission (role)
VALUES
    ('ROLE_USER'),
    ('ROLE_ADMIN');

INSERT INTO types (name)
VALUES
    ('Team Sports'),
    ('Individual Sports'),
    ('Combat Sports'),
    ('Water Sports');

INSERT INTO users (email, full_name, password)
VALUES
    ('admin@gmail.com', 'Admin Adminov', '$2a$10$2DjIzX/TX0TUc/kxMNvwlOGf8P84M62wgHLXMb2dhM5o3/BxMVium');

INSERT INTO users_permissions (user_id, permissions_id)
VALUES
    (1,2);