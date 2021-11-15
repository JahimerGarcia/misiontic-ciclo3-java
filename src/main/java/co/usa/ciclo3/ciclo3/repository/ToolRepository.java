package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Tool;
import co.usa.ciclo3.ciclo3.repository.crud.ToolCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;


@Repository
public class ToolRepository {
    @Autowired
    private ToolCrudRepository toolCrudRepository;

    public List<Tool> getAll() {
        return (List<Tool>)toolCrudRepository.findAll();
    }

    public Optional<Tool> getTool(Integer id) {
        return toolCrudRepository.findById(id);
    }

    public Tool save(Tool Tool) {
        return toolCrudRepository.save(Tool);
    }

    public void delete(Tool tool) {
        toolCrudRepository.delete(tool);
    }

}