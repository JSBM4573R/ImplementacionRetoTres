package co.usa.reto3.reto3.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import co.usa.reto3.reto3.model.Reservations;
import co.usa.reto3.reto3.service.ReservationsService;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationsController {
    
    @Autowired
    private ReservationsService reservationsService;

    @GetMapping("/all")
    public List<Reservations>getReservations(){
        return reservationsService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservations>getReservations(@PathVariable("id") int id){
        return reservationsService.getReservations(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservations save(@RequestBody Reservations reservations){
        return reservationsService.save(reservations);
    }
    
}
