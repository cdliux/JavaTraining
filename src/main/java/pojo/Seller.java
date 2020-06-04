package pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.time.LocalDate;

public class Seller {
    @JsonProperty("SellerID")
    private String sellerId;

    private String sellerName;

    @JsonUnwrapped()
    private Address sellerAddress;

    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate inDate;

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Address getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(Address sellerAddress) {
        this.sellerAddress = sellerAddress;
    }


    public Seller(String sellerId,String sellerName){
        this.setSellerId(sellerId);
        this.setSellerName(sellerName);
    }

    public LocalDate getInDate() {
        return inDate;
    }

    public void setInDate(LocalDate inDate) {
        this.inDate = inDate;
    }

    public Seller(String sellerId, String sellerName, String address1){
        this.setSellerId(sellerId);
        this.setSellerName(sellerName);
        Address address = new Address();
        address.setAddress1(address1);
        this.setSellerAddress(address);
    }

    public Seller(){

    }
}
