CREATE TABLE tb_game (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    alternative_Names JSON,
    category VARCHAR(50),
    genres JSON,
    language_Supports JSON,
    artworks JSON,
    age_Ratings JSON,
    websites JSON,
    PRIMARY KEY(id)
);
