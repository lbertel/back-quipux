# back-quipux

El proyecto se utiliza separacion de capas con arquitectura hexagonal, 
esto con el fin de proporcionar flexibilidad de utilizar el api ya sea con 
otro medio de comunicacion como lo puede ser colas de mensajes o archivos, etc.

También se utiliza elementos de DDD como los value object, esto con el proposito
de no comprometerse con las anotaciones de tipo @NotNull, etc. En lo posible
trate de darle un enfoque al desarrollo no orientado a MVC, pero el uso de JPA (se 
puede configurar para que sea m'as un modelo DDD) lo condiciona a tener entidades que
por concepto deberia estar en el dominio, alojarlas en la parte de infraestructura.

- Se adiciono la parte de seguridad, pero la retire por que no andaba bien,
tenia rutas que validaba el token y otras rutas que no debia se pedia la autenticacion.
- Se realizaron pruebas unitarias, se alcanzo llegar al 58% de cobertura.
- Se adiciona un test de integracion para un endpoint
- En calidad de software con pruebas est'atica el codigo tiene algunos warning que no son criticos pero es deuda tecnica.
- No se pudieron validar los corner-case de los casos de uso de los endpoint, puede que algunas pruebas les de errores de tipo 400 y 500 que no se contemplaron.

Para ser sincero no alcance a validar la ruta para compartir de la coleccion de postman
por lo que he colocado la coleccion en la carpeta del proyecto  collection_apis_postman, les comparto la ruta para acceder a la coleccion en postma.
https://.postman.co/workspace/My-Workspace~ce4e24d7-82e6-4530-8bae-d529150f2eba/collection/287428-2442afc0-fb23-4fc5-b3c1-41c0333eb85c?action=share&creator=287428

# Que falta

- No funciono bien la validacion de los request con jwt (se suprimio del codigo final)
- La llamada al api de Spotify (tiempo)
- Los warning de la prueba estatica
- Llegar por lo menos al 80% de cobertura en pruebas unitarias
- Completar las pruebas de integracion para los casos de uso de los endpoint

Muchas gracias.