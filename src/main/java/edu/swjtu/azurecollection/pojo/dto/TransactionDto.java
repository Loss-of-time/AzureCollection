package edu.swjtu.azurecollection.pojo.dto;


import java.time.LocalDateTime;

public class TransactionDto {
    private Long transactionId;

    private Long collectibleId;

    private Long buyerId;

    private Long sellerId;

    private LocalDateTime transactionDate;


    // 新增的两个布尔型变量
    private Integer ifReadByBuyer;

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

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
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

    @Override
    public String toString() {
        return "TransactionDto{" +
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
