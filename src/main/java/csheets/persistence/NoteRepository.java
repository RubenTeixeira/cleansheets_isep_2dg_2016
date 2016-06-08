/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.persistence;

import csheets.domain.Note;
import csheets.framework.persistence.repositories.Repository;

/**
 *
 * @author Diogo Azevedo
 */
public interface NoteRepository extends Repository <Note, Long> {
    
}
