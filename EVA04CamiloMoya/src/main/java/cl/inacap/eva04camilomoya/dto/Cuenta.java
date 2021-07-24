/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.eva04camilomoya.dto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Chalabera
 */
@Entity
@Table(name = "CUENTA")
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c"),
    @NamedQuery(name = "Cuenta.findByNumerocta", query = "SELECT c FROM Cuenta c WHERE c.numerocta = :numerocta"),
    @NamedQuery(name = "Cuenta.findBySaldo", query = "SELECT c FROM Cuenta c WHERE c.saldo = :saldo"),
    @NamedQuery(name = "Cuenta.findByClavetransaccion", query = "SELECT c FROM Cuenta c WHERE c.clavetransaccion = :clavetransaccion"),
    @NamedQuery(name = "Cuenta.findBySaldolineacredito", query = "SELECT c FROM Cuenta c WHERE c.saldolineacredito = :saldolineacredito"),
    @NamedQuery(name = "Cuenta.findBySaldolineacreditousado", query = "SELECT c FROM Cuenta c WHERE c.saldolineacreditousado = :saldolineacreditousado"),
    @NamedQuery(name = "Cuenta.findByEstado", query = "SELECT c FROM Cuenta c WHERE c.estado = :estado")})
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numerocta")
    private Integer numerocta;
    @Column(name = "saldo")
    private Integer saldo;
    @Size(max = 100)
    @Column(name = "clavetransaccion")
    private String clavetransaccion;
    @Column(name = "saldolineacredito")
    private Integer saldolineacredito;
    @Column(name = "saldolineacreditousado")
    private Integer saldolineacreditousado;
    @Column(name = "estado")
    private Integer estado;
    @OneToMany(mappedBy = "cuentaFK")
    private List<Movimientos> movimientosList;
    @JoinColumn(name = "clienteFK", referencedColumnName = "rut")
    @ManyToOne(cascade = CascadeType.ALL)
    private Cliente clienteFK;

    public Cuenta() {
    }

    public Cuenta(Integer numerocta, Integer saldo, String clavetransaccion, Integer saldolineacredito, Integer saldolineacreditousado, Integer estado, List<Movimientos> movimientosList) {
        this.numerocta = numerocta;
        this.saldo = saldo;
        this.clavetransaccion = clavetransaccion;
        this.saldolineacredito = saldolineacredito;
        this.saldolineacreditousado = saldolineacreditousado;
        this.estado = estado;
        this.movimientosList = movimientosList;
    }
    
    public Cuenta(Integer numerocta) {
        this.numerocta = numerocta;
    }

    public Integer getNumerocta() {
        return numerocta;
    }

    public void setNumerocta(Integer numerocta) {
        this.numerocta = numerocta;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public String getClavetransaccion() {
        return clavetransaccion;
    }

    public void setClavetransaccion(String clavetransaccion) {
        this.clavetransaccion = clavetransaccion;
    }

    public Integer getSaldolineacredito() {
        return saldolineacredito;
    }

    public void setSaldolineacredito(Integer saldolineacredito) {
        this.saldolineacredito = saldolineacredito;
    }

    public Integer getSaldolineacreditousado() {
        return saldolineacreditousado;
    }

    public void setSaldolineacreditousado(Integer saldolineacreditousado) {
        this.saldolineacreditousado = saldolineacreditousado;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public List<Movimientos> getMovimientosList() {
        return movimientosList;
    }

    public void setMovimientosList(List<Movimientos> movimientosList) {
        this.movimientosList = movimientosList;
    }

    public Cliente getClienteFK() {
        return clienteFK;
    }

    public void setClienteFK(Cliente clienteFK) {
        this.clienteFK = clienteFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numerocta != null ? numerocta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.numerocta == null && other.numerocta != null) || (this.numerocta != null && !this.numerocta.equals(other.numerocta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numerocta=" + numerocta + ", saldo=" + saldo + ", clavetransaccion=" + clavetransaccion + ", saldolineacredito=" + saldolineacredito + ", saldolineacreditousado=" + saldolineacreditousado + ", clienteFK=" + clienteFK + '}';
    }

    

    
    
}
