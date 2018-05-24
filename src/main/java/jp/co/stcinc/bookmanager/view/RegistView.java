package jp.co.stcinc.bookmanager.view;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import jp.co.stcinc.bookmanager.entity.TBook;
import jp.co.stcinc.bookmanager.facade.TBookFacade;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author kageyamay
 */
@Named(value = "registView")
@ViewScoped
public class RegistView implements Serializable {

    @Getter @Setter
    private TBook newBook;
    
    @EJB
    private TBookFacade tBookFacade;
    
    @PostConstruct
    public void init() {
        newBook = new TBook();
    }

    public String doRegist() {
        tBookFacade.create(newBook);
        return "index.xhtml?faces-redirect=true";
    }
    
    public String doReturn() {
        return "index.xhtml?faces-redirect=true";
    }
    
}
