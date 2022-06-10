# Show Me What You Got

## VII. Examen Programación DAW Dual
```
            ___
        . -^    `--,
       /# =========`-_
      /# (--===___====\
     /#   .- --.  . --.|
    /##   |  * ) (   * ),
    |###  \    /\ \    /|
    |###   ----  \  --- |
    |####      ___)    #|
     \####            ##|
      \### ----------  /
       \###           (
        '\###         |
          \##         |
           \###.    .)
            '======/
```

# Modificaciones Por Cambios de Dependencias

## Default Generation Identity
Quitar id de default en schema.sql en t_items y t_ordenes, porque Hibernate los crea automaticamente.  
Si se insertan manualmente generan conflicto, porque Hibernate empieza otra vez de 1L.  

## @TestTransaction
Todas las transacciones de los test deberian ser marcadas con @TestTransaction en vez de @Transactional.  
Ya que @TestTransaction hace un rollback tambien cuando nada va mal.  
Esto es necesario ya que en el test *RepoTest#test_delete_item* se borran dos items '+5 Dexterity Vest', que son los items que esta esperando el test *ResourceTest#test_delete_item*.  
Ejecutados separatamente funcionan, pero si los ejecutamos juntos, el @Transactional hara el commit y borrara' los dos items, haciendo fallar el test de Resource.  
Solo he cambiado ese @Transactional porque no sabia si habia tests que dependian de otros tests.  

# Docker
## Docker JVM y Docker Native
Para crear la imagen docker con jvm he creado un script que lo hace mas facil.  
El script te deja crear la imagen, subirla a dockerhub y arrancar el contenedor.

Luego me tome' la libertad de crear un script que crea la imagen nativa, que hace uso de un h2 arrancado con otra imagen custom creada con el dockerfile *Dockerfile.h2*.  
Para poder usar este script tenemos que poner la siguente linea en el *application.properties*:
```conf
%native.quarkus.datasource.jdbc.url=jdbc:h2:tcp://h2/~/default;DB_CLOSE_DELAY=-1
```
Luego el script ejecuta docker compose, que arranca un contenedor con quarkus nativo y otro con h2, llamado *h2*, la jdbc.url del perfil native se conectara a este contenedor.

## DockerHub Repo
[stonarini](https://hub.docker.com/repository/docker/stonarini/showmewhatyougot)

---

## Key-Concepts :dart: 
- Quarkus
- MVC
- Active Record
- Docker
- Docker-Compose
- H2

![agitare-e-colpire](https://media.giphy.com/media/xSS0vcjoQM8KY/giphy.gif)
