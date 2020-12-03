package co.edu.udea.basededatos.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name= "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name= "costo", nullable = false, length = 50)
    private BigDecimal costo;

    @Column(name="observacion", length = 250)
    private String observacion;

    @Column(name="disponible", nullable=false)
    private Boolean disponible;

    @Column(name="fk_administrador", nullable=false)
    private Long fk_administrador;

    // relationships

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_administrador", insertable = false, updatable = false)
    private Usuario administrador;

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Long getFk_administrador() {
        return fk_administrador;
    }

    public void setFk_administrador(Long fk_administrador) {
        this.fk_administrador = fk_administrador;
    }

    public Usuario getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Usuario administrador) {
        this.administrador = administrador;
    }
}
