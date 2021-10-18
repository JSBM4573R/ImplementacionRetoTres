package co.usa.reto3.reto3.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.usa.reto3.reto3.model.Reservations;
import co.usa.reto3.reto3.repository.ReservationsRepository;

@Service
public class ReservationsService {
    
    @Autowired
    private ReservationsRepository reservationsRepository;

    public List<Reservations>getAll(){
        return reservationsRepository.getAll();
    }

    public Optional<Reservations>getReservations(int id){
        return reservationsRepository.getReservations(id);
    }

    public Reservations save(Reservations reservations){
        if (reservations.getIdResevation()==null) {
            return reservationsRepository.save(reservations);
        }else{
            Optional<Reservations> consulta= reservationsRepository.getReservations(reservations.getIdResevation());
            if (consulta.isEmpty()) {
                return reservationsRepository.save(reservations);
            }else{
                return reservations;
            }
        }
    }
}
