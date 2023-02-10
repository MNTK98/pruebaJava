package rsg.com.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;


@Data
@Entity
@Table(name = "consignatario")
public class Consignatario implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consignatarioid;
	
	
    private Long clienteid;
    
    private Boolean consignatarioactivo;
	
	private String consignatarionombre;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "consignatariofechacreacion", updatable = false)
	private Date consignatariofechacreacion;
	
	@UpdateTimestamp
	@Column(name = "consignatariofechamodificacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date consignatariofechamodificacion;
	
	@OneToOne
	@JoinColumn(name = "clienteid", insertable = false, updatable = false)
	private Cliente cliente;
	
	
	public Long getConsignatarioid() {
		return consignatarioid;
	}


	public void setConsignatarioid(Long consignatarioid) {
		this.consignatarioid = consignatarioid;
	}


	public Long getClienteid() {
		return clienteid;
	}


	public void setClienteid(Long clienteid) {
		this.clienteid = clienteid;
	}


	public Boolean getConsignatarioactivo() {
		return consignatarioactivo;
	}


	public void setConsignatarioactivo(Boolean consignatarioactivo) {
		this.consignatarioactivo = consignatarioactivo;
	}


	public String getConsignatarionombre() {
		return consignatarionombre;
	}


	public void setConsignatarionombre(String consignatarionombre) {
		this.consignatarionombre = consignatarionombre;
	}


	public Date getConsignatariofechacreacion() {
		return consignatariofechacreacion;
	}


	public void setConsignatariofechacreacion(Date consignatariofechacreacion) {
		this.consignatariofechacreacion = consignatariofechacreacion;
	}


	public Date getConsignatariofechamodificacion() {
		return consignatariofechamodificacion;
	}


	public void setConsignatariofechamodificacion(Date consignatariofechamodificacion) {
		this.consignatariofechamodificacion = consignatariofechamodificacion;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	/**
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
