JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Program.java \
	UserInterface.java \
	List.java \
	Category.java \
	User.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
