# PruebaTecnicaAPI Ejecución con Docker (Linux)

Este documento explica cómo ejecutar la API con Docker y Docker Compose, usando variables de entorno desde un archivo `.env`. 

Repositorio remoto: [pruebaTecnicaJAVA](https://github.com/mikael16UM/PruebaTecnincaJava)

### Paso 1: Descargar el archivo y descomprimir el .zip
Después de haber sido descargado el archivo.zip, seleccione la carpeta comprimida, haga click derecho sobre esta y seleccione descomprimir.

### Paso 2: Entrar al directorio del proyecto

Situese en la carpeta descomprimida (debe compartir el mismo nombre). Haga click derecho y seleccione abrir en terminal:

```bash
cd nombre_del_proyecto
ls
```

Al ingresar el comando se debe mostrar un conjunto de archivos y carpetas.
Entre ellos nos concentramos en: `Dockerfile`, `docker-compose.yml` y `.env`. etc.

### Paso 3: Levantar contenedores con Docker Compose

Una vez localizados los archivos podemos levantar el contenedor que alberga nuestro proyecto. Para ello dentro del terminal vamos a ejecutar el siguiente comando:
```bash
docker compose up -d
```

### Paso 4: Primeros pasos y Documentación (Swagger) 

Una vez el contenedor esté levantado ya podremos empezar a consumir nuestras primeras apis. Antes se recomienda revisar la documentación (puede acceder a ella dando click al siguiente enlace).
- http://localhost:8080/swagger-ui/index.html


### Paso 5: Testeo de Apis con Postman

Dentro del proyecto también se encontrará una colección de endpoints listos para probarse. Para ello es necesario localizar el archivo con el nombre `My Collection.postman_collection.json`.

Podemos utilizar dicha colección dentro de Postman y empezar con nuestras pruebas.


### Paso 6: Cargar datos de Prueba en la base de datos 

Para cargar los datos de prueba es necesario ejecutar dentro de la terminal el siguiente comando (linux).

**NOTA: Es importante no haber apagado el contenedor del proyecto**
```bash
cat ./SQL/insertion.sql | docker exec -i pruebatecnica_db psql -U postgres -d pruebatecnica_bd
```

### Paso 7: Testea sin mesura!!
Este proyecto fue parte de una prueba técnica. supuso un reto bastante entretenido. Agradeciendo haber llegado hasta acá en la lectura. 
