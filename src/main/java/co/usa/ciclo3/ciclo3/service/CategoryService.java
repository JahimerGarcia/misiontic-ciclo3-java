package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return  categoryRepository.getAll();
    }
    public Optional<Category> getCategoria(int id){
        return categoryRepository.getCategoria(id);
    }

    public Category save(Category p){
        if(p.getId()==null){
            return categoryRepository.save(p);
        }else{
            Optional<Category> paux=categoryRepository.getCategoria(p.getId());
            if(paux.isEmpty()){
                return categoryRepository.save(p);
            }else{
                return p;
            }
        }
    }
}
