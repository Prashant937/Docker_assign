docker build -t assign2.0:2.0 --no-cache .

docker volume create servervol

docker network create --driver=bridge --subnet=180.10.0.0/24 assignment

docker run -it --name assignmentserver --mount source=servervol,target=/server-data --network assignment --ip 180.10.0.10 assign2.0:2.0