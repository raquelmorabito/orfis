package br.com.orfis.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "evento_atendimento")
public class EventoAtendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String idPaciente;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoEventoAtendimento tipoEvento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUnidadeSaude tipoUnidade;

    @Column(nullable = false)
    private String identificadorUnidade;

    @Column(nullable = false)
    private LocalDateTime dataHoraEvento;

    private String detalhes;

    public Long getId() {
        return id;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public TipoEventoAtendimento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEventoAtendimento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public TipoUnidadeSaude getTipoUnidade() {
        return tipoUnidade;
    }

    public void setTipoUnidade(TipoUnidadeSaude tipoUnidade) {
        this.tipoUnidade = tipoUnidade;
    }

    public String getIdentificadorUnidade() {
        return identificadorUnidade;
    }

    public void setIdentificadorUnidade(String identificadorUnidade) {
        this.identificadorUnidade = identificadorUnidade;
    }

    public LocalDateTime getDataHoraEvento() {
        return dataHoraEvento;
    }

    public void setDataHoraEvento(LocalDateTime dataHoraEvento) {
        this.dataHoraEvento = dataHoraEvento;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
}
