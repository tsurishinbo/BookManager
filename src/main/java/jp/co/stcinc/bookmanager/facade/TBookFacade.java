/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.stcinc.bookmanager.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jp.co.stcinc.bookmanager.entity.TBook;

/**
 *
 * @author kageyamay
 */
@Stateless
public class TBookFacade extends AbstractFacade<TBook> {

    @PersistenceContext(unitName = "BookManagerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TBookFacade() {
        super(TBook.class);
    }
    
}
