# Partición de Equivalencia

### Clases válidas:
- **Escenario:**
  ```gherkin
  Dado que ingreso un nombre con más de 3 caracteres en el campo nombre
  Cuando intento guardar la información
  Entonces debería poder guardar la información correctamente
- **Escenario:**
  ```gherkin
    Dado que ingreso un nombre con menos de 50 caracteres en el campo nombre
    Cuando intento guardar la información
    Entonces debería poder guardar la información correctamente
### Clases inválidas:
  - **Escenario:**
    ```gherkin
    Dado que ingreso menos de 3 caracteres en el campo nombre
    Cuando intento guardar la información
    Entonces no debería permitir guardar la información
- **Escenario:**
  ```gherkin
   Dado que dejo el campo nombre vacío
   Cuando intento guardar la información
   Entonces debería mostrar un mensaje de error bajo el campo nombre
  
# Valores Límites
### Límite inferior: 3 caracteres:
- **Escenario:**
    ```gherkin
    Dado que ingreso 1 carácter en el campo nombre
    Cuando intento guardar la información
    Entonces no debería permitir guardar la información
### Límite superior: 50 caracteres:
- **Escenario:**
    ```gherkin
   Dado que ingreso 51 caracteres en el campo nombre
   Cuando intento guardar la información
   Entonces no debería permitir ingresar más de 50 caracteres
# Tablas de decisión
Para efectos practicos se realizo todo el proceso y se genero la tabla final

| Condición                 | Identificación Válida | Nombre Válido | Apellido Válido | Acción Esperada                              |
|---------------------------|-----------------------|---------------|-----------------|----------------------------------------------|
| 1. Identificación vacía    | No                    | Sí            | Sí              | Mostrar error abajo del campo identificación |
| 2. Nombre vacío            | Sí                    | No            | Sí              | Mostrar error abajo del campo nombre         |
| 3. Apellido vacío          | Sí                    | Sí            | No              | Mostrar error abajo del campo apellido       |
| 4. Datos completos         | Sí                    | Sí            | Sí              | Guardar cliente                              |

- **Escenario:Dejar el campo Identificacion Vacio**
    ```gherkin
        Dado que no ingreso la identificacion
        Cuando intento guardar la información
        Entonces se debe mostar un error bajo el campo identificación

- **Escenario: Dejar el campo Nombre Vacio**
    ```gherkin
        Dado que no ingreso el nombre
        Cuando intento guardar la información
        Entonces se debe mostar un error bajo el campo nombre


- **Escenario: Dejar el campo Apellido Vacio**
    ```gherkin
        Dado que no ingreso el apellido
        Cuando intento guardar la información
        Entonces se debe mostar un error bajo el campo apellido

- **Escenario: Ingresar toda la informacion**
    ```gherkin
        Dado que no ingreso toda la información
        Cuando intento guardar la información
        Entonces se debe crear el cliente
  
# Transición de Estados
## Estado 1: 
Usuario ingresa a la opcion cliente

Acción: Cargar el formulario vacio.
## Estado 2:
Usuario completa algunos campos

Acción: Si el usuario intenta guardar sin diligenciar los campos obligatorios le debe mostrar una alerta.

## Estado 3:
Usuario completa todos los campos

Acción: Si la información es correcta permite guardar, de lo contrario debe mostar una alerta.

## Estado 4:
Usuario finaliza correctamente

Acción: Mostar mensaje de exito.

- **Escenario: Completar todo el formulario**
    ```gherkin
        Dado que el usuario ingresa toda la información
        Cuando intenta guardar
        Entonces se muestra un mensaje de exito.

- **Escenario: Dar clic en guardar sin completar datos**
    ```gherkin
        Dado que el usuario no llena ningun campo
        Cuando intenta guardar
        Entonces se muestra un mensaje de error.