# Sistema de Gestión de Productos - Arquitectura Hexagonal (UFPS)

Este proyecto implementa un módulo de gestión de productos utilizando el patrón de **Arquitectura Hexagonal** (Ports & Adapters) con **Spring Boot 3**. El objetivo principal es aislar el núcleo de negocio de los detalles técnicos y de infraestructura, permitiendo que la lógica sea independiente de frameworks externos.



## 🏗️ Estructura del Proyecto
La organización del código sigue una separación estricta para garantizar la inversión de dependencias:

### 1. Núcleo de Dominio (`domain/`)
Es el corazón de la aplicación y no contiene dependencias de Spring ni JPA.
* **Model (`model/`)**: Contiene la entidad `Producto`, un objeto Java puro (POJO) que incluye la lógica de validación de stock.
* **Ports (`port/`)**: 
    * **In (Driving Ports)**: Interfaces que definen los casos de uso (`CrearProductoUseCase`, `ListarProductosUseCase`, `ActualizarStockUseCase`).
    * **Out (Driven Ports)**: Interfaz `ProductoRepositoryPort` que define las operaciones necesarias para la persistencia.
* **Service (`service/`)**: `ProductoDomainService` implementa los puertos de entrada y orquesta las operaciones sin conocer detalles técnicos.

### 2. Adaptadores (`adapter/`)
Implementaciones que conectan el exterior con el núcleo de negocio.
* **Web (`in/web/`)**: Adaptador primario (`ProductoController`) que traduce las peticiones REST en llamadas a los casos de uso.
* **Persistence (`out/persistence/`)**: Adaptador secundario (`ProductoRepositoryAdapter`) que implementa el puerto de salida utilizando Spring Data JPA para la persistencia real.

### 3. Configuración (`config/`)
* **`BeanConfiguration`**: Clase encargada de registrar manualmente los servicios de dominio como beans de Spring, manteniendo el dominio libre de anotaciones de framework.

## 🚀 Guía de Ejecución

### Prerrequisitos
* **Java JDK 17** o superior.
* **Maven 3.8+**.

### Instrucciones
1.  Clonar el repositorio:
    ```bash
    git clone [https://github.com/juandiego305/Contreras-post2-u7.git](https://github.com/juandiego305/Contreras-post2-u7.git)
    ```
2.  Compilar el proyecto:
    ```bash
    mvn clean package
    ```
3.  Ejecutar la aplicación:
    ```bash
    mvn spring-boot:run
    ```

## 🛰️ Endpoints de la API

| Método | Endpoint | Acción |
| :--- | :--- | :--- |
| **GET** | `/api/productos` | Listar todos los productos del inventario. |
| **POST** | `/api/productos` | Crear un nuevo producto. |
| **PATCH** | `/api/productos/{id}/stock` | Reducir el stock disponible de un producto. |

## 📸 Evidencias de Verificación
1. **Creación de Producto**: Captura del POST exitoso con código 201.
<img width="1096" height="768" alt="image" src="https://github.com/user-attachments/assets/acf6479f-1840-4965-b8e9-981e8bc0340a" />

2. **Listado de Inventario**: Captura del GET mostrando los productos guardados.

<img width="1099" height="783" alt="image" src="https://github.com/user-attachments/assets/b2a16abf-6f3c-4e8e-bf25-be3000c761b2" />

3. **Validación de Stock**: Captura del error 400 cuando se intenta reducir más stock del disponible.
<img width="1127" height="737" alt="image" src="https://github.com/user-attachments/assets/99d24b35-b412-4bde-a25a-65f73296eab4" />


## 🧑‍💻 Autor
* **Nombre**: Juan Diego Contreras Garcia
* **Institución**: Universidad Francisco de Paula Santander (UFPS)
* **Programa**: Ingeniería de Sistemas - 2026

---
© 2026 UFPS - Facultad de Ingeniería
