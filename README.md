# TP Sistema de Viajes

El objetivo de este proyecto integrador final es el de validar los conocimientos prácticos y
técnicos referidos al desarrollo de APIs en el lenguaje de programación Java mediante Spring
Boot para el curso “Desarrollo de APIs en Java con Spring Boot” de la TodoCode Academy.

###  Requisitos
JDK 17 o superior

Maven 3.6.3 o superior

MySQL 8.0 o superior

phpMyAdmin (opcional, para gestión de la base de datos)

###  Estructura del Proyecto


src/main/java: Código fuente de la aplicación.

src/main/resources: Recursos de configuración y archivos estáticos.

src/main/resources/db: Contiene archivos SQL para configurar y cargar la base de datos.


###  Configuración de la Base de Datos
#### Importar los datos:

En la carpeta src/main/resources/db, encontrará el siguiente archivo:

-sistem_viajes.sql: Contiene la estructura y los registros de la base de datos.

Para importar el esquema y los datos en MySQL, puedes utilizar phpMyAdmin o un cliente MySQL.

#### Usando phpMyAdmin:

Accede a phpMyAdmin.
Crea una nueva base de datos.
Importa el archivo sistema_viajes.sql para crear la estructura.

### Configuración de la conexión:

Edita el archivo application.properties en src/main/resources/application.properties para configurar los detalles de la conexión a tu base de datos MySQL:

spring.datasource.url=jdbc:mysql://localhost:3306/sistema_viajes?useSSL=false&serverTimezone=UTC
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseñá

#### Ejecución del Proyecto

#### Compilar el Proyecto:

Navega a la raíz del proyecto y ejecuta el siguiente comando:

mvn clean install

#### Ejecutar la Aplicación:

Después de compilar el proyecto, puedes ejecutar el archivo JAR resultante:


java -jar target/sistema_de_viajes-0.0.1-SNAPSHOT.jar

Si tienes problemas con la interfaz gráfica en entornos no gráficos ejecuta el siguiente codigo:

java -Djava.awt.headless=false -jar target/sistema_de_viajes-0.0.1-SNAPSHOT.jar

### Uso de la Aplicación
La aplicación proporciona una interfaz gráfica para la gestión de viajes de sus colaboradores para una compañia. 

Puedes realizar las siguientes acciones:

Administrar sucursales: Añadir relación con una sucursal y un colaborador, asignar kms de distancia del colaborador con la sucursal, ver listas de sucursales y colaboradores.\
Registrar Viajes: Registrar un viaje desde una sucursal seleccionada, asigna fecha y los colaboradores para cada viaje.\
Reportes: Filtra por rango de fechas y por transportista opara obtener un listado de los viajes realizados por el transportitas y un total a pagar.



### Competencias Técnicas 

Se aplican patrones de diseño y arquitectura de software como inyección de dependencias, patrón MVC, DAOs, Singleton, arquitectura multicapa e integración continua con GitHub Actions. Este flujo de trabajo asegura que cada push se construya, pruebe y empaquete automáticamente, garantizando que cualquier cambio en el código sea verificado después de realizar cada commit.


