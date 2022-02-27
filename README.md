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

Para importar una Base de datos con datos ya cargados inclui un archivo .sql en la carpeta `/documents`. Se debe crear una nueva base de datos vacia y en caso de usar el gestor Dbeaver: Click derecho a la base de datos -->
Herramientas --> Restore database


### ⚡ Endpoints: 
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=slim&logo=Postman&logoColor=white
)

Archivo postman incluido en `/documents`.

**Documentacion:** [Postman Disney-API Challenge](https://documenter.getpostman.com/view/19054731/UVkqrEs3)


- **Movies:**</br>
Es requerido el `"genreId":`, por lo tanto para dar de alta a
una pelicula es necesario crear un genero previamente. Tambien es posible dar de alta personajes
y relacionarlos a la pelicula al mismo tiempo mediante la propiedad `"associatedCharacters":[{}]`
En caso de no dar de alta personajes de esta forma, se podran dar de alta mediante el endpoint `/characters`
y luego relacionarlos con la pelicula
mediante el endpoint `movies/{idMovie}/addCharacter/{idCharacter}`


- **Genres**:</br>
Se pueden dar de alta y listar los generos mediante el endpoint `/genres`.


- **Characters**:</br>
Al remover un entidad character Hibernate no remueve la relacion en la tabla intermedia
ya que Character no es dueña de la asociación, por ello es que en el método remove de su Mapper
removemos las asociaciones que existen manualmente.






