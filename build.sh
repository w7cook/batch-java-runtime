cd src
javac -d ../bin -cp ../lib/jackson-core-asl-1.3.2.jar `find . | fgrep .java`
cd ..
cd test
javac -d ../bin -cp ../bin:../lib/jackson-core-asl-1.3.2.jar `find . | fgrep .java`
cd ..
