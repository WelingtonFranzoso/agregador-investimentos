package com.franzoso.agregador_investimentos.service;

import com.franzoso.agregador_investimentos.controller.dto.AccountResponseDTO;
import com.franzoso.agregador_investimentos.controller.dto.CreateAccountDTO;
import com.franzoso.agregador_investimentos.controller.dto.CreateUserDTO;
import com.franzoso.agregador_investimentos.controller.dto.UpdateUserDTO;
import com.franzoso.agregador_investimentos.entity.Account;
import com.franzoso.agregador_investimentos.entity.BillingAddress;
import com.franzoso.agregador_investimentos.entity.User;
import com.franzoso.agregador_investimentos.repository.AccountRepository;
import com.franzoso.agregador_investimentos.repository.BillingAddressRepository;
import com.franzoso.agregador_investimentos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BillingAddressRepository billingAddressRepository;

    public UUID createUser(CreateUserDTO createUserDTO) {
        var entity = new User(
                UUID.randomUUID(),
                createUserDTO.userName(),
                createUserDTO.email(),
                createUserDTO.password(),
                Instant.now(),
                null);
        var userSaved = userRepository.save(entity);
        return userSaved.getUserId();
    }

    public Optional<User> getUserById(String userId) {
        return userRepository.findById(UUID.fromString(userId));
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public void updateUserById(String userId, UpdateUserDTO updateUserDTO) {
        var id = UUID.fromString(userId);
        var userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            var user = userEntity.get();
            if (updateUserDTO.userName() != null) {
                user.setUserName(updateUserDTO.userName());
            }
            if (updateUserDTO.password() != null) {
                user.setPassword(updateUserDTO.password());
            }
            userRepository.save(user);
        }
    }

    public void deleteById(String userId) {
        var id = UUID.fromString(userId);
        var userExists = userRepository.existsById(id);
        if (userExists) {
            userRepository.deleteById(id);
        }
    }

    public void createAccount(String userId, CreateAccountDTO createAccountDTO) {
        var user = userRepository.findById(UUID.fromString(userId)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        var account = new Account(UUID.randomUUID(), createAccountDTO.description(), user, null, new ArrayList<>());
        var accountCreated = accountRepository.save(account);
        var billingAddress = new BillingAddress(accountCreated.getAccountId(), createAccountDTO.street(), createAccountDTO.number(), account);
        billingAddressRepository.save(billingAddress);
    }

    public List<AccountResponseDTO> listAccounts(String userId) {
        var user = userRepository.findById(UUID.fromString(userId)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return user.getAccounts().stream().map(ac -> new AccountResponseDTO(ac.getAccountId().toString(), ac.getDescription())).toList();
    }
}