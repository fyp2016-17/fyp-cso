package com.test.backend.persistence.domain.backend;

import com.test.enums.PlanEnum;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Abubakr on 4/10/2017.
 */

@Entity
public class Plan implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    private int id;

    private String name;

    //    Constructor ..
    public Plan(){

    }

    public Plan(PlanEnum planEnum){
        this.id = planEnum.getId();
        this.name = planEnum.getPlanName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plan plan = (Plan) o;

        return id == plan.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
