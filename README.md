Domila
=====================================
#### Scala for Lotus Notes/Domino ####

Domila is a library of scala wrapper classes for the Lotus Notes/Domino java classes. It is currently at alpha/proof of concept stage.

### Targeted Platforms ###

Initially, domingo will be implemented to work through the notes client (using notes.jar), but an implementation of Corba is also planned in the future (NCSO.jar). This means that you require a notes client installation to use domila.

Domila should work on the three supported notes client platforms (Windows, Linux and OSX), but I currently only have the ability to test on Windows and Linux.


### Building Domila from source ###

To build Domila from source, you need:

* a copy of the source tree from github
* a copy of the Lotus Notes Java Toolkit jar file, `Notes.jar`
* a working maven environment

Check out the Domila source with

	$git clone git://github.com/jrmcauliffe/prototype.git
	$cd domila

Copy the file `Notes.jar` to the `lib/` directory

Build the Domila jar with maven 

	$mvn package

### Using Domila from the scala shell ###

Start your Lotus Notes Client and login

Set your Notes Client not to prompt for passwords. Check the checkbox User Security >> Security Basics >> Don't prompt for a password from other Notes-based programs

Make sure that you are using a 32bit JVM, in Windows this can be accomplished by seting the javacmd environment variable to the path of the 32bit JRE

	set javacmd=C:\Program Files (x86)\Java\jre6\bin\java

Start the scala interpretor (with Notes.jar and domila.jar in the classpath)

	$scala -classpath "*.jar"

Import the Domila libraries and start using the classes

	scala> import org.birchavenue.domila._
	import org.birchavenue.domila._
	
	scala> val session = new NotesSession
	session: org.birchavenue.domila.NotesSession = org.birchavenue.domila.NotesSession@c7ecd5

	scala> println(session.getUserName)
	CN=Jonathan McAuliffe/O=QBlue	

