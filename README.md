# api-framework-agnostic-java

Implementación de una API de cartas con arquitectura hexagonal. El módulo `core` contiene el dominio, los casos de uso y los puertos; Spring Boot y Quarkus implementan adapters independientes para entrada HTTP, persistencia PostgreSQL y consulta de Scryfall.

## Estructura

```text
core/
├── domain/model
└── application
    ├── port/in
    ├── port/out
    └── service

infra-spring-boot/
└── adapter
    ├── in/web
    └── out
        ├── persistence
        └── scryfall

infra-quarkus/
└── adapter
    ├── in/web
    └── out
        ├── persistence
        └── scryfall
```

`core` no depende de Spring, Quarkus, JPA ni del proveedor externo. Cada infraestructura compone el `CardService` y conecta sus adapters con los puertos del core.

## Requisitos

- Java 25
- Maven 3.9 o Maven Wrapper
- Docker o Podman
- PostgreSQL

## Base de datos

Inicia PostgreSQL desde la raíz del proyecto:

```bash
docker compose up -d card-database
```

La configuración local espera:

```text
Base de datos: card_db
Usuario: db_user
Contraseña: db_password
Puerto: 5432
```

## Ejecutar

Construir todos los módulos:

```bash
mvn clean install
```

Ejecutar Spring Boot en el puerto `8002`:

```bash
mvn -pl infra-spring-boot spring-boot:run
```

Ejecutar Quarkus en el puerto `8001`:

```bash
mvn -pl infra-quarkus quarkus:dev
```

## API

Ambas implementaciones exponen los mismos endpoints y el mismo formato JSON.

### Crear una carta

```http
POST /api/cards
Content-Type: application/json

{
  "card_name": "lightning bolt"
}
```

La aplicación consulta Scryfall para obtener el nombre de la carta antes de guardarlo.

### Obtener todas las cartas

```http
GET /api/cards
```

Respuesta de ejemplo:

```json
[
  {
    "card_name": "Lightning Bolt"
  }
]
```

## Arquitectura

El flujo de entrada es:

```text
HTTP controller
  -> input port
  -> CardService
  -> output port
  -> persistence o Scryfall adapter
```

Los controllers y adapters de cada framework pueden tener implementaciones diferentes. El comportamiento común se define mediante los puertos y el modelo del módulo `core`.
