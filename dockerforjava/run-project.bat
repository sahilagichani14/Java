docker build -t project-image -f Dockerfile-jar .
docker run --name project-app -p 8080:8080 -d project-image