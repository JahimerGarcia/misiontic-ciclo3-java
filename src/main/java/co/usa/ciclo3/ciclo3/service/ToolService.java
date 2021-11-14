package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Tool;
import co.usa.ciclo3.ciclo3.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToolService {
    @Autowired
    private ToolRepository toolRepository;

    public List<Tool> getAll(){
        return  toolRepository.getAll();
    }
    public Optional<Tool> getTool(int id){
        return toolRepository.getTool(id);
    }

    public Tool save(Tool p){
        if(p.getId()==null){
            return toolRepository.save(p);
        }else{
            Optional<Tool> paux=toolRepository.getTool(p.getId());
            if(paux.isEmpty()){
                return toolRepository.save(p);
            }else{
                return p;
            }
        }
    }
}
