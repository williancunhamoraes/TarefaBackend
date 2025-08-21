package com.tarefas.gerenciador_tarefas.repository;

import com.tarefas.gerenciador_tarefas.model.Tarefa;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public final class TarefaEspecificacoes {
    public static Specification<Tarefa> textoContem(String q) {
        if (!StringUtils.hasText(q)) {
            return (root, cq, cb) -> cb.conjunction(); // neutro
        }
        String like = "%" + q.trim().toLowerCase() + "%";
        return (root, cq, cb) -> cb.or(
                cb.like(cb.lower(root.get("titulo")), like),
                cb.like(cb.lower(root.get("descricao")), like)
        );
    }
}
