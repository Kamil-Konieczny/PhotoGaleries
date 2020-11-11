package pl.kamil.PhotoGaleries.DBConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.kamil.PhotoGaleries.Entities.Client;
import pl.kamil.PhotoGaleries.Entities.ClientDetails;

import javax.annotation.PostConstruct;

@Service("userService")
public class ClientService implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Client client = clientRepository.findByLogin(login);
        if(client == null)
        {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new ClientDetails(client);
    }
    public void addNewClient(Client client)
    {
        Client clientEntity = new Client();
        clientEntity.setLogin(client.getLogin());
        clientEntity.setClient_name(client.getClient_name());
        clientEntity.setRole(client.getRole());
        clientEntity.setPassword(passwordEncoder.encode(client.getPassword()));
        clientRepository.save(client);
    }
}
