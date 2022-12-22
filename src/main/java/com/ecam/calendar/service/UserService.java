package com.ecam.calendar.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecam.calendar.model.User;
import com.ecam.calendar.repository.UserRepository;
import java.util.List;
import java.util.Optional;

/**
 * Cette classe crée toutes les méthodes lié au user qui seront appelé par notre controlleur user afin de géré les requêtes
 */

@Service
public class UserService {

    @Autowired
    UserRepository UserRepository;

    /**
     * Cette méthde crée un nouveau user
     * @param User voir les parametre de la classe User de model
     * @return un objet user
     */
    public User createUser(User User) {
        return UserRepository.save(User);
    }

    /**
     * Cette methode retourne tous les users
     * @return une liste d'objet user
     */
    public List<User> getUsers() {
        return UserRepository.findAll();
    }

    /**
     * Cette méthode retourne le user par l'id
     * @param userId l'identifiant unique du user
     * @return l'objet user identifiable par l'id
     */
    public Optional<User> getUserById(Long userId){return UserRepository.findById(userId);}

    /**
     * Cette méthode efface le user par son id
     * @param userId l'identfiant de l'user
     */
    public void deleteUser(Long userId) {
        UserRepository.deleteById(userId);
    }

    /**
     * Cette méthode met à jour le user identifié avec l'id avec les params passées
     * @param userId l'identifiant du user
     * @param userDetails les parametre de l'objet user : voir User dans model pour plus de détails
     * @return un objet user
     */
    public User updateUser(Long userId, User userDetails) {
        User User = UserRepository.findById(userId).get();
        User.setFirstName(userDetails.getFirstName());
        User.setLastName(userDetails.getLastName());
        //user.setEmailId(userDetails.getEmailId());

        return UserRepository.save(User);
    }
}