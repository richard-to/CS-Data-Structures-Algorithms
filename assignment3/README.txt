# How to run supermarket simulation

1. Unzip to3.zip.
2. Open a terminal window and cd into the folder named to3.
3. mkdir bin
4. javac -sourcepath src src/Assignment3.java -d bin
5. cd bin
6. java Assignment3
7. There is a static variable in Assignment3.java that controls the number of checkout counters.
  - Currently it is set to 11, which looks to be the optimal number and leads to an avg wait time of 6 minutes.

* Note that the unit tests won't work as is. I use Junit 4, which comes bundled with my IDE.
* You can download Junit 4 from https://github.com/KentBeck/junit/downloads
