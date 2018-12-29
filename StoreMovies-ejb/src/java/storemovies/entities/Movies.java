/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storemovies.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author przeb
 */
@Entity
@Table(name = "MOVIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movies.findAll", query = "SELECT m FROM Movies m")
    , @NamedQuery(name = "Movies.findByMId", query = "SELECT m FROM Movies m WHERE m.mId = :mId")
    , @NamedQuery(name = "Movies.findByMTitle", query = "SELECT m FROM Movies m WHERE m.mTitle = :mTitle")
    , @NamedQuery(name = "Movies.findByMCategory", query = "SELECT m FROM Movies m WHERE m.mCategory = :mCategory")
    , @NamedQuery(name = "Movies.findByMYear", query = "SELECT m FROM Movies m WHERE m.mYear = :mYear")
    , @NamedQuery(name = "Movies.findByMCast", query = "SELECT m FROM Movies m WHERE m.mCast = :mCast")
    , @NamedQuery(name = "Movies.findByMDirector", query = "SELECT m FROM Movies m WHERE m.mDirector = :mDirector")
    , @NamedQuery(name = "Movies.findByMStory", query = "SELECT m FROM Movies m WHERE m.mStory = :mStory")
    , @NamedQuery(name = "Movies.findByMPrice", query = "SELECT m FROM Movies m WHERE m.mPrice = :mPrice")
    , @NamedQuery(name = "Movies.findAllBetweenRange", query = "SELECT m FROM Movies m WHERE m.mId BETWEEN :startID AND :endID")})
public class Movies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "M_ID")
    private Long mId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "M_TITLE")
    private String mTitle;
    @Size(max = 50)
    @Column(name = "M_CATEGORY")
    private String mCategory;
    @Size(max = 4)
    @Column(name = "M_YEAR")
    private String mYear;
    @Size(max = 4000)
    @Column(name = "M_CAST")
    private String mCast;
    @Size(max = 4000)
    @Column(name = "M_DIRECTOR")
    private String mDirector;
    @Size(max = 4000)
    @Column(name = "M_STORY")
    private String mStory;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "M_PRICE")
    private BigDecimal mPrice;

    public Movies() {
    }

    public Movies(Long mId) {
        this.mId = mId;
    }

    public Movies(Long mId, String mTitle) {
        this.mId = mId;
        this.mTitle = mTitle;
    }

    public Long getMId() {
        return mId;
    }

    public void setMId(Long mId) {
        this.mId = mId;
    }

    public String getMTitle() {
        return mTitle;
    }

    public void setMTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getMCategory() {
        return mCategory;
    }

    public void setMCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    public String getMYear() {
        return mYear;
    }

    public void setMYear(String mYear) {
        this.mYear = mYear;
    }

    public String getMCast() {
        return mCast;
    }

    public void setMCast(String mCast) {
        this.mCast = mCast;
    }

    public String getMDirector() {
        return mDirector;
    }

    public void setMDirector(String mDirector) {
        this.mDirector = mDirector;
    }

    public String getMStory() {
        return mStory;
    }

    public void setMStory(String mStory) {
        this.mStory = mStory;
    }

    public BigDecimal getMPrice() {
        return mPrice;
    }

    public void setMPrice(BigDecimal mPrice) {
        this.mPrice = mPrice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mId != null ? mId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movies)) {
            return false;
        }
        Movies other = (Movies) object;
        if ((this.mId == null && other.mId != null) || (this.mId != null && !this.mId.equals(other.mId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "storemovies.entities.Movies[ mId=" + mId + " ]";
    }
    
}
