package co.usa.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.usa.reto3.reto3.model.Reservations;
import co.usa.reto3.reto3.repository.crud.ReservationsCrudRepository;


@Repository
public class ReservationsRepository {
    
    @Autowired
    private ReservationsCrudRepository reservationsCrudRepository;

    public List<Reservations>getAll(){
        return (List<Reservations>)reservationsCrudRepository.findAll();
    }

    public Optional<Reservations>getReservations(int id){
        return reservationsCrudRepository.findById(id);
    }

    public Reservations save(Reservations reservations){
        return reservationsCrudRepository.save(reservations);
    }
}
