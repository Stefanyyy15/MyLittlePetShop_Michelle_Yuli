CREATE USER 'Employee'@'localhost' IDENTIFIED BY "MyLittlePetShop22#";

GRANT ALL PRIVILEGES ON *.* TO 'Employee'@'localhost' WITH GRANT OPTION;

CREATE USER 'Owner'@'localhost' IDENTIFIED BY "ILovePets10#";

GRANT SELECT, INSERT ON mylittlepetshop.owner TO 'Owner'@'localhost' WITH GRANT OPTION;

SELECT User, Host FROM mysql.user;
 DROP USER 'Empleado'@'localhost';



