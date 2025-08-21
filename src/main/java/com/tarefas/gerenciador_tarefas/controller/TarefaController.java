package com.tarefas.gerenciador_tarefas.controller;

import com.tarefas.gerenciador_tarefas.dto.TarefaEntradaDTO;
import com.tarefas.gerenciador_tarefas.dto.TarefaRespostaDTO;
import com.tarefas.gerenciador_tarefas.model.enums.StatusTarefa;
import com.tarefas.gerenciador_tarefas.service.TarefaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tarefas")
@RequiredArgsConstructor
@CrossOrigin(origins = "${app.cors-origins:*}")
public class TarefaController {
    private final TarefaService servico;

    @GetMapping
    public Page<TarefaRespostaDTO> listar(
            @RequestParam(required=false) String q,
            @RequestParam(required=false) StatusTarefa status,
            @RequestParam(defaultValue="0") int page,
            @RequestParam(defaultValue="10") int size,
            @RequestParam(defaultValue="dataCriacao,desc") String sort
    ) {
        Sort s = Sort.by(sort.split(",")[0]);
        s = sort.endsWith(",asc") ? s.ascending() : s.descending();
        return servico.listar(q, status, PageRequest.of(page, size, s));
    }

    @GetMapping("/{id}") public TarefaRespostaDTO obter(@PathVariable Long id){
        return servico.obter(id);
    }
    @PostMapping public TarefaRespostaDTO criar(@Valid @RequestBody TarefaEntradaDTO dto){
        return servico.criar(dto);
    }
    @PutMapping("/{id}") public TarefaRespostaDTO atualizar(@PathVariable Long id,
                                                            @Valid @RequestBody TarefaEntradaDTO dto){
        return servico.atualizar(id, dto);
    }
    @DeleteMapping("/{id}") public void excluir(@PathVariable Long id){
        servico.excluir(id);
    }
}
