
# Api Rest with Spring Boot/React

Hola Bienvenid@s a la solucion de la prueba tecnica.

Para la solucion de la prueba tecnica se uso Java como lenguaje de programacion y se hizo uso de el framework spring boot, el cual consta de varias librerias que nos ayuda a realizar acciones de peticiones HTTP como las requeridas en esta prueba las cuales eran GET y POST, las dependencias se configuraron en Maven, Maven es una herramienta que permite controlar la construcción de las dependencias en este caso en Java. 

Se utilizo MySQL para administrar y generar la base de datos local, se crearon 3 tablas las cuales son Student, Exam y Question, se uso la relacion de la siguiente forma, un estudiante puede tener muchos examenes y un examen puede tener varias preguntas.

Se establecio entonces que cuando se crea un estudiante es crearia y generaria un sudent_id; cuando se genera el examen se esta estableciendo la pregunta y se envia a su vez cual de las cuatro posibles respuestas es la correcta mediante un valor int el cual es correct_answer, este examen genera un exam_id, para finalmente añadir las preguntas a ese exam_id especifico.





## Tech Stack

**Client:** React, Css Vanilla

**Server:** Java, Spring Boot, MySQL


## Referencias

 - [Arquitectura Spring-boot](https://es.stackoverflow.com/questions/581057/cu%C3%A1l-es-la-diferencia-entre-los-paquetes-controller-services-repository-y-mod)
 - [Arquitectura MVC](https://www.freecodecamp.org/espanol/news/el-modelo-de-arquitectura-view-controller-pattern/)
 - [Aprende MySQL (freecodecamp)](https://www.freecodecamp.org/news/learn-mysql-beginners-course/)


## Testing

Se pueden realizar pruebas unitarias en cada parte del código utilizando Spring Boot junto con Maven y Mockito. Mockito es una biblioteca de pruebas para simular comportamientos y realizar pruebas unitarias en clases y métodos, lo que permite probar el comportamiento de componentes individualmente sin depender de otros componentes o del entorno de ejecución real.

Esto permite validar el comportamiento esperado de cada componente de la aplicación y asegurarse de que resista cualquier fallo, lo que es importante en una etapa de producción.


## API Referencia

Para las peticiones de la Api Rest se utilizo el patron de diseño MVC, el cual se divide entre varios grupos, esta los Controller, que se encargan de generar el control de accion de las peticiones HTTP, dependiendo de la peticion segun la logica puede escoger que modelo utilizar, despues se usaron las clases Model, estas representan los datos en la base de datos, de una manera mas tecnica es una abstraccion de nuestras propiedades en la base de datos, tambien se utlizan dos estructuras mas una es Repository estos repositorios sirven para crear la interacción directa con la base de datos y el acceso a los datos y tenemos tambien Services estos se ocupan de la lógica de los metodos de la aplicación y sirven para establecer comunicacion entre diferentes componentes,la parte de View la realice con React js.

El proyecto hace uso de MySQL para la creacion y adminstracion de base de datos, se hace uso de XAMP herramienta que nos permite montar un servidor en ApacheHTTP y gracias a PHP podemos usar un servidor local y acceder a el mediante la direccion ://localhost. 

## Funcionamiento de la API

Haciendo uso de librerias como Spring Data JPA tenemos acceso a la base de datos en aplicaciones Spring porque nos proporciona una interfaz fácil de usar para realizar operaciones CRUD y consultas concretas como que traiga solamente un estudiante o un examen especifico. Al crear una interfaz Repository se puede evitar escribir consultas SQL manualmente ya que JpaRepository genera automaticamente las consultas a apartir de los metodos creados en service. Esto ahorra lineas de codigo con respecto a otros lenguajes. Por lo que al realizar la peticion con una Clase controller lo que sucede es que Repository a travez de los metodos establecidos en Services nos permite generar la conexion con la base de datos atravez de los atributos especificados en las clases Model.

Ya teniendo un EndPoint establecido y probado con PostMan se procede a crear la parte de VIEW de patron de arquitectura MVC, este se hizo con React js, este nos permite poderosas librerias las cuales se pueden descargar con npm, se uso la libreria Axios, la cual nos permite hacer peticiones a EndPoint especificados y tambien permite establecer que datos en formato JSON se van a mandar. Con el EndPoint funcionando solo se procedio a mapear la data en 3 etapas, creacion de Estudiante, creacion de Examen y finalmente visualizacion de la lista de estudiantes y su relacion con el id de las preguntas y respuestas por estudiante.


## Peticiones HTTP

### Obtener estudiantes

```http
  GET /student
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `int` | student_id |


### Crear estudiante

```http
  POST /student
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `name` | `string` | name_student |

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `city` | `string` | city |


| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `age` | `int` | age |


| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `time_zone` | `int` | timeZone |




### Crear Pregunta

```http
  POST /exam
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `question`      | `string` | insertQuestion|


| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `correct_answer`      | `int` | rightAnswer|


### Crear Respuestas

```http
  POST /questions/add/{examId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `first_answer`      | `string` | firstAnswer|

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `second_answer`      | `string` | secondAnswer|

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `third_asnwer`      | `string` | thirdAnswer|

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `fourth_answer`      | `string` | fiourthAnswer|



### Obtener Respuestas

```http
  GET /questions
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | question_id |



## Correr Localmente

Para correr localmente hay que tener el proyecto, en nuestro equipo para eso

Clone el proyecto o descarga en zip

```bash
  git clone https://github.com/TkDevk/Rest_Spring_Boot
```

### Entornos de desarollo o motores de administracion de base de datos

- MySQL Community Server o XAMP 

- IntelliJ o IDE para correr Java

- IDE para correr front, en mi caso use VS code



### Prender Base de Datos: MySQL/Apache 

Para prender nuestra base de datos en XAMP vamos a iniciar primero el servidor ApacheHTTP y luego MySQL, esto inicia la base de datos, se necesita para avanzar a la parte de back end.


### Correr Back-End: Java/Spring-boot 

Para correr nuestro back, vamos a abrir el proyecto con nuestro IDE favorito que soporte java y una vez adentro del proyecto buscamos el archivo llamado CrudApplication, este se encuentra en :

```bash
  crud/crud/src/main/java/CrudApplication
```
Le damos click derecho y presionamos en correr o ejecutar.




### Correr Front-End localmente


Ve al repositorio del proyecto

```bash
  cd crud/crud/Client/Front
```

Instala dependencias

```bash
  npm install
```

Inicia el server

```bash
  npm run start
```


# Pruebas desde Front y Postman

Se puede probar mediante Front o PostMan, si lo quieres probar con PostMan pasa a la siguiente seccion donde podras ver los archivos JSON raw para probar cada EndPoint.

## Front

Tan pronto todo este conectado, vas a ver que te lleva a una pagina principal donde podemos crear un Estudiante, en la parte de Lista de Estudiantes no veremos nada ya que aun no creamos ningun estudiante, damos click en añadir estudiante.
![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)

Luego nos lleva a un formulario, tan pronto creemos un estudiante podremos ver un boton que dice crear examen.

![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)

![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)

Luego vamos a crear examen y nos direcciona a un formulario para crear las cuatro preguntas y con sus respectivas cuatro respuestas posibles con una solucion correcta.
![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)
Cuando terminemos de crear los examenes nos podemos dirigir lista estudiantes donde veremos nuestro estudiante creado con sus examenes asociados por id.
![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)

## Pruebas PostMan

### Crear Estudiante
```http
  http://localhost:4000/student
```
```javascript
    {
        "name": "",
        "city": "",
        "age": ,
        "timeZone": ""
    }

```

### Crear Pregunta
```http
  http://localhost:4000/exam
```
```javascript
    {
	    "question": "",
        "correct_answer": 
    }

```
### Crear Respuestas en pregunta

Se le agregan questions y a un examen especifico mediante el exam_id

```http
  http://localhost:4000/questions/add/{exam_id}
```
```javascript
    {
        "first_answer": "",
        "second_answer": "",
        "third_answer": "",
        "fourth_answer": ""
    }

```


## Que aprendí

El framework Spring Boot nos proporciona múltiples herramientas que permiten realizar diversas acciones, como peticiones CRUD y pruebas de cada una de ellas utilizando Mockito. La seguridad es crucial al usar APIs, ya que al montar un proyecto en Internet, cualquiera puede acceder. Esto es especialmente peligroso e inseguro en lo que respecta a nuestra base de datos y los servicios del proveedor en la nube, ya que si las credenciales de la cuenta en la nube son descubiertas, podríamos sufrir un ataque.


## Autor

- [@TkDevk](https://github.com/TkDevk)

