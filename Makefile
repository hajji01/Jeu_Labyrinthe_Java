JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
        $(JC) $(JFLAGS) $*.java

CLASSES = \
        action.java \
        Cell.java \
        Grilles.java \
        UnknownCellException.java \
        UnknownWallException.java \
        AleaGen.java \
        Direction.java \
        Goal.java \
        Wall.java \
        Enigme.java \
        Items.java \
        Joyaux.java \
        Parchemins.java \
        Conversation.java \
        Hero.java \
        Marchands.java \
        Personnage.java \
        Sphynx.java \
        Main.java 

default: classes

classes: $(CLASSES:.java=.class)

docs: $(JC)  $*.java

clean:
        $(RM) *.class



/*
#Création du fichiers classes :
	mkdir classes

#Pour compiler le main (il compile aussi les autres classes)
	javac -sourcepath src -d classes .\src\Main.java
	javac -sourcepath src -d classes .\src\Grilles\UnknownWallException.java
	javac -sourcepath src -d classes .\src\Objets\*.java
	javac -sourcepath src -d classes .\src\Personnages\*.java

#Pour compiler les test
javac -classpath test4poo.jar .\test\PersonnagesTest\*.java
javac -classpath test4poo.jar .\test\GrillesTest\*.java

#Pour lancer le main :

	java -classpath classes Main

#Pour lancer les tests :
	
	java -jar test4poo.jar GrillesTest.CellTest
	java -jar test4poo.jar GrillesTest.DirectionTest

	java -jar test4poo.jar PersonnagesTest.HeroTest


#Génerer la documentation :

	javadoc -sourcepath src -d docs -subpackages action Grilles Objets Personnages



#creation d’un jar ex ́ecutable

	jar cvfe appli.jar pack1.MyMainClass -C classes classes

#execution du fichier jar
	java -jar appli.jar
*/