# MULTI USER CHATTING APPLICATION

This application will allow multiple client's to connect with a server and to chat with each other , the chats will be stored in history.txt as a text format on client as well as server side!

## Usage

### Server Side:-

Building the image:-

```
docker build -t assign2.0:2.0 --no-cache .
```
Creating The Volume:-
```
docker volume create servervol
```
Creating Network:-
```
docker network create --driver=bridge --subnet=180.10.0.0/24 assignment
```
 Running Container in interactive mode, mounting volume and network and assigning ip to the container:-

 ```
 docker run -it --name assignmentserver --mount source=servervol,target=/server-data --network assignment --ip 180.10.0.10 assign2.0:2.0
 ```

### Client Side:-

For Building the image:-

```
docker build -t assign1.0:1.0 --no-cache .
```
 Creating Volume:-

 ```
docker volume create clientvol
 ```
 Running Container in interactive mode, mounting volume and network:-

```
docker run -it --name assignmentclient --mount source=clientvol,target=/client-data --network assignment assign1.0:1.0
```
