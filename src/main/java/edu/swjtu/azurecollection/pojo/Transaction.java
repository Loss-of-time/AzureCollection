package edu.swjtu.azurecollection.pojo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "collectible_id", nullable = false)
    private DigitalCollectible collectible;

    @ManyToOne
    @JoinColumn(name = "buyer_id", nullable = false)
    private User buyer;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;

    private LocalDateTime transactionDate;

    @Column(nullable = false)
    private String transactionType; // e.g., sale, transfer, gift

    private Double amount;

    // Getters and Setters

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public DigitalCollectible getCollectible() {
        return collectible;
    }

    public void setCollectible(DigitalCollectible collectible) {
        this.collectible = collectible;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", collectible=" + collectible +
                ", buyer=" + buyer +
                ", seller=" + seller +
                ", transactionDate=" + transactionDate +
                ", transactionType='" + transactionType + '\'' +
                ", amount=" + amount +
                '}';
    }
}
