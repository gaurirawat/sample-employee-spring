package com.example.sampleemployeespring.beans;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table
public class Cabin {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer roomNo;

    @Column
    private int floorNo;

    @OneToOne(cascade ={CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "emp_id")
    @JsonIgnoreProperties(value = {"cabin", "hibernateLazyInitializer"}, allowSetters = true)
    private Employee employee;

    public Cabin() {
    }

    public Cabin(Integer roomNo, int floorNo) {
        this.roomNo = roomNo;
        this.floorNo = floorNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
