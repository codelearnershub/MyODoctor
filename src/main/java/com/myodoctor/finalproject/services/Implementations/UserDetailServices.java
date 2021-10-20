package com.myodoctor.finalproject.services.Implementations;

import com.myodoctor.finalproject.models.Person;
import com.myodoctor.finalproject.models.Role;
import com.myodoctor.finalproject.repositories.IPersonRepositories;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailServices implements UserDetailsService {

    private IPersonRepositories personRepositories;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Person> optionalUser = Optional.ofNullable(personRepositories.findByUsername(userName));
        if(optionalUser.isPresent()) {
            Person person = optionalUser.get();

            List<String> roleList = new ArrayList<String>();
            for(Role role:person.getRoles()) {
                roleList.add(role.getName());
            }

            return User.builder()
                    .username(person.getUsername())
                    //change here to store encoded password in db
                    .password( person.getPassword() )
                    .disabled(person.isActive())
//                    .accountExpired(person.isAccountExpired())
//                    .accountLocked(user.isAccountLocked())
//                    .credentialsExpired(user.isCredentialsExpired())
                    .roles(roleList.toArray(new String[0]))
                    .build();
        } else {
            throw new UsernameNotFoundException("User Name is not Found");
        }
    }
}