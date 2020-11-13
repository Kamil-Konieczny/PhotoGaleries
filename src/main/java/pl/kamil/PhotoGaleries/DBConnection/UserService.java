package pl.kamil.PhotoGaleries.DBConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.kamil.PhotoGaleries.Entities.Gallery;
import pl.kamil.PhotoGaleries.Entities.User;
import pl.kamil.PhotoGaleries.Entities.MyUserDetails;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
//
//@PostConstruct
//    public void fillDB()
//    {
//        User admin = new User("kamil",passwordEncoder.encode("kamil"),"Kamil Konieczny","ROLE_ADMIN");
//        userRepository.save(admin);
//        User user = new User("konrad",passwordEncoder.encode("konrad"),"Konrad Konieczny","ROLE_USER");
//        Gallery gallery =new Gallery("Galeria Konrada");
//        user.setGallery(gallery);
//        userRepository.save(user);
//        User user2 = new User("klaudia",passwordEncoder.encode("klaudia"),"Klaudia Swierczek","ROLE_USER");
//        user2.setGallery(new Gallery("Galeria Klaudii"));
//        userRepository.save(user2);
//        User user3 = new User("bartek",passwordEncoder.encode("bartek"),"Bartek Fira","ROLE_USER");
//        user3.setGallery(new Gallery("Galeria Bartka"));
//        userRepository.save(user3);
//
//    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        if(user == null)
        {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new MyUserDetails(user);
    }
    public void saveUser(User user)
    {
        User userEntity = new User();
        userEntity.setLogin(user.getLogin());
        userEntity.setName(user.getName());
        userEntity.setRole(user.getRole());
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
    public List<User> getAllClients()
    {
        List<User> allClients = new ArrayList<>();
        List<User> allUsers = userRepository.findAll();
        for(User element : allUsers)
        {

            if(element.getRole().equals("ROLE_USER"))
            {
                allClients.add(element);
            }
        }
        return allClients;
    }
    public User findByName(String name)
    {
        return userRepository.findByName(name);
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }
}
