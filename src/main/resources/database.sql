-- Table: roles
CREATE TABLE roles (
  id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(10) NOT NULL
)
ENGINE = InnoDB;

-- Table: users
CREATE TABLE users (
  id       INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  email    VARCHAR(45) NOT NULL,
  password VARCHAR(60) NOT NULL,
  role_id  INT         NOT NULL,

  FOREIGN KEY (role_id) REFERENCES roles (id)
)
ENGINE = InnoDB;

-- Insert data

INSERT INTO roles VALUES (1, 'User');
INSERT INTO roles VALUES (2, 'Hr manager');

INSERT INTO users VALUES (1, 'hr@gmail.com', '$2y$10$oQD9l1bMq.wQam/4.Jf16Oy98hFt9kgHZCmn3HWY1DNpArDf2mtKC', 2);
INSERT INTO users VALUES (2, 'user@gmail.com', '$2y$10$qBMOhEwkBtlilDsfzTdZbeoTCwiR7qrh21mxmFK4AbFw83oqb.H0q', 1);