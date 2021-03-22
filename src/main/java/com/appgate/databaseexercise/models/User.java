package com.appgate.databaseexercise.models;

import com.opencsv.bean.CsvBindByPosition;

public class User {
	@CsvBindByPosition(position = 0)
	private String idEmpleado;
	@CsvBindByPosition(position = 1)
	private String nombre;
	@CsvBindByPosition(position = 2)
	private String meses;
	@CsvBindByPosition(position = 3)
	private String salario;

	public String getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMeses() {
		return meses;
	}

	public void setMeses(String meses) {
		this.meses = meses;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public String insertSQL() {
		 return "insert into empleado values(" +  getIdEmpleado() +",'" + getNombre() + "'," + getMeses() + "," + getSalario() +")";
	}

	@Override
	public String toString() {
		return "User [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", meses=" + meses + ", salario=" + salario
				+ "]";
	}
	
	

}
