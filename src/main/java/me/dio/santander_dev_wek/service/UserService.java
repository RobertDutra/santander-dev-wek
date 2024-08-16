package me.dio.santander_dev_wek.service;

import me.dio.santander_dev_wek.Interface.UserInterface;
import me.dio.santander_dev_wek.exceptions.EntityNotFoundException;
import me.dio.santander_dev_wek.model.User;
import me.dio.santander_dev_wek.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserInterface {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User findById(Long id) throws EntityNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário com id " + id + " não encontrado!"));
    }

    @Override
    public User create(User user) throws EntityNotFoundException {
        if (userRepository.existsByAccountNumber(user.getAccount().getNumber())){
            throw new EntityNotFoundException("Este número de conta já existi!");
        }
        if (userRepository.existsByCardNumber(user.getCard().getNumber())){
            throw new EntityNotFoundException("Este número de cartão já existi!");
        }
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User userUpdate) throws EntityNotFoundException {
        User userFound = findById(id);
        userFound.setName(userUpdate.getName());
        userRepository.save(userFound);
        return userFound;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) throws EntityNotFoundException {
        findById(id);
        userRepository.deleteById(id);
    }
}
