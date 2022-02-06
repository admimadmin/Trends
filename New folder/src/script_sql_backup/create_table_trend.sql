CREATE TABLE  `cubetrendsimulator`.`trend` (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
`ubicacion` VARCHAR( 30 ) NOT NULL ,
`inicio` INT NOT NULL ,
`finalizacion` INT NOT NULL ,
`intervalo` INT NOT NULL ,
`busqueda` VARCHAR( 30 ) NOT NULL ,
`categoria` VARCHAR( 30 ) NOT NULL ,
`tipoBusqueda` VARCHAR( 30 ) NOT NULL ,
`incXdia` INT NOT NULL ,
`incXSemana` INT NOT NULL ,
`incXIntervalo` INT NOT NULL
) ENGINE = INNODB;
