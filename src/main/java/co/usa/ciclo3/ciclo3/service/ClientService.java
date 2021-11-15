package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository ClientRepository;

    public List<Client> getAll(){
        return  ClientRepository.getAll();
    }
    public Optional<Client> getClient(int id){
        return ClientRepository.getClient(id);
    }

    public Client save(Client p){
        // si es nuevo
        if(p.getIdClient()==null){
            return ClientRepository.save(p);
        }else{ //si es uno existente
            Optional<Client> paux=ClientRepository.getClient(p.getIdClient());
            if(paux.isEmpty()){
                return ClientRepository.save(p);
            }else{
                return p;
            }
        }
    }

    public Client update(Client p){
        // si el id es nulo, no se puede actualizar
        if (p.getIdClient()!=null){
            Optional<Client> paux=ClientRepository.getClient(p.getIdClient());
            if (!paux.isEmpty()){


                if (p.getEmail()!=null){
                    paux.get().setEmail(p.getEmail());
                }

                if (p.getPassword()!=null){
                    paux.get().setPassword(p.getPassword());
                }
                
                
                if (p.getName()!=null){
                    paux.get().setName(p.getName());
                }
                // si tiene descripcion entonces actualiza
                if (p.getAge()!=null){
                    paux.get().setAge(p.getAge());
                }

                return ClientRepository.save(paux.get());
            }
            
        }
        return p;
    }

    public boolean delete(int id){
        Optional<Client> paux=ClientRepository.getClient(id);
        if (!paux.isEmpty()){
            ClientRepository.delete(paux.get());
            return true;
        }
        return false;
    }


}
