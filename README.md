# Conversor de Monedas
![Badge en Desarollo](https://img.shields.io/badge/STATUS-EN%20DESAROLLO-green)


Este proyecto es un conversor de monedas que permite realizar conversiones entre diferentes divisas. Utiliza la API de [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener las tasas de cambio actualizadas.

## Funcionalidades

- Convertir entre diversas monedas como USD, ARS, EUR, BRL, COP, etc.
- Guardar un historial de conversiones realizadas.
- Registrar conversiones con marcas de tiempo.

## Requisitos

- Java 21 o superior.
- Dependencias de Maven configuradas en el archivo `pom.xml`.

## Capturas de Pantalla

A continuación se muestran algunas capturas de pantalla que ilustran cómo funciona el proyecto.

### Pantalla de inicio
Una vez que el usuario inicia el programa, verá un menú con opciones para elegir la conversión de monedas:

![pantallainicio](https://github.com/user-attachments/assets/19966601-3b99-402c-9d92-4f75606185e5)


### Ingreso de monto
El usuario ingresa el monto que desea convertir después de seleccionar la opción de conversión:

![ingresomonto](https://github.com/user-attachments/assets/e51e82a1-53db-4986-9217-a086501bdfac)

### Resultado de la conversión
Después de realizar la conversión, el programa muestra el resultado con el monto convertido:

![resultadoconversion](https://github.com/user-attachments/assets/6b678080-6d50-4be5-a6e6-b023442cf7e6)


## Configuración

1. **Clonar el repositorio**:

   ```bash
   git clone https://github.com/tu_usuario/conversor-de-monedas.git
   cd conversor-de-monedas

## Configuración del archivo `.env`

Este proyecto utiliza un archivo `.env` para almacenar de manera segura tu clave API (API_KEY) para acceder a la API de conversión de monedas.

1. **Crear el archivo `.env`**: En la raíz de tu proyecto, crea un archivo llamado `.env`.

2. **Obtener tu API Key**:
   - Regístrate en [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener tu clave de API gratuita.
   
3. **Configurar el archivo `.env`**:
   Abre el archivo `.env` y agrega tu clave API en el formato siguiente:

   ```plaintext
   API_KEY=tu_api_key_aqui   

## Créditos

Proyecto creado como estudiante del Challenge ONE -
JAVA | BACK-END de Alura

![Alura LATAM](https://github.com/user-attachments/assets/92a155ab-bcbb-41c6-8bbc-a0e8f552eb0f)
![ONE](https://github.com/user-attachments/assets/368ff23a-e3f2-4f08-a987-0f736996779c)
