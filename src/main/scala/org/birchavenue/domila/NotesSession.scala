package org.birchavenue.domila
import lotus.domino._

class NotesSession {
	NotesThread.sinitThread()
	val underlying: Session = NotesFactory.createSession()

	
	def getUserName = underlying.getUserName()
	def getDatabase(server: String, db: String) = new NotesDatabase(underlying.getDatabase(server, db))
}