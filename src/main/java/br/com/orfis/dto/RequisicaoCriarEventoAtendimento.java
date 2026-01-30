package br.com.orfis.dto;

import br.com.orfis.model.TipoEventoAtendimento;
import br.com.orfis.model.TipoUnidadeSaude;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class RequisicaoCriarEventoAtendimento {

    @NotNull
    private String idPaciente;

    @NotNull
    private TipoEventoAtendimento tipoEvento;

    @NotNull
    private TipoUnidadeSaude tipoUnidade;

    @NotBlank
    private String identificadorUnidade;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "pt-BR")
    private LocalDateTime dataHoraEvento;

    private String detalhes;

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
