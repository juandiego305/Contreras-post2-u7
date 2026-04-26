# Sistema de Gestión de Productos - Arquitectura Hexagonal (UFPS)

[cite_start]Este proyecto implementa un módulo de gestión de productos aplicando el patrón arquitectónico **Arquitectura Hexagonal** (también conocido como **Ports & Adapters**) utilizando **Spring Boot 3** [cite: 739-740]. [cite_start]El objetivo principal es aislar la lógica de negocio (el núcleo) de los detalles técnicos y de infraestructura[cite: 746].



## 🏗️ Arquitectura del Proyecto
[cite_start]La estructura del proyecto separa estrictamente el dominio de la infraestructura para garantizar la inversión de dependencias[cite: 746]:

### 1. Núcleo de Dominio (`domain/`)
[cite_start]Es el corazón de la aplicación y no depende de ningún framework externo (Spring, JPA, etc.) [cite: 379-380, 788].
* [cite_start]**Model (`model/`)**: Contiene la entidad `Producto`, un POJO puro que incluye lógica de negocio como la validación de stock [cite: 788-789].
* **Ports (`port/`)**: 
    * [cite_start]**In (Driving Ports)**: Interfaces que definen los casos de uso del sistema (`CrearProductoUseCase`, `ListarProductosUseCase`, `ActualizarStockUseCase`) [cite: 760, 790-821].
    * [cite_start]**Out (Driven Ports)**: Interfaz `ProductoRepositoryPort` que define lo que el dominio necesita de la persistencia [cite: 763, 827-831].
* [cite_start]**Service (`service/`)**: `ProductoDomainService` implementa los puertos de entrada y orquesta la lógica de negocio interactuando con los puertos de salida [cite: 772, 842-844].

### 2. Adaptadores (`adapter/`)
Implementaciones concretas que conectan el mundo exterior con el núcleo.
* [cite_start]**Web (`in/web/`)**: Adaptador primario (`ProductoController`) que traduce peticiones HTTP en llamadas a los casos de uso [cite: 774, 990-993].
* [cite_start]**Persistence (`out/persistence/`)**: Adaptador secundario (`ProductoRepositoryAdapter`) que implementa el puerto de salida utilizando Spring Data JPA [cite: 779, 878-912].

### 3. Configuración (`config/`)
* [cite_start]**`BeanConfiguration`**: Clase encargada del "wiring" o registro manual de los beans de dominio, ya que el servicio de dominio es una clase Java pura sin anotaciones de Spring [cite: 780, 1019-1025].

## 🚀 Guía de Ejecución

### Prerrequisitos
* [cite_start]**Java JDK 17** o superior[cite: 741].
* [cite_start]**Maven 3.8+**[cite: 741].

### Comandos de Ejecución
1.  **Compilar y empaquetar**:
    ```bash
    mvn clean package
    ```
2.  **Ejecutar la aplicación**:
    ```bash
    mvn spring-boot:run
    ```

## 🛰️ Endpoints de la API

| Método | Endpoint | Acción |
| :--- | :--- | :--- |
| **GET** | `/api/productos` | [cite_start]Listar todos los productos registrados[cite: 993]. |
| **POST** | `/api/productos` | [cite_start]Crear un nuevo producto (JSON)[cite: 1002]. |
| **PATCH** | `/api/productos/{id}/stock` | [cite_start]Reducir el stock de un producto[cite: 1012]. |

## 📸 Evidencias de Verificación (Checkpoints)
[cite_start]*(Adjuntar aquí las capturas de pantalla de Postman/curl)* [cite: 1065-1066]:
1.  [cite_start]**POST /api/productos**: Creación de producto exitosa (201 Created)[cite: 1044].
2.  [cite_start]**GET /api/productos**: Listado de productos actuales[cite: 1043].
3.  [cite_start]**PATCH /api/productos/{id}/stock**: Error 400 cuando la cantidad supera el stock disponible[cite: 1045].

## 🧑‍💻 Autor
* **Nombre**: Juan Diego Contreras Garcia
* **Institución**: Universidad Francisco de Paula Santander (UFPS)
* **Programa**: Ingeniería de Sistemas - 2026

---
© 2026 UFPS - Facultad de Ingeniería
