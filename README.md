
# Spring rest api

A simple crud for albums that contains title, artist and price.

## Running

```bash
  docker-compose up -d
```

```bash
  ./mvnw spring-boot:run
``` 
## Endpoints

#### Create an album

```http
  POST /api/albums
```

#### Get all albums

```http
  GET /api/albums
```

#### Get album by id

```http
  GET /api/albums/${id}
```

#### Update an album

```http
  PUT /api/albums
```

#### Delete an album

```http
  DELETE /api/albums/${id}
```
