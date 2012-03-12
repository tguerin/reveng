/**
 *
 * My private copyright 2
 *
 */
package fr.xebia.reveng.model;

// Generated test Mar 12, 2012 10:52:47 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.xebia.reveng.model.common.IPojoWithCode;
import fr.xebia.reveng.model.store.StoreHasProduct;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "T_PRODUCT", schema = "PUBLIC", catalog = "PUBLIC")
public class Product implements IPojoWithCode, java.io.Serializable {

    private int id;
    private String code;
    private String name;
    private Set<StoreHasProduct> storeHasProducts = new HashSet<StoreHasProduct>(
	    0);

    public Product() {
    }

    public Product(int id, String code, String name) {
	this.id = id;
	this.code = code;
	this.name = name;
    }

    public Product(int id, String code, String name,
	    Set<StoreHasProduct> storeHasProducts) {
	this.id = id;
	this.code = code;
	this.name = name;
	this.storeHasProducts = storeHasProducts;
    }

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    public int getId() {
	return this.id;
    }

    public void setId(int id) {
	this.id = id;
    }

    @Column(name = "CODE", nullable = false, length = 50)
    public String getCode() {
	return this.code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    @Column(name = "NAME", nullable = false, length = 50)
    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY, mappedBy = "product")
    public Set<StoreHasProduct> getStoreHasProducts() {
	return this.storeHasProducts;
    }

    public void setStoreHasProducts(Set<StoreHasProduct> storeHasProducts) {
	this.storeHasProducts = storeHasProducts;
    }

}
