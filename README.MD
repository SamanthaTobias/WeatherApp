# Weather App

This is a simple Spring Boot application that retrieves weather information from OpenWeatherMap API based on the city name.

## Running the App

### Prerequisites

- Docker Desktop installed and running on your machine
- An OpenWeatherMap API key

### Steps

1. Clone the repository
2. Set your OpenWeatherMap API key in the `src/main/resources/application.properties` file
3. Launch Docker Desktop
4. Open a terminal window in the project root directory
5. Run the following command to build and run the Docker container:

```/build-and-run-weather-app.sh```


This will build the Maven project, build the Docker image, and run the Docker container.

6. The app will be available at `http://localhost:9020/weather/{city}`. Replace `{city}` with the name of the city for which you want to retrieve weather information.

## License

This project is not licensed.

## Acknowledgements

This project was created as a learning exercise with guidance from the following resources:

- Spring Boot documentation
- OpenWeatherMap API documentation
- Docker documentation
