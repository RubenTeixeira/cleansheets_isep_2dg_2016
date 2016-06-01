/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.persistence;

import csheets.domain.Event;
import csheets.framework.persistence.repositories.Repository;

/**
 *
 * @author João Martins
 */
public interface EventRepository extends Repository<Event, Long> {

}
