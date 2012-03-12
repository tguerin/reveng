/**
*
* My private copyright 2
*
*/
package fr.xebia.reveng.model.store;
// Generated test Feb 27, 2012 12:10:34 AM by Hibernate Tools 3.4.0.CR1


import fr.xebia.reveng.model.common.IPojoWithCode;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Store generated by hbm2java
 */
@Entity
@Table(name="T_STORE"
    ,schema="PUBLIC"
    ,catalog="PUBLIC"
)
public class Store  implements IPojoWithCode,java.io.Serializable {


     private int id;
     private String code;
     private String libelle;
     private Set<StoreHasProduct> storeHasProducts = new HashSet<StoreHasProduct>(0);

    public Store() {
    }

	
    public Store(int id, String code, String libelle) {
        this.id = id;
        this.code = code;
        this.libelle = libelle;
    }
    public Store(int id, String code, String libelle, Set<StoreHasProduct> storeHasProducts) {
       this.id = id;
       this.code = code;
       this.libelle = libelle;
       this.storeHasProducts = storeHasProducts;
    }
   
     @Id 

    
    @Column(name="ID", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="CODE", nullable=false, length=50)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    
    @Column(name="NAME", nullable=false, length=50)
    public String getLibelle() {
        return this.libelle;
    }
    
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="store")
    public Set<StoreHasProduct> getStoreHasProducts() {
        return this.storeHasProducts;
    }
    
    public void setStoreHasProducts(Set<StoreHasProduct> storeHasProducts) {
        this.storeHasProducts = storeHasProducts;
    }




}


