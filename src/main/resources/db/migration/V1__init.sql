CREATE TABLE t_permission (
                              id   BIGSERIAL PRIMARY KEY,
                              name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE t_user (
                        id       BIGSERIAL PRIMARY KEY,
                        username VARCHAR(100),
                        email    VARCHAR(100) NOT NULL UNIQUE,
                        password VARCHAR(255) NOT NULL
);


CREATE TABLE t_user_permissions (
                                    user_id       BIGINT NOT NULL,
                                    permission_id BIGINT NOT NULL,
                                    PRIMARY KEY (user_id, permission_id),
                                    CONSTRAINT fk_user_permissions_user       FOREIGN KEY (user_id)       REFERENCES t_user(id)       ON DELETE CASCADE,
                                    CONSTRAINT fk_user_permissions_permission FOREIGN KEY (permission_id) REFERENCES t_permission(id) ON DELETE CASCADE
);


CREATE TABLE t_director (
                            id BIGSERIAL PRIMARY KEY,
                            first_name VARCHAR(255) NOT NULL,
                            last_name VARCHAR(255) NOT NULL,
                            birth_year INT NOT NULL
);

CREATE TABLE t_genre (
                         id BIGSERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL
);

CREATE TABLE t_movie (
                         id BIGSERIAL PRIMARY KEY,
                         title VARCHAR(255) NOT NULL,
                         description TEXT NOT NULL,
                         release_year INT NOT NULL,
                         rating DOUBLE PRECISION NOT NULL,
                         country VARCHAR(255) NOT NULL,
                         director_id BIGINT,
                         CONSTRAINT fk_director FOREIGN KEY (director_id) REFERENCES t_director(id) ON DELETE SET NULL
);

CREATE TABLE t_movie_genres (
                                movie_id BIGINT NOT NULL,
                                genre_id BIGINT NOT NULL,
                                PRIMARY KEY (movie_id, genre_id),
                                CONSTRAINT fk_movie FOREIGN KEY (movie_id) REFERENCES t_movie(id) ON DELETE CASCADE,
                                CONSTRAINT fk_genre FOREIGN KEY (genre_id) REFERENCES t_genre(id) ON DELETE CASCADE
);