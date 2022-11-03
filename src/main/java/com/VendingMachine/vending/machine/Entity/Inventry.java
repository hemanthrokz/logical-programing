package com.VendingMachine.vending.machine.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="customer")
public class Inventry {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="productid")
    private int productid;

    @Column(name="name")
   private String name;

    @Column(name="productinventrycount")
    private int productinventrycount;

    @Column(name="productprice")
    private Double productprice;


    public Inventry(){

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getProductinventrycount() {
        return productinventrycount;
    }

    public void setProductinventrycount(int productinventrycount) {
        this.productinventrycount = productinventrycount;
    }

    public Double getProductprice() {
        return productprice;
    }

    public void setProductprice(Double productprice) {
        this.productprice = productprice;
    }

    public Inventry(String name, int productid, int productinventrycount, Double productprice) {
        this.name = name;
        this.productid = productid;
        this.productinventrycount = productinventrycount;
        this.productprice = productprice;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventry that = (Inventry) o;
        return productid == that.productid && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, productid);
    }


    @Override
    public String toString() {
        return
                "Product name='" + name +
                ", productid=" + productid +
                ", productinventrycount=" + productinventrycount +
                ", productprice=" + productprice +"\n"
                ;
    }


}