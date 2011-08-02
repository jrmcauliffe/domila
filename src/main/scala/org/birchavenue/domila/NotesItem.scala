package org.birchavenue.domila
import lotus.domino._


class NotesItem(underlying: Item) {

	
		override def toString =  underlying.getName() + "=" + underlying.getText()
		
}