package com.yhon.ecommerce.entitys;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "ordenes")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numero;
    private Date fechaCreacion;
    private Date fechaResivida;
    private double total;
    @ManyToOne
    private Usuario usuario;

    @OneToOne(mappedBy = "orden")
    private DetalleOrden detalle;

    public Orden() {
    }

    public Orden(Integer id, String numero, Date fechaCreacion, Date fechaResivida, double total, Usuario usuario) {
        this.id = id;
        this.numero = numero;
        this.fechaCreacion = fechaCreacion;
        this.fechaResivida = fechaResivida;
        this.total = total;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaResivida() {
        return fechaResivida;
    }

    public void setFechaResivida(Date fechaResivida) {
        this.fechaResivida = fechaResivida;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public DetalleOrden getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleOrden detalle) {
        this.detalle = detalle;
    }
}
