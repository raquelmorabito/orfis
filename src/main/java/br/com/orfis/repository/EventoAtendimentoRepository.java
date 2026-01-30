package br.com.orfis.repository;

import br.com.orfis.model.EventoAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventoAtendimentoRepository extends JpaRepository<EventoAtendimento, Long> {

    List<EventoAtendimento> findByIdPacienteOrderByDataHoraEventoAsc(String idPaciente);

    Optional<EventoAtendimento> findTop1ByIdPacienteOrderByDataHoraEventoDesc(String idPaciente);
}
