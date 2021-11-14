package co.usa.ciclo3.ciclo3.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="message")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;

    private String messageText;

    @ManyToOne
    @JoinColumn(name = "tool_id")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Tool tool;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Client client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer id) {
        this.idMessage = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String MessageText) {
        this.messageText = MessageText;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }



}