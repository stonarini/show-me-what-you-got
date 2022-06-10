# Show-Me-What-You-Got

## VII Examen Programación DAW Dual
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

## Key-Concepts :dart: 
- Quarkus
- MVC
- Active Record

## UML
![Custom UML](showmewhatyougot_UML.png)