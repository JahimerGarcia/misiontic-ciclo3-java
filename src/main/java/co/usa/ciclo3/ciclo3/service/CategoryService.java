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

    public Category update(Category p){
        // si el id es nulo, no se puede actualizar
        if (p.getId()!=null){
            Optional<Category> paux=categoryRepository.getCategoria(p.getId());
            if (!paux.isEmpty()){
                // si tiene nombre entonces actualiza
                if (p.getName()!=null){
                    paux.get().setName(p.getName());
                }
                // si tiene descripcion entonces actualiza
                if (p.getDescription()!=null){
                    paux.get().setDescription(p.getDescription());
                }

                return categoryRepository.save(paux.get());
            }
            
        }
        return p;
    }

    public boolean deleteCategory(int id){
        Optional<Category> paux=categoryRepository.getCategoria(id);
        if (!paux.isEmpty()){
            categoryRepository.deleteCategory(paux.get());
            return true;
        }
        return false;
    }
}
