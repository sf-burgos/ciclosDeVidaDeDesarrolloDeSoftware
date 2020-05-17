# cvdsLab3
Laboratorio #3- primerCorte CVDS

## Integrantes
>- Sebastian Nieto
>- Brayan Burgos

## Primera Parte

### Clases de equivalencia

  Validar el registro, verificar que este vivo, la edad no deberia ser negativa y si deberia tener un genero especifico.
  
## Bordes
  
  Edad: edad=17,18,19
  Vida: vida=true o vida=false
  Duplicacion: deberia ser true
  Edad negativa: -1, 0 o 1
  Genero: male, female o indefinido
  
## Segunda parte
### De acuerdo con lo indicado, y teniendo en cuenta que NO hay precondiciones, en qué casos se debería
arrojar una excepción de tipo ExcepcionParametrosInvalidos?. Agregue esto a la especificación.

  Cuando la edad, dias de antelacion o la tarifa base sean menores a cero.

### En la siguiente tabla enumere un conjunto de clases de equivalencia que -según usted- creen una
buena división del conjunto de datos de entrada de la función anterior.

  Limites entre la edad:  edad>18 y edad<18 y edad=18 y edad>65 y edad<65 y edad=65.
  Limites en dias de antelacion:  dias>20 dias<20 y dias=20.

### Los puntos 3,4,5.

  Su resultado se ve reflejado en las pruebas.
  Problemas en la prueba cuando se ejecutaba dias 20 y edad 17, no respetaba las reglas.

  
