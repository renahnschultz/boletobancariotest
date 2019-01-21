CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `id_category` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_id_category_idx` (`id_category` ASC),
  CONSTRAINT `fk_id_category`
    FOREIGN KEY (`id_category`)
    REFERENCES `category` (`id`));

