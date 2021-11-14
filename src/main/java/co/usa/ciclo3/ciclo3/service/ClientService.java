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
}
