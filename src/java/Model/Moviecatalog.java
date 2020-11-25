/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thead
 */
@Entity
@Table(name = "MOVIECATALOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moviecatalog.findAll", query = "SELECT m FROM Moviecatalog m"),
    @NamedQuery(name = "Moviecatalog.findByMovieId", query = "SELECT m FROM Moviecatalog m WHERE m.movieId = :movieId"),
    @NamedQuery(name = "Moviecatalog.findByMovieName", query = "SELECT m FROM Moviecatalog m WHERE m.movieName = :movieName"),
    @NamedQuery(name = "Moviecatalog.findByRate", query = "SELECT m FROM Moviecatalog m WHERE m.rate = :rate"),
    @NamedQuery(name = "Moviecatalog.findByYearNo", query = "SELECT m FROM Moviecatalog m WHERE m.yearNo = :yearNo"),
    @NamedQuery(name = "Moviecatalog.findByPrice", query = "SELECT m FROM Moviecatalog m WHERE m.price = :price")})
public class Moviecatalog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MOVIE_ID")
    private Integer movieId;
    @Size(max = 255)
    @Column(name = "MOVIE_NAME")
    private String movieName;
    @Size(max = 5)
    @Column(name = "RATE")
    private String rate;
    @Size(max = 4)
    @Column(name = "YEAR_NO")
    private String yearNo;
    @Column(name = "PRICE")
    private Double price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movieId")
    private Collection<Shoppingcart> shoppingcartCollection;

    public Moviecatalog() {
    }

    public Moviecatalog(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getYearNo() {
        return yearNo;
    }

    public void setYearNo(String yearNo) {
        this.yearNo = yearNo;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @XmlTransient
    public Collection<Shoppingcart> getShoppingcartCollection() {
        return shoppingcartCollection;
    }

    public void setShoppingcartCollection(Collection<Shoppingcart> shoppingcartCollection) {
        this.shoppingcartCollection = shoppingcartCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieId != null ? movieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moviecatalog)) {
            return false;
        }
        Moviecatalog other = (Moviecatalog) object;
        if ((this.movieId == null && other.movieId != null) || (this.movieId != null && !this.movieId.equals(other.movieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Moviecatalog[ movieId=" + movieId + " ]";
    }
    
}
