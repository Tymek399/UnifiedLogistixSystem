CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(20) NOT NULL
);

CREATE TABLE units (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       type VARCHAR(50) NOT NULL,
                       status VARCHAR(20) NOT NULL,
                       latitude DOUBLE,
                       longitude DOUBLE
);

CREATE TABLE missions (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          description TEXT,
                          start_date DATETIME,
                          end_date DATETIME,
                          status VARCHAR(20),
                          unit_id BIGINT,
                          FOREIGN KEY (unit_id) REFERENCES units(id)
);

CREATE TABLE location_logs (
                               id BIGINT AUTO_INCREMENT PRIMARY KEY,
                               unit_id BIGINT NOT NULL,
                               timestamp DATETIME NOT NULL,
                               latitude DOUBLE NOT NULL,
                               longitude DOUBLE NOT NULL,
                               FOREIGN KEY (unit_id) REFERENCES units(id)
);
