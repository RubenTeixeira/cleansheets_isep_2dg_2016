/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.persistence;

import csheets.domain.Contact;
import csheets.framework.persistence.repositories.DataIntegrityViolationException;
import csheets.framework.persistence.repositories.Repository;

/**
 *
 * @author Rui Freitas
 */
public interface ContactRepository extends Repository<Contact, Long>{
    
    
}
