docker rm -f text-ana-cont
docker image rm -f text-ana-img
docker build --tag text-ana-img .
docker run -dp 5000:5000 --name text-ana-cont text-ana-img