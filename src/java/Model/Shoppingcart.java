/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thead
 */
@Entity
@Table(name = "SHOPPINGCART")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shoppingcart.findAll", query = "SELECT s FROM Shoppingcart s"),
    @NamedQuery(name = "Shoppingcart.findByItemId", query = "SELECT s FROM Shoppingcart s WHERE s.itemId = :itemId"),
    @NamedQuery(name = "Shoppingcart.findByQuantity", query = "SELECT s FROM Shoppingcart s WHERE s.quantity = :quantity"),
    @NamedQuery(name = "Shoppingcart.findByMovieId", query = "SELECT s FROM Shoppingcart s WHERE s.movieId = :movieId")})
public class Shoppingcart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ITEM_ID")
    private Integer itemId;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @JoinColumn(name = "MOVIE_ID", referencedColumnName = "MOVIE_ID")
    @ManyToOne(optional = false)
    private Moviecatalog movieId;

    public Shoppingcart() {
    }

    public Shoppingcart(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Moviecatalog getMovieId() {
        return movieId;
    }

    public void setMovieId(Moviecatalog movieId) {
        this.movieId = movieId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shoppingcart)) {
            return false;
        }
        Shoppingcart other = (Shoppingcart) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Shoppingcart[ itemId=" + itemId + " ]";
    }
    
}
