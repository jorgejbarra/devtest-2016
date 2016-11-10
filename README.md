# devtest-2016

## Descripción:
Esta implementación no es mas que una prueba técnica inicial para comprobar el nivel de programación del que suscribe.


## Solución propuesta:

Para la solución del problema he decido implementar un procedimiento al vuelo, es decir, en cada petición se realiza un procesado secuencial del archivo para realizar la operación deseada.

Para poder ejecutar el procesado secuencial de las líneas del archivo de forma paralela me he apoyado en java8 y sus Stream.

Como apoyo para la creación de la api  he optado por el framework Jersey. He optado por arriesgarme y experimentar un poco algo desconocido para mí. Como otras opciones hubiera elegido Spring, framework con el que trabajo a diario y que por lo que he podido ver es más intrusivo pero a la vez más completo que Jersey. Esta última decisión a mi pesar creo que ha sido desacertada pues hubiera desarrollado mucha más funcionalidad de no haberme entretenido jugando con Jersey.

Sin embargo gracias a la perspectiva de cambiar de framework más adelante he desarrollado un núcleo de la aplicación que me permitiría cambiar de uno a otro sin demasiados problemas.

## Detalles de implementación:

#### Get the ACL
 * Description: Returns the whole ACL
 * Endpoint: **http://localhost:8080/intelliment/acl**
 * Operation: GET
 * Example response:
```javascript
      [{
        "id": 1,
        "source": "192.168.0.10",
        "destination": "192.168.0.2",
        "protocol": "tcp/80",
        "action": "allow"
      },{
        "id": 2,
        "source": "88.1.12.225",
        "destination": "99.235.1.15",
        "protocol": "tcp/80,8080",
        "action": "deny"
      }]
```
#### Get a single rule
 * Description: Returns the single rule given the id
 * Endpoint: **http://localhost:8080/intelliment/acl/:id**
 * Operation: GET
 * Example response:
```javascript
    {
    "id": 1,
    "source": "192.168.0.10",
    "destination": "192.168.0.2",
    "protocol": "tcp/80",
    "action": "allow"
    }
```
#### Get the matched rule for an specific packet
 * Description: Return the first rule that their fields match with the packet
fields in order to know what action to apply. For example, for a packet
with fields: [source=”192.168.0.5”, destination=”192.168.0.1” and
protocol=”UDP/80”] the first rule that match it will be the number 3.
 * Endpoint: **http://localhost:8080/intelliment/acl**
 * Operation: GET
 * Example request body:
```javascript
    {
      "source": "192.168.0.5",
      "destination": "192.168.0.1",
      "protocol": "udp/80"
    }
```
○ Example response:
```javascript
    {
      "id": 3,
      "source": "192.168.0.0/24",
      "destination": "192.168.0.0/28",
      "protocol": "udp/any",
      "action": "allow"
    }
```


## Proximas mejoras:

* **Inyección de dependencias:** Utilizar algún marco de inyección de dependencias para librarme de las factorías y la creación de objetos.
* **Auto-documentación con [Swagger](http://swagger.io/):** Si realizara el cambio a spring la documentación sería incluso más fácil con anotaciones.
* **Tratamiento de IP:** He investigado un poco sobre librerías como [IPAddress](https://seancfoley.github.io/IPAddress/) que permitiría añadir la lógica de las ip y sus prefijos.
* **Realizar test de la api:** Actualmente no se han realizado test con jersey.
* **Utilizar una Base de datos:** Una de mis primeras ideas fue crear una base de datos h2 al iniciar la aplicación y abastecerla con el archivo.
