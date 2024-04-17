
# Dice - Weather

This project is a backend task from Dice. This is a spring boot application to get Forecast Summary and Hourly Forecast based on city name.

## APIs

Requirement was to use RapidAPI's [Forecast](https://rapidapi.com/wettercom-wettercom-default/api/forecast9) API to retrive the data. Following are the two APIs -


* curl --location 'http://localhost:8080/weather/forecastSummary/Mumbai' \
    --header 'client-id: Naman_User' \
    --header 'client-secret: Dice'

* curl --location 'http://localhost:8080/weather/hourlyForecast/Mumbai' \
    --header 'client-id: Naman_User' \
    --header 'client-secret: Dice'


Authentication Method: Header-based authentication with random client id and random
client secret.



## Usage Example

<img width="898" alt="Screenshot 2024-04-17 at 11 19 55 AM" src="https://github.com/namanjha007/weather-dice/assets/51926526/172553fe-1bf0-4ffe-bc49-385e2c38b558">

