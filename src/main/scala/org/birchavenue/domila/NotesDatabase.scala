package org.birchavenue.domila

import lotus.domino._

class NotesDatabase(underlying: Database) {
	
	def title = underlying.getTitle
	
	lazy val views = List.fromArray(underlying.getViews.toArray).map(x => new NotesView(x.asInstanceOf[View]))
	
	
	def getView(name: String) = new NotesView(underlying.getView(name))	
}