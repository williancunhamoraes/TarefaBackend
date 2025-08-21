package com.tarefas.gerenciador_tarefas.service;

import com.tarefas.gerenciador_tarefas.dto.TarefaEntradaDTO;
import com.tarefas.gerenciador_tarefas.dto.TarefaRespostaDTO;
import com.tarefas.gerenciador_tarefas.mapper.TarefaMapper;
import com.tarefas.gerenciador_tarefas.model.Tarefa;
import com.tarefas.gerenciador_tarefas.model.enums.StatusTarefa;
import com.tarefas.gerenciador_tarefas.repository.TarefaEspecificacoes;
import com.tarefas.gerenciador_tarefas.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TarefaService {
    private final TarefaRepository repositorio;
    private final TarefaMapper mapper;

    public Page<TarefaRespostaDTO> listar(String q, StatusTarefa status, Pageable pageable) {
        Specification<Tarefa> spec = TarefaEspecificacoes.textoContem(q);

        if (status != null) {
            spec = spec.and((r, cq, cb) -> cb.equal(r.get("status"), status));
        }

        return repositorio.findAll(spec, pageable)
                .map(mapper::toDTO);
    }

    public TarefaRespostaDTO obter(Long id){
        var t = repositorio.findById(id).orElseThrow();
        return mapper.toDTO(t);
    }

    public TarefaRespostaDTO criar(TarefaEntradaDTO dto){
        var t = mapper.toEntity(dto);
        return mapper.toDTO(repositorio.save(t));
    }

    public TarefaRespostaDTO atualizar(Long id, TarefaEntradaDTO dto){
        var t = repositorio.findById(id).orElseThrow();
        t.setTitulo(dto.getTitulo());
        t.setDescricao(dto.getDescricao());
        t.setStatus(dto.getStatus());
        t.setUsuarioAtualizacao(dto.getUsuarioAtualizacao());
        return mapper.toDTO(repositorio.save(t));
    }

    public void excluir(Long id){ repositorio.deleteById(id); }
}