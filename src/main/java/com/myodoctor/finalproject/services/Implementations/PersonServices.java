package com.myodoctor.finalproject.services.Implementations;

import com.myodoctor.finalproject.models.Address;
import com.myodoctor.finalproject.models.Person;
import com.myodoctor.finalproject.models.RegisterModel.PersonRegisterModel;
import com.myodoctor.finalproject.models.Role;
import com.myodoctor.finalproject.repositories.IAddressRepositories;
import com.myodoctor.finalproject.repositories.IPersonRepositories;
import com.myodoctor.finalproject.repositories.IRoleRepositories;
import com.myodoctor.finalproject.services.Interfaces.IPersonService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PersonServices implements IPersonService {

    final IPersonRepositories personRepositories;
    final IRoleRepositories roleRepositories;
    final IAddressRepositories addressRepositories;
    final PasswordEncoder passwordEncoder;

    public PersonServices(IRoleRepositories roleRepositories, IPersonRepositories personRepositories, IAddressRepositories addressRepositories, PasswordEncoder passwordEncoder) {
        this.personRepositories = personRepositories;
        this.roleRepositories = roleRepositories;
        this.addressRepositories = addressRepositories;
        this.passwordEncoder = passwordEncoder;
    }

    public Person createPerson(RedirectAttributes redirectAttributes,Address address,PersonRegisterModel personModel, String role,boolean staff) {
        var person = new Person();
        if (!staff) {
            if (setValues(person, personModel)) {
                person.setReferenceNo(myUniqueNumber());
                person.setDisabled(false);
                person.setPassword(passwordEncoder.encode(personModel.getPassword()));

                String fileName = null;
                if (personModel.getProfilePictureURL() != null) {
                    fileName = uploadProfilePicture(personModel.getProfilePictureURL(), redirectAttributes);
                }
                person.setProfilePictureURL(fileName);
                var optionalRole = roleRepositories.findByName(role);

                if (optionalRole.isPresent()) {
                    Role r = optionalRole.get();
                    List<Role> roles = new ArrayList<>();
                    roles.add(r);
                    person.setRoles(roles);
                }

                var ad = new Address();
                ad.setCity(address.getCity());
                ad.setCountry(address.getCountry());
                ad.setStateProvinceCounty(address.getStateProvinceCounty());
                ad.setStreetNumber(address.getStreetNumber());
                ad.setZipPostalCode(address.getZipPostalCode());
                Address a = addressRepositories.save(ad);

                person.setAddress(a);

                personRepositories.save(person);
                System.out.println("Person created Successfully");
                return person;
            }
        } else{
            if (setDoctorValues(person, personModel)) {
                person.setReferenceNo(myUniqueNumber());
                person.setDisabled(false);
                person.setPassword(passwordEncoder.encode(personModel.getPassword()));

                String fileName = null;
                if (personModel.getProfilePictureURL() != null) {
                    fileName = uploadProfilePicture(personModel.getProfilePictureURL(), redirectAttributes);
                }
                person.setProfilePictureURL(fileName);
                var optionalRole = roleRepositories.findByName(role);

                if (optionalRole.isPresent()) {
                    Role r = optionalRole.get();
                    List<Role> roles = new ArrayList<>();
                    roles.add(r);
                    person.setRoles(roles);
                }

                var ad = new Address();
                ad.setCity(address.getCity());
                ad.setCountry(address.getCountry());
                ad.setStateProvinceCounty(address.getStateProvinceCounty());
                ad.setStreetNumber(address.getStreetNumber());
                ad.setZipPostalCode(address.getZipPostalCode());
                Address a = addressRepositories.save(ad);

                person.setAddress(a);

                personRepositories.save(person);
                System.out.println("Person created Successfully");
                return person;
            }
        }
        return person;
    }

        private int randomNumbers () {
            return (int) (Math.random() * 10);
        }
        private String myUniqueNumber () {
            return "MOD_0 " + randomNumbers() + "" + randomNumbers() + "" + randomNumbers() + "" + randomNumbers() + " -OD";
        }

        public boolean update ( int id, Address address, PersonRegisterModel personModel){
            if (personRepositories.findById(id).isPresent()) {
                Person person = personRepositories.findById(id).get();
                if (setValues(person, personModel)) {
                    System.out.println("Person Updated Successfully");
                    return true;
                } else {
                    System.out.println("Person Failed to Update Successfully");
                    return false;
                }
            }
            return true;
        }

        public boolean disablePerson ( int id){
            Person person = personRepositories.findById(id).get();
            if (!person.isDisabled()) {
                person.setDisabled(true);
                System.out.println("Person Disabled!!");
                return true;
            } else {
                System.out.println("Person Already Disabled");
            }
            return true;
        }

        public boolean setValues (Person person, PersonRegisterModel personModel){
            person.setUsername(personModel.getUsername());
            person.setFirstName(personModel.getFirstName());
            person.setLastName(personModel.getLastName());
            person.setMiddleName(personModel.getMiddleName());
            person.setDateOfBirth(personModel.getDateOfBirth());
            person.setHomePhoneNo(personModel.getHomePhoneNo());
            person.setWorkPhoneNo(personModel.getHomePhoneNo());
            person.setMobileNo(personModel.getMobileNo());
            person.setGender(personModel.getGender());

            person.setEmail(personModel.getEmail());
            return true;
        }

    public boolean setDoctorValues (Person person, PersonRegisterModel personModel){
        person.setUsername(personModel.getEmail());
        person.setFirstName(personModel.getFirstName());
        person.setLastName(personModel.getLastName());
        person.setMiddleName(personModel.getMiddleName());
        person.setDateOfBirth(personModel.getDateOfBirth());
        person.setHomePhoneNo(personModel.getHomePhoneNo());
        person.setWorkPhoneNo(personModel.getHomePhoneNo());
        person.setMobileNo(personModel.getMobileNo());
        person.setGender(personModel.getGender());
        person.setEmail(personModel.getEmail());
        return true;
    }

        public boolean validate (RedirectAttributes redirectAttributes, PersonRegisterModel personModel){
            if (personModel.getFirstName().isEmpty() || personModel.getFirstName() == null) {
                redirectAttributes.addAttribute("userError", "FirstName Must Be Specified");
            } else if (personModel.getLastName().isEmpty() || personModel.getLastName() == null) {
                redirectAttributes.addAttribute("userError", "LastName Must Be Specified");
            } else if (personModel.getMobileNo().isEmpty() || personModel.getMobileNo() == null) {
                redirectAttributes.addAttribute("userError", "Mobile No Must Be Specified");
            } else if (personModel.getEmail().isEmpty() || personModel.getEmail() == null || !personModel.getEmail().contains("@") || !personModel.getEmail().contains(".")) {
                redirectAttributes.addAttribute("userError", "Invalid Email");
            } else if (personModel.getGender().isEmpty() || personModel.getGender() == null) {
                redirectAttributes.addAttribute("userError", "Gender Must Be Specified");
            } else if (personModel.getDateOfBirth() == null) {
                redirectAttributes.addAttribute("userError", "Date Cannot Be Empty");
            } else if (personModel.getUsername().isEmpty() || personModel.getUsername() == null) {
                redirectAttributes.addAttribute("userError", "User Name can not be empty or blank.");
            } else if (personRepositories.existsByUsername(personModel.getUsername())) {
                redirectAttributes.addAttribute("userError", "UserName Already Exist");
            } else if (!(personModel.getConfirmPassword().equals(personModel.getPassword()))) {
                redirectAttributes.addAttribute("userError", "Password Doesn't Match");
            } else if (personModel.getPassword().isEmpty() || personModel.getPassword().isBlank()) {
                redirectAttributes.addAttribute("userError", "Invaild Password");
            } else {
                return true;
            }
            return false;
        }

    public boolean doctorValidate (RedirectAttributes redirectAttributes, PersonRegisterModel personModel){
        if (personModel.getFirstName().isEmpty() || personModel.getFirstName() == null) {
            redirectAttributes.addAttribute("userError", "FirstName Must Be Specified");
        } else if (personModel.getLastName().isEmpty() || personModel.getLastName() == null) {
            redirectAttributes.addAttribute("userError", "LastName Must Be Specified");
        } else if (personModel.getMobileNo().isEmpty() || personModel.getMobileNo() == null) {
            redirectAttributes.addAttribute("userError", "Mobile No Must Be Specified");
        } else if (personModel.getEmail().isEmpty() || personModel.getEmail() == null || !personModel.getEmail().contains("@") || !personModel.getEmail().contains(".")) {
            redirectAttributes.addAttribute("userError", "Invalid Email");
        } else if (personModel.getGender().isEmpty() || personModel.getGender() == null) {
            redirectAttributes.addAttribute("userError", "Gender Must Be Specified");
        } else if (personModel.getDateOfBirth() == null) {
            redirectAttributes.addAttribute("userError", "Date Cannot Be Empty");
        }
//        else if (personModel.getUsername().isEmpty() || personModel.getUsername() == null) {
//            redirectAttributes.addAttribute("userError", "User Name can not be empty or blank.");
//        }
        else if (personRepositories.existsByUsername(personModel.getUsername())) {
            redirectAttributes.addAttribute("userError", "UserName Already Exist");
        } else if (!(personModel.getConfirmPassword().equals(personModel.getPassword()))) {
            redirectAttributes.addAttribute("userError", "Password Doesn't Match");
        } else if (personModel.getPassword().isEmpty() || personModel.getPassword().isBlank()) {
            redirectAttributes.addAttribute("userError", "Invaild Password");
        } else {
            return true;
        }
        return false;
    }
        public String uploadProfilePicture (MultipartFile file, RedirectAttributes redirectAttributes){
            final String UPLOAD_DIR = "C://Users//ESSIEN ABASIAMA//Documents//Abasi Complex [ programming ]//Java Personal practise//myodoctor//src//main//resources//static//profilePictures";
            try {
                String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
                Path copyLocation = Paths.get(UPLOAD_DIR + File.separator + fileName);
                Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
                return fileName;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
