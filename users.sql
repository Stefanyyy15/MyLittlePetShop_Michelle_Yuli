CREATE USER "Empleado@localhost" IDENTIFIED BY "MyLittlePetShop22#";

GRANT ALL PRIVILEGES ON *.* TO "Empleado@localhost" WITH GRANT OPTION;

CREATE USER "Owner@localhost" IDENTIFIED BY "ILovePets10#";

GRANT SELECT, INSERT ON mylittlepetshop.owner TO "Owner@localhost" WITH GRANT OPTION;