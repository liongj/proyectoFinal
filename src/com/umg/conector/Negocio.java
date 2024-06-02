package com.umg.conector;

public class Negocio {
	int Idproducto;
	String cliente;
	String direccion_de_pedido;
	String estado_de_pedido;
	MariaDBConection uri = new MariaDBConection();
	
	public boolean Agregara() {
		if(uri.Agregara(this)) {
			return true;
	 }else {
		 return false;
	 }
	}
	public boolean Eliminar() {
		if(uri.Eliminar(this)) {
			return true;
	 }else {
		 return false;
	 }
		}
	
	public boolean Editar() {
		if(uri.Editar(this)) {
			return true;
	 }else {
		 return false;
	 }
		}
	public boolean Buscara() {
		if(uri.Buscara(this)) {
			return true;
	 }else {
		 return false;
	 }
		}
	
	
	public int getIdproducto() {
		return Idproducto;
	}
	public void setIdproducto(int idproducto) {
		Idproducto = idproducto;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getDireccion_de_pedido() {
		return direccion_de_pedido;
	}
	public void setDireccion_de_pedido(String direccion_de_pedido) {
		this.direccion_de_pedido = direccion_de_pedido;
	}
	public String getEstado_de_pedido() {
		return estado_de_pedido;
	}
	public void setEstado_de_pedido(String estado_de_pedido) {
		this.estado_de_pedido = estado_de_pedido;
	}

  }


