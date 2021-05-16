cd client

docker build -t assign1.0:1.0 --no-cache .

docker volume create clientvol

docker run -it --name assignmentclient --mount source=clientvol,target=/client-data --network assignment assign1.0:1.0
