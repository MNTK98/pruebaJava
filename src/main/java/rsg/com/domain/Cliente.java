package rsg.com.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteid;
	
	private Boolean clienteactivo;
	
	private String clientenombre;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "clientefechacreacion", updatable = false)
	private Date clientefechacreacion;
	
	@UpdateTimestamp
	@Column(name = "clientefechamodificacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date clientefechamodificacion;
	
	
	public Long getClienteid() {
		return clienteid;
	}


	public void setClienteid(Long clienteid) {
		this.clienteid = clienteid;
	}


	public Boolean getClienteactivo() {
		return clienteactivo;
	}


	public void setClienteactivo(Boolean clienteactivo) {
		this.clienteactivo = clienteactivo;
	}


	public String getClientenombre() {
		return clientenombre;
	}


	public void setClientenombre(String clientenombre) {
		this.clientenombre = clientenombre;
	}


	public Date getClientefechacreacion() {
		return clientefechacreacion;
	}


	public void setClientefechacreacion(Date clientefechacreacion) {
		this.clientefechacreacion = clientefechacreacion;
	}


	public Date getClientefechamodificacion() {
		return clientefechamodificacion;
	}


	public void setClientefechamodificacion(Date clientefechamodificacion) {
		this.clientefechamodificacion = clientefechamodificacion;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
