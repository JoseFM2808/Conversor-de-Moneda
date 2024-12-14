# Conversor de Monedas

Este programa es un conversor de monedas simple que utiliza la API de [exchangerate-api.com](https://www.exchangerate-api.com/) para obtener las tasas de cambio actualizadas.

## Funcionalidades

* Convertir entre diferentes monedas (ARS, BOB, BRL, CLP, COP, USD).
* Mostrar las tasas de cambio actuales para las monedas disponibles.
* Interfaz de usuario en la consola.
* Validación de la entrada del usuario.

## Cómo usar

1. Clona el repositorio: `git clone https://github.com/tu_usuario/conversor_monedas.git`
2. Reemplaza la apikey en la clase `principal` con tu API key de exchangerate-api.com.
3. Compila el programa: `javac *.java`
4. Ejecuta el programa: `java principal`

## Ejemplo de uso

--- Conversor de Monedas ---
1. Convertir monedas
2. Mostrar tasas de cambio
0. Salir
Ingrese una opción: 2
ARS: 1020.75
BOB: 6.927
COP: 4355.7964
CLP: 978.1868
USD: 1.0
BRL: 6.0177

--- Conversor de Monedas ---
1. Convertir monedas
2. Mostrar tasas de cambio
0. Salir
Ingrese una opción: 1
Ingrese la moneda de origen (ARS, BOB, BRL, CLP, COP, USD): ARS
Ingrese la moneda de destino (ARS, BOB, BRL, CLP, COP, USD): COP
Ingrese la cantidad a convertir (número positivo): 1500
1500.0 ARS = 6400.876414401176 COP
--- Conversor de Monedas ---
1. Convertir monedas
2. Mostrar tasas de cambio
0. Salir
Ingrese una opción: 1
Ingrese la moneda de origen (ARS, BOB, BRL, CLP, COP, USD): ARS
Ingrese la moneda de destino (ARS, BOB, BRL, CLP, COP, USD): COP
Ingrese la cantidad a convertir (número positivo): 1500
1500.0 ARS = 6400.876414401176 COP
2. Mostrar tasas de cambio
0. Salir
Ingrese una opción: 1
Ingrese la moneda de origen (ARS, BOB, BRL, CLP, COP, USD): ARS
Ingrese la moneda de destino (ARS, BOB, BRL, CLP, COP, USD): COP
Ingrese la cantidad a convertir (número positivo): 1500
1500.0 ARS = 6400.876414401176 COP
Ingrese una opción: 1
Ingrese la moneda de origen (ARS, BOB, BRL, CLP, COP, USD): ARS
Ingrese la moneda de destino (ARS, BOB, BRL, CLP, COP, USD): COP
Ingrese la cantidad a convertir (número positivo): 1500
1500.0 ARS = 6400.876414401176 COP
Ingrese la moneda de origen (ARS, BOB, BRL, CLP, COP, USD): ARS
Ingrese la moneda de destino (ARS, BOB, BRL, CLP, COP, USD): COP
Ingrese la cantidad a convertir (número positivo): 1500
1500.0 ARS = 6400.876414401176 COP
Ingrese la moneda de destino (ARS, BOB, BRL, CLP, COP, USD): COP
Ingrese la cantidad a convertir (número positivo): 1500
1500.0 ARS = 6400.876414401176 COP
1500.0 ARS = 6400.876414401176 COP

--- Conversor de Monedas ---
1. Convertir monedas
2. Mostrar tasas de cambio
0. Salir
Ingrese una opción: 0
Saliendo del programa...

## Tecnologías utilizadas

* Java
* HttpClient
* Gson

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o envía un pull request.
