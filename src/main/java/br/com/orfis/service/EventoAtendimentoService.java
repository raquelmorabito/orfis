package br.com.orfis.service;

import br.com.orfis.dto.RequisicaoCriarEventoAtendimento;
import br.com.orfis.dto.RespostaEventoAtendimento;
import br.com.orfis.model.EventoAtendimento;
import br.com.orfis.repository.EventoAtendimentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventoAtendimentoService {

    private final EventoAtendimentoRepository repository;

    public EventoAtendimentoService(EventoAtendimentoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public RespostaEventoAtendimento criar(RequisicaoCriarEventoAtendimento requisicao) {
        EventoAtendimento e = new EventoAtendimento();
        e.setIdPaciente(requisicao.getIdPaciente());
        e.setTipoEvento(requisicao.getTipoEvento());
        e.setTipoUnidade(requisicao.getTipoUnidade());
        e.setIdentificadorUnidade(requisicao.getIdentificadorUnidade());
        e.setDataHoraEvento(requisicao.getDataHoraEvento());
        e.setDetalhes(requisicao.getDetalhes());

        EventoAtendimento salvo = repository.save(e);
        return paraResposta(salvo);
    }

    @Transactional(readOnly = true)
    public List<RespostaEventoAtendimento> linhaDoTempo(String idPaciente) {
        return repository.findByIdPacienteOrderByDataHoraEventoAsc(idPaciente).stream()
                .map(this::paraResposta)
                .toList();
    }

    @Transactional(readOnly = true)
    public RespostaEventoAtendimento statusAtual(String idPaciente) {
        return repository.findTop1ByIdPacienteOrderByDataHoraEventoDesc(idPaciente)
                .map(this::paraResposta)
                .orElse(null);
    }

    private RespostaEventoAtendimento paraResposta(EventoAtendimento e) {
        RespostaEventoAtendimento r = new RespostaEventoAtendimento();
        r.setIdEvento(e.getId());
        r.setIdPaciente(e.getIdPaciente());
        r.setTipoEvento(e.getTipoEvento());
        r.setTipoUnidade(e.getTipoUnidade());
        r.setIdentificadorUnidade(e.getIdentificadorUnidade());
        r.setDataHoraEvento(e.getDataHoraEvento());
        r.setDetalhes(e.getDetalhes());
        return r;
    }
}
