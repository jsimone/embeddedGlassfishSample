/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author caroljmcdonald
 */
@Entity
@Table(name = "item")
@NamedQueries({@NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"), @NamedQuery(name = "Item.findById", query = "SELECT i FROM Item i WHERE i.id = :id"), @NamedQuery(name = "Item.findByProductId", query = "SELECT i FROM Item i WHERE i.productId = :productId"), @NamedQuery(name = "Item.findByName", query = "SELECT i FROM Item i WHERE i.name = :name"), @NamedQuery(name = "Item.findByDescription", query = "SELECT i FROM Item i WHERE i.description = :description"), @NamedQuery(name = "Item.findByImageurl", query = "SELECT i FROM Item i WHERE i.imageurl = :imageurl"), @NamedQuery(name = "Item.findByImagethumburl", query = "SELECT i FROM Item i WHERE i.imagethumburl = :imagethumburl"), @NamedQuery(name = "Item.findByPrice", query = "SELECT i FROM Item i WHERE i.price = :price"), @NamedQuery(name = "Item.findByAddressId", query = "SELECT i FROM Item i WHERE i.addressId = :addressId")})
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "product_id")
    private int productId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Column(name = "imageurl")
    private String imageurl;
    @Column(name = "imagethumburl")
    private String imagethumburl;
    @Basic(optional = false)
    @Column(name = "price")
    private BigDecimal price;
    @Basic(optional = false)
    @Column(name = "address_id")
    private int addressId;

    public Item() {
    }

    public Item(Integer id) {
        this.id = id;
    }

    public Item(Integer id, int productId, String name, String description, BigDecimal price, int addressId) {
        this.id = id;
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.addressId = addressId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getImagethumburl() {
        return imagethumburl;
    }

    public void setImagethumburl(String imagethumburl) {
        this.imagethumburl = imagethumburl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
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
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Item[id=" + id + "]";
    }

}
