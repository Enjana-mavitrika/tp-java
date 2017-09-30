#
# Makefile pour automatiser la compilation de notre programme Test
# et creation de la javadoc pour le package
#

JJ = javac
JD = javadoc

Prog : Test dessin_doc clean

Test :
	$(JJ) Test.java

dessin_doc :
	$(JD) dessin/Polygone.java dessin/Point.java dessin/Quadrilatere.java dessin/Rectangle.java dessin/Triangle.java -d $@

clean :
	rm -f *~

