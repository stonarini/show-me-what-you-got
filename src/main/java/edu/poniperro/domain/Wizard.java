package edu.poniperro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "t_wizards")
public class Wizard extends PanacheEntityBase {

    @Id
    @NotNull
    @Column(name = "wizard_name")
    private String name;

    @Column(name = "wizard_dexterity")
    private Integer dexterity;

    @Column(name = "wizard_person")
    @Enumerated(EnumType.STRING)
    private Person person;

    public Wizard() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDexterity() {
        return this.dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", dexterity='" + getDexterity() + "'" +
                ", person='" + getPerson() + "'" +
                "}";
    }

}