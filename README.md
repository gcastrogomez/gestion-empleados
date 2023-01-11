# gestion-empleados
Gestión de empleados

Gestión de empleados es mi proyecto del curso Programación full stack de la Escuela de Organizaciones Industriales, impartido a finales
de 2022. Este backend tiene un front en Angular.

## Running gestion-empleados locally
Es una aplicación backend construida con maven y spring en la que se expone un API para crear, actualizar, eliminar y listar empleados. Puedes levantar la aplicacion con los siguientes comandos:


```
git clone https://github.com/gcastrogomez/gestion-empleados.git
cd gestion-empleados
mvn spring-boot:run
```

La aplicación es puro backend, por lo que tendremos que consumir los servicios mediante postman o algún cliente similar. Puedes también consultarlos y comprobarlos  mediante su swagger, solo tendrás que ir a: 'http://localhost:8080/swagger-ui/index.html#/'

Listar empleados:

    curl --location --request GET 'http://localhost:8080/gestion_empleados/' 

Obtener un empleado por id:

    curl --location --request GET 'http://localhost:8080/gestion_empleados/1' 

Añadir un empleado:

    curl --location --request POST 'http://localhost:8080/gestion_empleados/' \
	--header 'Content-Type: application/json' \
	--data-raw '{
    "nombre":"Belencita",
    "apellidos":"Marcel",
    "email":"belenEOI@gmail.com",
    "telefono":"666666666",
    "fechaNacimiento":"1988-04-05",
    "fechaContratacion":"2020-05-13",
    "salario":60000.00,
    "numeroSS":665421576769,
    "direccion":"Calle Alcalá 17, Madrid",
    "evaluacion":9,
    "departamento": "Direccion",
    "imagen": "https://upload.wikimedia.org/wikipedia/commons/d/d2/Paula_Echevarr%C3%ADa_en_los_Premios_Goya_2017_%28cropped%29.jpg"
	}'

Modificar un empleado:

    curl --location --request PUT 'http://localhost:8080/gestion_empleados/1' \
	--header 'Content-Type: application/json' \
	--data-raw '{
    "id": 1,
    "nombre": "Martina",
    "apellidos": "González Grimaldo",
    "email": "martinadoloresEOI@gmail.com",
    "telefono": 656832561,
    "fechaNacimiento": "1989-07-12",
    "fechaContratacion": "2021-01-15",
    "salario": 85000.0,
    "numeroSS": 548315498544,
    "direccion": "Calle Pepe suero numero 40, Sevilla"
    "evaluacion":9,
    "departamento": "Direccion",
    "imagen": "https://upload.wikimedia.org/wikipedia/commons/d/d2/Paula_Echevarr%C3%ADa_en_los_Premios_Goya_2017_%28cropped%29.jpg"
	}'

Eliminar un empleado:

    curl --location --request DELETE 'http://localhost:8080/gestion_empleados/1'
