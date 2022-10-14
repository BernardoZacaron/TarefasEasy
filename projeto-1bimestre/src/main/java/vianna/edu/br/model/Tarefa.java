/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vianna.edu.br.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Aluno
 */

@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 500)
    @Lob
    private String descricao;
    private boolean concluida;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPlanejada;
    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFinalizada;
    private int horasGastas;
    
    @ManyToOne()
    private Categoria categoria;
    @ManyToOne()
    private Usuario usuario;

    public Tarefa(int id, String drescricao, boolean concluida, Date dataPlanejada, Date dataFinalizada, int horasGastas) {
        this.id = id;
        this.descricao = drescricao;
        this.concluida = concluida;
        this.dataPlanejada = dataPlanejada;
        this.dataFinalizada = dataFinalizada;
        this.horasGastas = horasGastas;
    }

    public Tarefa(int id, String drescricao, boolean concluida, Date dataPlanejada, Date dataFinalizada, int horasGastas, Categoria categoria, Usuario usuario) {
        this.id = id;
        this.descricao = drescricao;
        this.concluida = concluida;
        this.dataPlanejada = dataPlanejada;
        this.dataFinalizada = dataFinalizada;
        this.horasGastas = horasGastas;
        this.categoria = categoria;
        this.usuario = usuario;
    }
    
    

    public Tarefa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public Date getDataPlanejada() {
        return dataPlanejada;
    }

    public void setDataPlanejada(Date dataPlanejada) {
        this.dataPlanejada = dataPlanejada;
    }

    public Date getDataFinalizada() {
        return dataFinalizada;
    }

    public void setDataFinalizada(Date dataFinalizada) {
        this.dataFinalizada = dataFinalizada;
    }

    public int getHorasGastas() {
        return horasGastas;
    }

    public void setHorasGastas(int horasGastas) {
        this.horasGastas = horasGastas;
    }
    
    
}
