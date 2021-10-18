package co.usa.reto3.reto3.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Esta clase contiene los atributos y metodos getters y setters para la 
 * ejecucion correcta de la api.
 * 
 * @author JSBM
 */
@Entity
@Table(name = "audience")
public class Audience implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /**
     * Contiene el id del auditorio
     */
    private Integer id;
    /**
     * Contiene el nombre del auditorio
     */
    private String name;
    /**
     * Contiene la categoria del auditorio
     */
    private String owner;
    /**
     * Contiene la capacidad del auditorio
     */
    private Integer capacity;
    /**
     * Contiene la descripcion del auditorio
     */
    private String description;

    /**
     * Relacion de tabla
     */
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("audiences")
    private Category category;

    /**
     * Relacion de tabla
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "audience")
    @JsonIgnoreProperties({"audience", "client"})
    private List<Message> messages;

    /**
     * Relacion de tabla
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "audience")
    @JsonIgnoreProperties({"audience", "client"})
    private List<Reservations> reservations;

    /**
     * Trae el id
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * Modifica el id
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Trae el nombre
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica el nombre
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna el nombre
     * @return
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Modifica el owner
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Retorna la capacidad
     * @return
     */
    public Integer getCapacity() {
        return capacity;
    }

    /**
     * Modifica la capacidad
     * @param capacity
     */
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    /**
     * Retorna la Descripcion
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifica la descripcion
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * retorna la categoria
     * @return
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Modifica la categoria
     * @param category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Retorna el mensaje
     * @return
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Modifica el mensaje
     * @param messages
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * Retorna las reversas
     * @return
     */
    public List<Reservations> getReservations() {
        return reservations;
    }

    /**
     * Modifica las reservas
     * @param reservations
     */
    public void setReservations(List<Reservations> reservations) {
        this.reservations = reservations;
    }


}
