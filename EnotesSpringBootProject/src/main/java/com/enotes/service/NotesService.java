package com.enotes.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.enotes.entity.Notes;
import com.enotes.entity.User;

public interface NotesService {

	public Notes saveNotes(Notes notes);
	
	public Notes getNotesById(int id);
	
//	public List<Notes> getNotesByUser(User user);
	
	public Page<Notes> getNotesByUser(User user, int pageNo);
	
	public Notes updateNotes(Notes notes);
	
	public boolean deleteNotes(int id);
}
