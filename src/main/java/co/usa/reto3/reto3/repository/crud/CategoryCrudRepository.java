package co.usa.reto3.reto3.repository.crud;

import org.springframework.data.repository.CrudRepository;
import co.usa.reto3.reto3.model.Category;

public interface CategoryCrudRepository extends CrudRepository <Category, Integer> {
    
}
