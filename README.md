## Recipe API

Api criada para demonstração da utilização do Angular.

## Tech

* Kotlin
* Gradle
* Spring Boot
* Web Reactive
* MongoDB
* Mongo Embedded - *Test*


> Build project : 

```bash
$ ./gradlew build
```

> Run integration test:

```bash
$ ./gradlew test
```

### Dependencies

* Mongo

### Using Docker to Up MongoDB:

```bash
$ docker run -d -p 27017:27017 mongo
```

## Run Api : 

```bash
$ ./gradlew bootRun
```

> Port : 8080 *by default*


### Endpoints

##### POST

- To create

> /recipes

```json
{
	"name": "Test",
	"description": "Test Description",
	"image": "https://www.tasteofhome.com/wp-content/uploads/2017/10/Healthier-than-Egg-Rolls_EXPS_SDON17_55166_C06_23_6b-696x696.jpg"
}
```

`Reponse status: 201`

--- 

##### GET

- List All

> /recipes

`Reponse status: 200`

```json
[
    {
        "id": "5cc091426493206b8bf75baa",
        "name": "Test",
        "description": "Test Description",
        "image": "https://www.tasteofhome.com/wp-content/uploads/2017/10/Healthier-than-Egg-Rolls_EXPS_SDON17_55166_C06_23_6b-696x696.jpg"
    }
]
```

--- 

##### GET

- Get By Id

> /recipes/{id}

`Reponse status: 200`

```json
{
    "id": "5cc091426493206b8bf75baa",
    "name": "Test",
    "description": "Test Description",
    "image": "https://www.tasteofhome.com/wp-content/uploads/2017/10/Healthier-than-Egg-Rolls_EXPS_SDON17_55166_C06_23_6b-696x696.jpg"
}
```

--- 

##### PUT

- Update recipe

> /recipes/{id}

```json
{
    "name": "Test",
    "description": "Test Description",
    "image": "https://www.tasteofhome.com/wp-content/uploads/2017/10/Healthier-than-Egg-Rolls_EXPS_SDON17_55166_C06_23_6b-696x696.jpg"
}
```

`Reponse status: 200`

--- 

##### DELETE

- Delete by id

> /recipes/{id}

`Reponse status: 204`