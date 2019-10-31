# Timeline - Backend

This has been started during the Auto1 Hackathon in October of 2019 as a personal project to use the micronaut framework.
I will keep working on this from time to time.

Please find instructions how to use this below.

Feel free to contribute via pull requests!

===================== Original readme from create-react-app =====================

This project is using `https://micronaut.io/`. Here is a nice guide on how to get started: https://guides.micronaut.io/creating-your-first-micronaut-app/guide/index.html

To run this project simply use `gradle run`. This backend provides an API on port 8080 with these endpoints:
- /api/status which just returns `Service is up and running` when the service is up
- /api/day with standard crud operations for days
- /api/task with standard crud operations for updatings tasks

To enable calls to this API together with the test frontend a proxy is needed to avoid CORS errors. 
`localhost:8080` has therefore been added as proxy in the frontend settings.
