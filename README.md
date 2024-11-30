# Franchise Maker

## Prerequisites

- Java 17 JDK
- Gradle
- Docker
- Docker Compose

## Setup

1. **Clone the repository:**

   ```sh
   git clone https://github.com/your-repo/franchise-maker.git
   cd franchise-
    ```

2. **configuration:**

   Ensure that the `application.properties` file is correctly configured.
   and the env variables are set.
   

* #### Docker

   if you are using docker, use the docker-compose file set the env variable.
      
   by default a cloud-base database is used, you can change the database url and credentials in the `application.properties` file.
      
   or set the env variable `DATABASE_URL` and `DATABASE_PASSWORD` in the docker-compose file.
      
   and use the following command to start the application.
      
   ```sh
    docker-compose up
   ```
   


3. **Build the project:**

   ```sh
   ./gradle build
   ```
   

   
