package edu.swjtu.azurecollection.pojo;

import jakarta.persistence.*;

@Table(name="Tansaction")
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transaction_Id")
    private Long transactionId;


    @Column(name = "collectible_id")
    private Long collectibleId;

    @Column(name = "buyer_id")
    private Long buyerId;

    @Column(name = "seller_id")
    private Long sellerId;

    @Column(name = "transaction_time", nullable = false)
    private String transactionDate;


    // 新增的两个布尔型变量
    @Column(name = "if_read_by_buyer")
    private Integer ifReadByBuyer;

    @Column(name = "if_read_by_seller")
    private Integer ifReadBySeller;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getCollectibleId() {
        return collectibleId;
    }

    public void setCollectibleId(Long collectibleId) {
        this.collectibleId = collectibleId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public int getIfReadByBuyer() {
        return ifReadByBuyer;
    }

    public void setIfReadByBuyer(int ifReadByBuyer) {
        this.ifReadByBuyer = ifReadByBuyer;
    }

    public int getIfReadBySeller() {
        return ifReadBySeller;
    }

    public void setIfReadBySeller(int ifReadBySeller) {
        this.ifReadBySeller = ifReadBySeller;
    }

    public void setIfReadByBuyer(Integer ifReadByBuyer) {
        this.ifReadByBuyer = ifReadByBuyer;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setIfReadBySeller(Integer ifReadBySeller) {
        this.ifReadBySeller = ifReadBySeller;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", collectibleId=" + collectibleId +
                ", buyerId=" + buyerId +
                ", sellerId=" + sellerId +
                ", transactionDate=" + transactionDate +
                ", ifReadByBuyer=" + ifReadByBuyer +
                ", ifReadBySeller=" + ifReadBySeller +
                '}';
    }
}
