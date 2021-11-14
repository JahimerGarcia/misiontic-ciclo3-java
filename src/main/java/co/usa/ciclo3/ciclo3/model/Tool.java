package co.usa.ciclo3.ciclo3.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@Entity
@Table(name = "tool")
public class Tool implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    
    private String brand;
    private Integer year;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("tools")
    private Category category;


    @OneToMany(mappedBy = "tool", cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties({"messages", "tool", "client"})
    private List<Message> messages;

    @OneToMany(mappedBy = "tool", cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties("reservations")
    private List<Reservation> reservations;



    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public Integer getYear(){
        return year;
    }

    public void setYear(Integer year){
        this.year = year;
    }

    public Category getCategory(){
        return category;
    }

    public void setCategory(Category category){
        this.category = category;
    }

    public List<Message> getMessages(){
        return messages;
    }

    public void setMessages(List<Message> messages){
        this.messages = messages;
    }
    
    public List<Reservation> getReservations(){
        return reservations;
    }

    public void setReservations(List<Reservation> reservations){
        this.reservations = reservations;
    }
        

}
