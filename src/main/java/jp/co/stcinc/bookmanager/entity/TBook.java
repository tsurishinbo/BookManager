/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.stcinc.bookmanager.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kageyamay
 */
@Entity
@Table(name = "t_book")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TBook.findAll", query = "SELECT t FROM TBook t")
    , @NamedQuery(name = "TBook.findById", query = "SELECT t FROM TBook t WHERE t.id = :id")
    , @NamedQuery(name = "TBook.findByTitle", query = "SELECT t FROM TBook t WHERE t.title = :title")
    , @NamedQuery(name = "TBook.findByAuthor", query = "SELECT t FROM TBook t WHERE t.author = :author")
    , @NamedQuery(name = "TBook.findByGenre", query = "SELECT t FROM TBook t WHERE t.genre = :genre")
    , @NamedQuery(name = "TBook.findByStartDate", query = "SELECT t FROM TBook t WHERE t.startDate = :startDate")
    , @NamedQuery(name = "TBook.findByEndDate", query = "SELECT t FROM TBook t WHERE t.endDate = :endDate")
    , @NamedQuery(name = "TBook.findByRank", query = "SELECT t FROM TBook t WHERE t.rank = :rank")
    , @NamedQuery(name = "TBook.findByImpressions", query = "SELECT t FROM TBook t WHERE t.impressions = :impressions")})
public class TBook implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "author")
    private String author;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "genre")
    private String genre;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "rank")
    private Integer rank;
    @Size(max = 200)
    @Column(name = "impressions")
    private String impressions;

    public TBook() {
    }

    public TBook(Integer id) {
        this.id = id;
    }

    public TBook(Integer id, String title, String author, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getImpressions() {
        return impressions;
    }

    public void setImpressions(String impressions) {
        this.impressions = impressions;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TBook)) {
            return false;
        }
        TBook other = (TBook) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.stcinc.bookmanager.entity.TBook[ id=" + id + " ]";
    }
    
}
