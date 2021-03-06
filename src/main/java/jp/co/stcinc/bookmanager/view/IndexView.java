package jp.co.stcinc.bookmanager.view;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import jp.co.stcinc.bookmanager.entity.TBook;
import jp.co.stcinc.bookmanager.facade.TBookFacade;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author kageyamay
 */
@Named(value = "indexView")
@ViewScoped
public class IndexView implements Serializable {

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
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.put("book", selectedBook);
        return "edit.xhtml?faces-redirect=true";
    }
    
    public String doAdd() {
        return "regist.xhtml?faces-redirect=true";
    }
    
}
