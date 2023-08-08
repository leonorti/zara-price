# zara-price

OBJETIVOS 
Describir los componentes  del sistema servicio de consulta de precios  en su versión 1.0.0, según la base 
de datos de comercio electrónico de la compañía disponemos de la tabla PRICES que refleja el preci o final 
(pvp) y la tarifa que aplica a un producto de una cadena entre unas fechas determinadas. 

* Objetivos Específicos 
 
✔   Presentar las tecnologías de uso de la solución realizada.  
 
✔   Presentar los resultados de las pruebas de la solución realizada.


* ARQUITECTURA 
La  arquitectura  de  la  solución consiste  en  1  solo  componente: zara-price  en  arquitectura hexagonal y de 
microservicios y a nivel general ela operación del servicio es la siguiente:

+ BASE DE DATOS H2 
La base del sistema es H2 embebida con las siguientes propiedades: 
 
## Propiedades de conexion DB 
spring.datasource.url=jdbc:h2:mem:pricedb 
spring.datasource.driverClassName=org.h2.Driver 
spring.datasource.username=sa 
spring.datasource.password=password 
 
DICCIONARIO DE DATOS: 
El diccionario de datos se encuentra relacionado en 2 tablas: BRAND y PRICE

+ BACKEND 
La capa de negocio del servicio, se compone de los siguientes paquetes: 

La estructura de los paquetes se encuentran conformados por: 

*.<base>: Corresponde a la configuración del microservicio. 
*.<base>.application.singleton: Corresponde a las clases tipo Singleton con funciones utilitarias recurrentes en el 
sistema.
*.<base>.domain.data: Corresponde a las clases entity que interactúan en la capa de integración ORM con la base 
de datos. 
*.<base>.domain.dto: Corresponde a las clases DTO auxiliares para el intercambio de información del servicio. 
*.<base>.infraestructure.controller: Corresponde al  controlador, en  donde  se  encuentra  la  lógica  de  negocio  del 
microservicio. 
*.<base>.infraestructure.exception: Corresponde a las clases personalizadas para el control de errores del microservicio. 
*.<base>.infraestructure.repository: Corresponde a las clases de integración para la gestión de las transacciones en base 
de datos.


* PRUEBAS UNITARIAS 
La capa de negocio del proyecto, se compone de: 6 Test de prueba. De los cuales 5 son orientados a los 
resultados de respuesta y 1 relacionado a la conformidad del servicio. 


-- Documentación del proyecto 
El objetivo  de este ejemplo  es realizar una  consulta simple con la información  contenida  en el archivo JSON, por ejemplo saber el nombre del formulario  de la estación: 
http://localhost:8080/swagger-ui.html 


* ACCESO:
-  Acceso al servicio. 
El servicio REST es de tipo GET con URI base (En entorno local y puerto por defecto): 
http://<ip>:<port>/prices o con contexto http://<ip>:<port>/zara-price/prices
Y con parámetros de consulta:  
applicationDate, que es la fecha de aplicación en formato: yyyy-MM-dd-HH.mm.ss 
productId,  El id del producto.  
brandId,  el Id de la cadena del grupo. 
Por ejemplo: 

http://localhost:8080/prices?applicationDate=2020-06-16-
21.00.00&productId=35455&brandId=1 
