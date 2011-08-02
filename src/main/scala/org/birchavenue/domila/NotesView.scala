package org.birchavenue.domila
import lotus.domino._

class NotesView(underlying: View) {

	def name() = underlying.getName()
	override def toString = name
	
	def getFirstDocument(): Option[NotesDocument] = {
		val firstDoc = underlying.getFirstDocument()
		
		firstDoc match {
			case null => None
			case _ => Some(new NotesDocument(firstDoc))
		}			
	}
	
	def getNextDocument(doc: NotesDocument): Option[NotesDocument] = {
		val nextDoc = underlying.getNextDocument(doc.getUnderlying)
		
		nextDoc match {
			case null => None
			case _ => Some(new NotesDocument(nextDoc))
		}			
	}
	
	
	def documents() = {
		getFirstDocument match {
			case None => scala.collection.immutable.Stream.empty
			case Some(x) => documentsFrom(x)
		}
	}

	def documentsFrom(doc: NotesDocument): scala.collection.immutable.Stream[NotesDocument] = {
		val nextDoc = getNextDocument(doc)

		nextDoc match {
			case None => scala.collection.immutable.Stream.empty
			case Some(doc) => scala.collection.immutable.Stream.cons(doc, documentsFrom(doc))
		}
	
	}
}