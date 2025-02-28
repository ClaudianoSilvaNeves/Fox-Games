CREATE TABLE token (
    id BIGINT NOT NULL AUTO_INCREMENT,
    token VARCHAR(50),
    expires_In BIGINT NOT NULL,
    type VARCHAR(50),
    expires_At datetime NOT NULL,
    PRIMARY KEY(id)
);