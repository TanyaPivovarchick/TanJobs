-- Table: aspirant_data
CREATE TABLE IF NOT EXISTS aspirant_data (
  id                INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  surname           VARCHAR(45) NULL,
  name              VARCHAR(45) NULL,
  patronymic        VARCHAR(45) NULL,
  email             VARCHAR(45) NULL,
  sex               VARCHAR(1)  NULL,
  education         MEDIUMTEXT  NULL,
  date_of_birth     DATE        NULL,
  phone_number      VARCHAR(45) NULL,
  english_level     VARCHAR(3)  NULL,
  about_me          LONGTEXT    NULL,
  city_of_residence VARCHAR(45) NULL,
  mailing_address   VARCHAR(45) NULL
)
ENGINE = InnoDB;

-- Table: aspirant
CREATE TABLE IF NOT EXISTS aspirant (
  id               INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  email            VARCHAR(45) NOT NULL,
  password         VARCHAR(60) NOT NULL,
  aspirant_data_id INT         NOT NULL,

  FOREIGN KEY (aspirant_data_id) REFERENCES aspirant_data(id)
)
ENGINE = InnoDB;

-- Table: resume
CREATE TABLE IF NOT EXISTS resume (
  id               INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  date             TIMESTAMP    NOT NULL,
  career_objective VARCHAR(100) NULL,
  business_trip    TINYINT      NULL     DEFAULT 0,
  relocation       TINYINT      NULL     DEFAULT 0,
  skills           VARCHAR(150) NULL,
  salary           DECIMAL(7,2) NULL,
  number_of_view   INT          NULL,
  aspirant_id      INT          NOT NULL,

  FOREIGN KEY (aspirant_id) REFERENCES aspirant(id)
)
ENGINE = InnoDB;

-- Insert data
INSERT INTO aspirant_data VALUES (1, 'Super', 'Guy', 'Superov', 'user@gmail.com', 'm', 'BSUIR', '1985-10-12',
                                  '(29)3456732', 'B2', '', 'Minsk', '');
INSERT INTO aspirant VALUES (1, 'user@gmail.com', '$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG', 1);
INSERT INTO resume VALUES (1, '2018-03-14 12:00:00', 'Car', 1, 1, 'Pascal', 500, 0, 1);
