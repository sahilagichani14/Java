docker build -t project-image .
docker run --name project-app -p 8080:8080 -d project-image