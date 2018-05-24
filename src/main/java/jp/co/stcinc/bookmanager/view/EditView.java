package jp.co.stcinc.bookmanager.view;

import java.io.Serializable;
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
@Named(value = "editView")
@ViewScoped
public class EditView implements Serializable {

    @Getter @Setter
    private TBook editBook;
    
    @EJB
    private TBookFacade tBookFacade;
    
    @PostConstruct
    public void init() {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        editBook = (TBook)flash.get("book");
    }

    public String doUpdate() {
        tBookFacade.edit(editBook);
        return "index.xhtml?faces-redirect=true";
    }
    
    public String doDelete() {
        tBookFacade.remove(editBook);
        return "index.xhtml?faces-redirect=true";
    }
    
    public String doReturn() {
        return "index.xhtml?faces-redirect=true";
    }

}
