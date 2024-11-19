
### 1. Listado de Monedas
Al seleccionar la opción 1:
- Muestra todas las monedas disponibles
- Formato: `CÓDIGO - Nombre de la Moneda`
- Ejemplo: `USD - Dólar Estadounidense`

### 2. Proceso de Conversión
Al seleccionar la opción 2:
1. Ingresa el código de la moneda de origen (ejemplo: USD)
2. Ingresa el código de la moneda de destino (ejemplo: EUR)
3. Ingresa el monto a convertir
4. El sistema muestra:
    - Monto original
    - Tipo de cambio aplicado
    - Resultado de la conversión
5. El sistema guarda la conversion en un fichero JSON para la persistencia de los datos. 

### 3. Finalizar
- Opción para salir de la aplicación de manera segura
- Guarda automáticamente el registro de operaciones

## 🛠️ Requisitos Técnicos

- Java 22 SDK
- Conexión a Internet (para obtener tipos de cambio en tiempo real)
