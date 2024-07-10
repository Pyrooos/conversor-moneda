# Conversor de Monedas

Este es un proyecto Java que permite convertir cantidades entre diferentes monedas utilizando la API de ExchangeRate-API. El usuario puede seleccionar la divisa de origen y la divisa de destino, así como la cantidad a convertir. El programa muestra las divisas soportadas por la API para que el usuario pueda elegir su moneda o divisa.

## Requisitos

Java 8 o superior
Biblioteca Gson para manejar JSON ( )
Clave de API de ExchangeRate-API (puede obtenerse aquí)

## Instalación

Clonar este repositorio o descargar los archivos fuente.
Añadir la biblioteca Gson al classpath del proyecto.
Reemplazar YOUR-API-KEY en la clase API con tu clave de API de ExchangeRate-API.


## Estructura del Proyecto

El proyecto está dividido en cuatro clases:

API: Maneja las solicitudes HTTP a la API y devuelve los datos en formato JSON.
ConversorDivisas: Se encarga de la lógica de conversión de divisas.
Menu: Maneja la interacción con el usuario a través de la terminal.
Main: Contiene el punto de entrada principal de la aplicación.

## Uso

Ejecutar la clase Main.
El programa mostrará las divisas soportadas por la API.
Ingresar la divisa de origen, la divisa de destino y la cantidad a convertir.
El programa mostrará el resultado de la conversión.

## Contribuciones

Las contribuciones son bienvenidas. Por favor, sigue estos pasos para contribuir:

Haz un fork de este repositorio.
Crea una nueva rama (git checkout -b feature/nueva-funcionalidad).
Realiza tus cambios y haz commit (git commit -am 'Agrega nueva funcionalidad').
Sube tus cambios (git push origin feature/nueva-funcionalidad).
Abre un Pull Request. 

## Contacto 

Cristian Gutierrez // Pyrooos // Cristianguher@outlook.com