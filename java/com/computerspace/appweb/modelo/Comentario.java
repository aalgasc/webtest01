package com.computerspace.appweb.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comentarios")
public class Comentario {

		
		@Id
		@GeneratedValue (strategy=GenerationType.IDENTITY)
		private long idcomentario;
		@Column
		private String comentario;
		
		
		@ManyToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="idclientes")
		private Cliente cliente;
		
		public long getIdcomentario() {
			return idcomentario;
		}
		public void setIdcomentario(long idcomentario) {
			this.idcomentario = idcomentario;
		}
		public String getComentario() {
			return comentario;
		}
		public void setComentario(String comentario) {
			this.comentario = comentario;
		}
		public Comentario(long idcomentario, String comentario) {
			super();
			this.idcomentario = idcomentario;
			this.comentario = comentario;
		}
		public Comentario() {
			super();
		}
		public Comentario(String comentario) {
			// TODO Auto-generated constructor stub
		}
		public Cliente getCliente() {
			return cliente;
		}
		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		
		
}
