INSERT INTO t_permission (name) VALUES
                                    ('ROLE_ADMIN'),
                                    ('ROLE_USER');

INSERT INTO t_user (username, email, password) VALUES
    ('admin', 'admin@example.com', '$2a$12$92xAn00iXPb5QtlHY3PFQ.TyuolVOFWP/cd/Owr6Ug/X8XVwFj5eW'),
    ('user', 'user@example.com', '$2a$12$BKCgzhZlGV9KN1x7pMw3BOOnG1I6bfhdqp2e9om1sC39wJhQYjDOW');


INSERT INTO t_user_permissions (user_id, permission_id) VALUES
    (1, 1),
    (2, 2);


INSERT INTO t_director (first_name, last_name, birth_year) VALUES
                                                               ('Christopher', 'Nolan', 1970),
                                                               ('Quentin', 'Tarantino', 1963);

INSERT INTO t_genre (name) VALUES
                               ('Sci-Fi'),
                               ('Action'),
                               ('Drama'),
                               ('Comedy');

INSERT INTO t_movie (title, description, release_year, rating, country, director_id) VALUES
                                                                                         ('Interstellar', 'Space exploration movie', 2014, 8.6, 'USA', 1),
                                                                                         ('Pulp Fiction', 'Crime movie', 1994, 8.9, 'USA', 2);

INSERT INTO t_movie_genres (movie_id, genre_id) VALUES
                                                    (1, 1),
                                                    (1, 3),
                                                    (2, 2),
                                                    (2, 3);