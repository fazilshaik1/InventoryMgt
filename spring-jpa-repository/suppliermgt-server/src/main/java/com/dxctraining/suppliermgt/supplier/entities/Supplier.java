package com.dxctraining.suppliermgt.supplier.entities;


import javax.persistence.*;

@Entity
public class Supplier {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    
    private String password;


    public Supplier() {

    }

    public Supplier(String name, String password) {
         this.name= name;
         this.password = password;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Supplier that = (Supplier) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
