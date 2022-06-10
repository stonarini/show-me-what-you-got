package edu.poniperro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "t_items")
public class MagicalItem extends PanacheEntityBase {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "item_name")
    private String name;

    @Column(name = "item_quality")
    private Integer quality;

    @Column(name = "item_type")
    private String type;

    public MagicalItem() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuality() {
        return this.quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", quality='" + getQuality() + "'" +
                ", type='" + getType() + "'" +
                "}";
    }

}