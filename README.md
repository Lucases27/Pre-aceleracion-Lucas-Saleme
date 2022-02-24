# Disney-API
Alkemy Challenge - Disney API

BASE DE DATOS:</br>
Para configurar su DB editar los siguientes campos el archivo: `resources/application.properties`</br>
spring.datasource.url=jdbc:mysql://localhost:3306/disney</br>
spring.datasource.username=root</br>
spring.datasource.password=1234

POSTMAN:</br>
Archivo postman incluido en `Disney-API/postman`.

***Movies:**</br>
Es requerido el `"genreId":`, por lo tanto para dar de alta a
una pelicula es necesario crear un genero previamente. Tambien es posible dar de alta personajes
y relacionarlos a la pelicula al mismo tiempo mediante la propiedad `"associatedCharacters":[{}]`

En caso de no dar de alta personajes de esta forma, se podran dar de alta mediante el endpoint `/characters`
y luego relacionarlos con la pelicula
mediante el endpoint `movies/{idMovie}/addCharacter/{idCharacter}`

***Genres**:</br>
Se pueden dar de alta y listar los generos mediante el endpoint `/genres`.

***Characters**:</br>
Al remover un entidad character Hibernate no remueve la relacion en la tabla intermedia
ya que Character no es dueña de la asociación, por ello es que en el método remove de su Mapper
removemos las asociaciones que existen manualmente.






