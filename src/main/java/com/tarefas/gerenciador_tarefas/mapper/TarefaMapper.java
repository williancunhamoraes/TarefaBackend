package com.tarefas.gerenciador_tarefas.mapper;

import com.tarefas.gerenciador_tarefas.dto.TarefaEntradaDTO;
import com.tarefas.gerenciador_tarefas.dto.TarefaRespostaDTO;
import com.tarefas.gerenciador_tarefas.model.Tarefa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TarefaMapper {

    Tarefa toEntity(TarefaEntradaDTO dto);

    @Mapping(source = "id", target = "id")
    TarefaRespostaDTO toDTO(Tarefa entity);
}
