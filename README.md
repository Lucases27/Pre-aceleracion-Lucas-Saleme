# Disney-API
Alkemy Challenge - Disney API

POSTMAN:</br>
Archivo postman incluido.

***Alta Movies:** Es requerido el `"genreId":`, por lo tanto para dar de alta a
una pelicula es necesario crear un genero previamente. Tambien es posible dar de alta personajes y relacionarlos a la pelicula
al mismo tiempo mediante la propiedad `"associatedCharacters":[{}]`

En caso de no dar de alta personajes de esta forma, se podran dar de alta mediante el endpoint `/characters`
y luego relacionarlos con la pelicula
mediante el endpoint `movies/{idMovie}/addCharacter/{idCharacter}`

***Genres**: Se pueden dar de alta y listar los generos mediante el endpoint `/genres`.








