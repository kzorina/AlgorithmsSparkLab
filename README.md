# AlgorithmsSparkLab
To run with Dockerfile please install docker (worked for Ubuntu 16.04):
```
sudo apt-get update
sudo apt-key adv --keyserver hkp://p80.pool.sks-keyservers.net:80 --recv-keys 58118E89F3A912897C070ADBF76221572C52609D
sudo apt-add-repository 'deb https://apt.dockerproject.org/repo ubuntu-xenial main'
sudo apt-get update
sudo apt-get install -y docker-engine
```
Then clone git repository
```
git clone https://github.com/kzorina/AlgorithmsSparkLab
cd AlgorithmsSparkLab/
```
Build docker image from Dockerfile
```sudo docker build -t sparklab .```
And run this image. You will see, how many triangles you have in followers.txt.
``` sudo docker run sparklab ```
