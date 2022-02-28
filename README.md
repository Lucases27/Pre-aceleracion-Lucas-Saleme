# Disney-API
CHALLENGE BACKEND - Java Spring Boot (API)

Challenge de ingreso a la aceleración Alkemy.</br>
Se trata de una API para explorar el mundo de Disney, la cual permitirá conocer y modificar los
personajes que lo componen y entender en qué películas estos participaron.


- 💻 Java 11, MySQL
- 🚀 Frameworks: Spring Boot, Hibernate, Maven.
- 👩‍💻 IDE: Intellij Idea

 ### ⚡ Database:

Base de datos utilizada MySQL. Para configurar, editar los siguientes campos el archivo: `resources/application.properties`</br>
spring.datasource.url=jdbc:mysql://url:port/dbname</br>
spring.datasource.username=username</br>
spring.datasource.password=password

Para importar una Base de datos con datos ya cargados incluí un archivo .sql en la carpeta `/documents`. Se debe crear una nueva base de datos vacía y en caso de usar el gestor Dbeaver: Click derecho a la base de datos -->
Herramientas --> Restore database


### ☁ Endpoints: 
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=slim&logo=Postman&logoColor=white
)

Archivo postman incluido en `/documents`.

**Documentación:** [Postman Disney-API Challenge](https://documenter.getpostman.com/view/19054731/UVkqrEs3)


- **Movies:**</br>
Es requerido el `"genreId":`, por lo tanto para dar de alta una película es necesario crear un género previamente. También es posible dar de alta personajes
y relacionarlos a la película al mismo tiempo mediante la propiedad `"associatedCharacters":[{}]`
En caso de no dar de alta personajes de esta forma, se podrán dar de alta mediante el endpoint `/characters`
y luego relacionarlos con la película
mediante el endpoint `movies/{idMovie}/addCharacter/{idCharacter}`


- **Genres**:</br>
Se pueden dar de alta y listar los géneros mediante el endpoint `/genres`.


- **Characters**:</br>
Al remover un entidad character Hibernate no remueve la relación en la tabla intermedia
ya que Character no es dueña de la asociación, por ello es que en el método remove de su Mapper
removemos las asociaciones que existen manualmente.


### 🌐 Envío de mail:
Para utilizar la funcionalidad de envío de emails se deberá utilizar una API KEY propia, ya que por cuestiones de seguridad SendGrid no permite que esta esté publicada en el código dentro de un repositorio en github. 

Para ello deberá declarar una variable de Environment llamada EMAIL_API_KEY y setear la key respectiva, también deberá editar la propiedad alkemy.disney.email.sender dentro de application.properties con su propio correo registrado en Sendgrid.




