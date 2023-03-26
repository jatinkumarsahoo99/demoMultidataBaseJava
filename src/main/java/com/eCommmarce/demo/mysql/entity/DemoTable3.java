package com.eCommmarce.demo.mysql.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="demo_tbl3")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DemoTable3 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@PersistenceContext(unitName = "entityManagerFactory")
	private int Id;
	
	private String demoNameAll;
	
	private String name;
	
	
	@OneToMany(targetEntity = DemoTable2.class,cascade = CascadeType.ALL )
	@JoinColumn(name="cp_fk",referencedColumnName = "Id")
	private List<DemoTable2> demoTabl2;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDemoName() {
		return demoNameAll;
	}

	public void setDemoName(String demoName) {
		this.demoNameAll = demoName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	private String time;

}

