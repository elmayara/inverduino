package Modelo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="Plantas")
public class planta {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id=0;
	private Date fecha;
	private double hora;
	private Integer temperatura;
	private Integer humedad;
	
	public planta(Integer id, Date fecha, double hora, Integer temperatura, Integer humedad) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.temperatura = temperatura;
		this.humedad = humedad;
	}
	
	public planta() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getHora() {
		return hora;
	}
	public void setHora(double hora) {
		this.hora = hora;
	}
	public Integer getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Integer temperatura) {
		this.temperatura = temperatura;
	}
	public Integer getHumedad() {
		return humedad;
	}
	public void setHumedad(Integer humedad) {
		this.humedad = humedad;
	}
	
	
}
