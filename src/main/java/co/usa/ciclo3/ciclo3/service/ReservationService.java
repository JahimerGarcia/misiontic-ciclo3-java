package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository ReservationRepository;

    public List<Reservation> getAll(){
        return  ReservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int id){
        return ReservationRepository.getReservation(id);
    }

    public Reservation save(Reservation p){
        p.setStatus("created");
        
        if(p.getIdReservation()==null){
            return ReservationRepository.save(p);
        }else{
            Optional<Reservation> paux=ReservationRepository.getReservation(p.getIdReservation());
            if(paux.isEmpty()){
                return ReservationRepository.save(p);
            }else{
                return p;
            }
        }
    }
}
