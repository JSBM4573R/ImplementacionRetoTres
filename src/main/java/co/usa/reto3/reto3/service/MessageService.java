package co.usa.reto3.reto3.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.usa.reto3.reto3.model.Message;
import co.usa.reto3.reto3.repository.MessageRepository;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;

    public List<Message>getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message>getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message message){
        if (message.getIdMessage()==null) {
            return messageRepository.save(message);
        }else{
            Optional<Message> consulta=messageRepository.getMessage(message.getIdMessage());
            if (consulta.isEmpty()) {
                return messageRepository.save(message);
            }else{
                return message;
            }
        }
    }
}
