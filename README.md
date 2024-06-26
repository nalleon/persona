<div align="justify">

# Persona

<div align="center">
<img src="img/persona-logo.png">
</div>

## Índice
- [Proyecto de Persona](/persona-project/)
  - [Detalles del proyecto](#index01)
  - [Modelo de datos utilizado ](#index02)
  - [Funcionalidades implementadas](#index03)
  - [Demostración](#index04)

## Detalles del proyecto <a name="index01"></a>
> **Desarrolladores:** José Maximiliano B. M. ([@mackstm](https://github.com/mackstm)), Nabil L.A. ([@nalleon](https://github.com/nalleon)) 
<br>

Proyecto de temática libre realizado durante el curso 2023/2024 del CFGS de Desarrollo de Aplicaciones Multiplataforma (DAM) para el módulo de Base de Datos (BAE). Para realizarlo, hemos configurado una cuenta en [MongoDB Atlas](https://www.mongodb.com/) para utilizar un clúster que contenga 3 colecciones con las que implementaremos unas operaciones de CRUD sobre las entidades que pertenecen a cada una de las colecciones respectivamente. Además, el proyecto tiene la estructura del modelo MVC y hemos usado spring-data junto con swagger.

El proyecto ha sido desarrollado con la temática de la saga de videojuegos ***Persona*** perteneciente a ATLUS. 

Las tecnologías que hemos utilizado han sido la siguientes:

- [IntelliJ IDEA - Community Edition](https://www.jetbrains.com/es-es/idea/) para el código en Java.
- [Visual Studio Code](https://code.visualstudio.com/) para la realización de documentos en markdown.
- [GitHub](https://github.com/) para la gestión principal del proyecto.

## Modelo de datos utilizado <a name="index02"></a>

El relacion a la tematica, decidimos crear nuestras 3 colecciones como Compedium, PersonaUser y Equipment.

**1.** Compedium

```code
    private int id;
    private String name;
    private String arcana;
    private Set<String> strengths;
    private Set<String> weaknesses;

    // Getters y setters

    // toString y equlas/hash code
```

> **NOTA:** El compedio está compuesto por los Persona, por lo tanto la clase se llama Persona.
<br>

**2.** PersonaUser
```code
    private int id;
    private String name;
    private String lastName;
    private String game;
    private String arcana;
    private boolean wildCard;
    
    // Getters y setters

    // toString y equlas/hash code
```

**3.** Equipment
```code
    private int id;
    private String weaponName;
    private String weaponType;
    private int shopPrice;
    
    // Getters y setters

    // toString y equlas/hash code
```

## Funcionalidades implementadas <a name="index03"></a>
La aplicación incluye las funcionalidades de un CRUD respectivamente para cada una de las entidades:

- **Crear:**
  - Persona: Agregar un nuevo persona al compedio. 
  - PersonaUser: Agregar un personaje.
  - Equipment: Agregar un equipamiento.


- **Leer:**
  - Persona: Leer uno o todos los persona al compedio. 
  - PersonaUser: Leer uno o todos los personajes.
  - Equipment: Leer uno o todos los equipamientos.


- **Actualizar:**
  - Persona: Actualizar un persona del compedio. 
  - PersonaUser: Actualizar un personaje.
  - Equipment: Actualizar un equipamiento.

- **Eliminar:**
  - Persona: Eliminar un persona del compedio. 
  - PersonaUser: Eliminar un personaje.
  - Equipment: Eliminar un equipamiento.

<br>



## Demostración <a name="index04"></a>
- [GET](#get)
- [POST](#post)
- [PUT](#put)
- [DELETE](#delete)

``````
http://localhost:8080/api-persona/swagger-ui/index.html#/
``````

<br>


# GET <a name="get"></a>

## Persona

```
Código: 200

Respuesta: connection: keep-alive  content-type: application/json  date: Fri,07 Jun 2024 10:45:39 GMT  keep-alive: timeout=60  transfer-encoding: chunked 
```


<div align="center">
<img src="img/get-persona.png">
</div>

## PersonaUser

```
Código: 200

Respuesta: connection: keep-alive  content-type: application/json  date: Fri,07 Jun 2024 10:48:40 GMT  keep-alive: timeout=60  transfer-encoding: chunked 
```

<div align="center">
<img src="img/get-personaUser.png">
</div>

## Equipment
```
Código: 200

Respuesta: connection: keep-alive  content-type: application/json  date: Fri,07 Jun 2024 10:48:40 GMT  keep-alive: timeout=60  transfer-encoding: chunked 
```
<div align="center">
<img src="img/get-equipment.png">
</div>

<br>

# POST <a name="post"></a>
## Persona
```
Request body:
{
  "id": 6,
  "name": "Yoshitsune",
  "arcana": "Tower",
  "strengths": [
    "Fire", "Physical", "Electric", "Light"
  ],
  "weaknesses": [
    "None"
  ]
}

Código: 200

Respuesta: connection: keep-alive  content-length: 0  date: Fri,07 Jun 2024 10:58:14 GMT  keep-alive: timeout=60 
```
<div align="center">
<img src="img/post-persona.png">
</div>

## PersonaUser
```
Request body:
{
  "_id": 6,
  "name": "Naoto",
  "lastName": "Shirogane",
  "game": "Persona 4",
  "arcana": "Fortune",
  "wildCard": false
}

Código: 200

Respuesta: connection: keep-alive  content-length: 0  date: Fri,07 Jun 2024 10:53:30 GMT  keep-alive: timeout=60 
```
<div align="center">
<img src="img/post-personaUser.png">
</div>

## Equipment
```
Request body:
{
  "id": 4,
  "weaponName": "Nambu Model 60",
  "weaponType": "Pistol",
  "shopPrice": 1000
}

Código: 200

Respuesta: connection: keep-alive  content-length: 0  date: Fri,07 Jun 2024 11:01:34 GMT  keep-alive: timeout=60 
```
<div align="center">
<img src="img/post-equipment.png">
</div>

<br>

# PUT <a name="put"></a>

## Persona

```
Request body:
{
    "id": 6,
    "name": "Izanagi-No-Okami",
    "arcana": "THE WORLD",
    "strengths": [
      "Physical",
      "Light",
      "Fire",
      "Electric"
    ],
    "weaknesses": [
      "None"
    ]
  }

Código: 200

Respuesta:  connection: keep-alive  content-length: 0  date: Fri,07 Jun 2024 11:05:27 GMT  keep-alive: timeout=60 
```
<div align="center">
<img src="img/put-persona.png">
</div>

## PersonaUser
```
Request body:
{
    "id": 1,
    "name": "Yosuke",
    "lastName": "Hanamura",
    "game": "Persona 4: GOLDEN",
    "arcana": "Magician",
    "wildCard": false
}

Código: 200

Respuesta:  connection: keep-alive  content-length: 0  date: Fri,07 Jun 2024 11:09:21 GMT  keep-alive: timeout=60 
```
<div align="center">
<img src="img/put-personaUser.png">
</div>

## Equipment
```
Request body:
{
    "id": 4,
    "weaponName": "Nambu Model 90",
    "weaponType": "Pistol",
    "shopPrice": 1000
}

Código: 200

Respuesta: connection: keep-alive  content-length: 0  date: Fri,07 Jun 2024 11:11:04 GMT  keep-alive: timeout=60 
```
<div align="center">
<img src="img/put-equipment.png">
</div>

<br>

# DELETE <a name="delete"></a>
## Persona
```
Id: 6

Código: 200

Respuesta: connection: keep-alive  date: Fri,07 Jun 2024 11:15:18 GMT  keep-alive: timeout=60 
```
<div align="center">
<img src="img/delete-persona.png">
</div>

## PersonaUser
```
Id: 1

Código: 200

Respuesta: connection: keep-alive  date: Fri,07 Jun 2024 11:16:20 GMT  keep-alive: timeout=60 

```
<div align="center">
<img src="img/delete-personaUser.png">
</div>

## Equipment
```
Id: 4

Código: 200

Respuesta: connection: keep-alive  date: Fri,07 Jun 2024 11:13:32 GMT  keep-alive: timeout=60 
```
<div align="center">
<img src="img/delete-equipment.png">
</div>


</div>
