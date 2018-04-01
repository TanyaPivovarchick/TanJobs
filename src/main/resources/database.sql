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
  password VARCHAR(60) NOT NULL
)
  ENGINE = InnoDB;

-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),

  UNIQUE (user_id, role_id)
)
ENGINE = InnoDB;

-- Insert data

INSERT INTO roles VALUES (1, 'User');
INSERT INTO roles VALUES (2, 'Hr manager');

INSERT INTO users VALUES (1, 'hr@gmail.com', '$2y$10$oQD9l1bMq.wQam/4.Jf16Oy98hFt9kgHZCmn3HWY1DNpArDf2mtKC');
INSERT INTO users VALUES (2, 'user@gmail.com', '$2y$10$qBMOhEwkBtlilDsfzTdZbeoTCwiR7qrh21mxmFK4AbFw83oqb.H0q');

INSERT INTO user_roles VALUES (1, 2);
INSERT INTO user_roles VALUES (2, 1);