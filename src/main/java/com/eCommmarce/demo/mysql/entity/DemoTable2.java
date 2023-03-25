package com.eCommmarce.demo.mysql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="demo_tbl2")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@NamedStoredProcedureQuery(name= "demo", procedureName = "insertdata1",parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class,name = "data"),	
		@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class,name = "dataName"),
		@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class,name = "dataDemoName")
}

		)
public class DemoTable2 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@PersistenceContext(unitName = "entityManagerFactory")
	private int Id;
	
	private String demoName;
	
	private String name;
	
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
		return demoName;
	}

	public void setDemoName(String demoName) {
		this.demoName = demoName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	private String time;

}
