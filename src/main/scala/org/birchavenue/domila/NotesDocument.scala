package org.birchavenue.domila
import lotus.domino._

class NotesDocument(underlying: Document) {

	def getUnderlying = underlying
	def NoteID = underlying.getNoteID()
	def UniversalID = underlying.getUniversalID
	
	def items = List.fromArray(underlying.getItems.toArray).map(x => new NotesItem(x.asInstanceOf[Item]))

		
	override def toString = UniversalID
}