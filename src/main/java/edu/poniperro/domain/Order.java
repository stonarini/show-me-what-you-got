package edu.poniperro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "t_orders")
public class Order extends PanacheEntityBase {

    @Id
    @Column(name = "ord_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ord_wizard")
    private Wizard wizard;

    @ManyToOne
    @JoinColumn(name = "ord_item")
    private MagicalItem item;

    public Order() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Wizard getWizard() {
        return this.wizard;
    }

    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
    }

    public MagicalItem getItem() {
        return this.item;
    }

    public void setItem(MagicalItem item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", wizard='" + getWizard() + "'" +
                ", item='" + getItem() + "'" +
                "}";
    }

}