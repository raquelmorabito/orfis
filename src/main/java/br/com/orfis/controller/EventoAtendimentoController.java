package br.com.orfis.controller;

import br.com.orfis.dto.RequisicaoCriarEventoAtendimento;
import br.com.orfis.dto.RespostaEventoAtendimento;
import br.com.orfis.service.EventoAtendimentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EventoAtendimentoController {

    private final EventoAtendimentoService service;

    public EventoAtendimentoController(EventoAtendimentoService service) {
        this.service = service;
    }

    @PostMapping("/eventos")
    @ResponseStatus(HttpStatus.CREATED)
    public RespostaEventoAtendimento criar(@Valid @RequestBody RequisicaoCriarEventoAtendimento requisicao) {
        return service.criar(requisicao);
    }

    @GetMapping("/pacientes/{idPaciente}/linha-do-tempo")
    public List<RespostaEventoAtendimento> linhaDoTempo(@PathVariable String idPaciente) {
        return service.linhaDoTempo(idPaciente);
    }

    @GetMapping("/pacientes/{idPaciente}/status-atual")
    public RespostaEventoAtendimento statusAtual(@PathVariable String idPaciente) {
        return service.statusAtual(idPaciente);
    }
}
