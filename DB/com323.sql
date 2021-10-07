-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema com323db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `com323db` ;

-- -----------------------------------------------------
-- Schema com323db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `com323db` DEFAULT CHARACTER SET utf8 ;
USE `com323db` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `role` VARCHAR(45) NULL,
  `active` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `post`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `post` ;

CREATE TABLE IF NOT EXISTS `post` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `post_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `post_content` VARCHAR(500) NULL,
  `user_id` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_post_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_post_user1_idx` ON `post` (`user_id` ASC);


-- -----------------------------------------------------
-- Table `comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `comment` ;

CREATE TABLE IF NOT EXISTS `comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(500) NULL,
  `comment_date` DATETIME NULL,
  `post_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_comment_post`
    FOREIGN KEY (`post_id`)
    REFERENCES `post` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_comment_post_idx` ON `comment` (`post_id` ASC);

SET SQL_MODE = '';
DROP USER IF EXISTS com323user;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'com323user' IDENTIFIED BY 'com323user';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'com323user';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `com323db`;
INSERT INTO `user` (`id`, `username`, `password`, `role`, `active`) VALUES (1, 'matt', '$2a$10$nnkNgUSaC7ptHhFV.jjAc.cWsUOcpe/nQkh4uSxCiZ/pjBiHJYXiC', 'Admin', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `post`
-- -----------------------------------------------------
START TRANSACTION;
USE `com323db`;
INSERT INTO `post` (`id`, `title`, `post_date`, `post_content`, `user_id`) VALUES (1, 'Test Post', NULL, 'This is some post content to test against to see if it shows up in the DB', DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `comment`
-- -----------------------------------------------------
START TRANSACTION;
USE `com323db`;
INSERT INTO `comment` (`id`, `content`, `comment_date`, `post_id`) VALUES (1, 'This is a test comment to test if this DB was setup correctly.', NULL, 1);

COMMIT;

