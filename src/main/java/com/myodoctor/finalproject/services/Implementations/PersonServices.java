package com.myodoctor.finalproject.services.Implementations;


import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.Person;
import com.myodoctor.finalproject.models.RegisterModel.PersonRegisterModel;
import com.myodoctor.finalproject.models.Role;
import com.myodoctor.finalproject.repositories.IPersonRepositories;
import com.myodoctor.finalproject.repositories.IRoleRepositories;
import com.myodoctor.finalproject.services.Interfaces.IPersonServices;

import java.util.ArrayList;
import java.util.List;


public class PersonServices implements IPersonServices {

    final
    IPersonRepositories personRepositories;
    IRoleRepositories roleRepositories;


    public PersonServices(IPersonRepositories personRepositories) {
        this.personRepositories = personRepositories;
    }

    public Person createPerson(Address address,PersonRegisterModel personModel, String role) {
        var person = new Person();
        if (setValues(address,person,personModel)) {
            person.setReferenceNo(myUniqueNumber());
            person.setActive(true);
            person.setPassword(personModel.getPassword());
            var optionalRole = roleRepositories.findByName(role);

            if(optionalRole.isPresent()) {
                Role r = optionalRole.get();
                List<Role> roles = new ArrayList<>();
                roles.add(r);
                person.setRoles(roles);
            }

            personRepositories.save(person);
            System.out.println("Person created Successfully");
            return person;
        } else {
            System.out.println("Person Failed to create Successfully");
        }
        return person;
    }

    private int randomNumbers() {
       return (int) (Math.random()*10);
    }
    private String myUniqueNumber() {
       return  "MOD_0"+ randomNumbers() +""+ randomNumbers() + "" + randomNumbers()+ ""+randomNumbers()+ "";
    }

    public boolean update(int id,Address address,PersonRegisterModel personModel) {
//        var loggedUser = personController.getLoggedUsers();
//        int id = loggedUser.getId();
        if (personRepositories.findById(id) != null) {
            Person person = personRepositories.findById(id).get();
            if (setValues(address,person, personModel)) {
                System.out.println("Person Updated Successfully");
                return true;
            } else {
                System.out.println("Person Failed to Update Successfully");
                return false;
            }
        }
        return true;
    }

    public boolean disablePerson(int id) {
//        var loggedUser = personController.getLoggedUsers();
//        int id = loggedUser.getId();
        Person person = personRepositories.findById(id).get();
        if (person.isActive() == true) {
            person.setActive(false);
            System.out.println("Person Disabled!!");
            return true;
        } else {
            System.out.println("Person Already Disabled");
        }
        return  true;
    }

    public boolean setValues(Address address,Person person,PersonRegisterModel personModel) {
//        Person person = new Person();
//         = null;
//        assert false;
        person.setUsername(personModel.getUsername());
        person.setFirstName(personModel.getFirstName());
        person.setLastName(personModel.getLastName());
        person.setMiddleName(personModel.getMiddleName());

        address = new  Address();
        address.setCity(address.getCity());
        address.setCountry(address.getCountry());
        address.setStateProvinceCounty(address.getStateProvinceCounty());
        address.setStreetNumber(address.getStreetNumber());
        address.setZipPostalCode(address.getZipPostalCode());

        person.setAddress(address);
        person.setLanguage(personModel.getLanguage());
        person.setDateOfBirth(personModel.getDateOfBirth());
        person.setHomePhoneNo(personModel.getHomePhoneNo());
        person.setWorkPhoneNo(personModel.getHomePhoneNo());
        person.setMobileNo(personModel.getMobileNo());
        person.setGender(personModel.getGender());
        person.setProfilePictureURL(personModel.getProfilePictureURL());
        person.setEmail(personModel.getEmail());
        return true;
    }
}