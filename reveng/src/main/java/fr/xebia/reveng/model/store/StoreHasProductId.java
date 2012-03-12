/**
*
* My private copyright 2
*
*/
package fr.xebia.reveng.model.store;
// Generated test Feb 27, 2012 12:10:34 AM by Hibernate Tools 3.4.0.CR1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * StoreHasProductId generated by hbm2java
 */
@Embeddable
public class StoreHasProductId  implements java.io.Serializable {


     private int store;
     private int product;

    public StoreHasProductId() {
    }

    public StoreHasProductId(int store, int product) {
       this.store = store;
       this.product = product;
    }
   


    @Column(name="STORE", nullable=false)
    public int getStore() {
        return this.store;
    }
    
    public void setStore(int store) {
        this.store = store;
    }


    @Column(name="PRODUCT", nullable=false)
    public int getProduct() {
        return this.product;
    }
    
    public void setProduct(int product) {
        this.product = product;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof StoreHasProductId) ) return false;
		 StoreHasProductId castOther = ( StoreHasProductId ) other; 
         
		 return (this.getStore()==castOther.getStore())
 && (this.getProduct()==castOther.getProduct());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getStore();
         result = 37 * result + this.getProduct();
         return result;
   }   


}


