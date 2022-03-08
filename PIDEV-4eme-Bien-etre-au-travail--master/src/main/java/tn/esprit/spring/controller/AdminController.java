package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.Payload.response.MessageResponse;
import tn.esprit.spring.repository.IUserRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    IUserRepository userRepository;

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity< ? > deleteClient(@PathVariable Long id) {
        try {
            userRepository.deleteById(id);
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(" Deleted successfully!"));
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(" Failed to delete employee!"));
        }
    }

    @PostMapping("/blockEmployee/{id}")
    public ResponseEntity< ? > banEmployee(@PathVariable Long id) {
        try {
            User user =userRepository.findById(id).get();
            user.setBlocked(true);
            userRepository.save(user);
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(" blocked successfully!"));
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(" Failed to block employee!"));
        }
    }

}
