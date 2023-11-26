-- simple-todos 테이블 생성
CREATE TABLE simple_todos
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    title     VARCHAR(255),
    content   VARCHAR(255),
    status    VARCHAR(50),
    category  VARCHAR(50),
    createdAt TIMESTAMP,
    updatedAt TIMESTAMP,
    deletedAt TIMESTAMP,
    ownerId   INT
);

CREATE TABLE players
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    names        VARCHAR(15),
    description VARCHAR(20),
    position    VARCHAR(10),
    unique_tag  VARCHAR(50),
    created_at  TIMESTAMP,
    updated_at  TIMESTAMP
);

CREATE TABLE teams
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(50),
    address    VARCHAR(20),
    fans       INT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);
