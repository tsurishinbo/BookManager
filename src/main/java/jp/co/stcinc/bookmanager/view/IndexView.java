/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.stcinc.bookmanager.view;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import jp.co.stcinc.bookmanager.entity.TBook;
import jp.co.stcinc.bookmanager.facade.TBookFacade;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author kageyamay
 */
@Named(value = "indexView")
@RequestScoped
public class IndexView {

    @Getter @Setter
    private List<TBook> bookList;
    
    @Getter @Setter
    private TBook selectedBook;
    
    @EJB
    private TBookFacade tBookFacade;
    
    @PostConstruct
    public void init() {
        bookList = tBookFacade.findAll();
    }
    
    public String doEdit() {
        return "edit.xhtml?faces-redirect=true";
    }
    
}
