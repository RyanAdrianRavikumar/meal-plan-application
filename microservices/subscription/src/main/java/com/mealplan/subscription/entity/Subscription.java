package com.mealplan.subscription.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "subscription")
public class Subscription {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "subscription_id")
    private int id;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "plan_id")
    private int planId;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "status")
    private String status;

    public Subscription(){
        //JPA constructor
    }

    public Subscription(int id, int customerId, int planId, Date startDate, Date endDate, String status) {
        this.id = id;
        this.customerId = customerId;
        this.planId = planId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
