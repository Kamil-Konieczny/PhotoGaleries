package pl.kamil.PhotoGaleries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.kamil.PhotoGaleries.DBConnection.*;
import pl.kamil.PhotoGaleries.Entities.Gallery;
import pl.kamil.PhotoGaleries.Entities.MyUserDetails;
import pl.kamil.PhotoGaleries.Entities.Photo;
import pl.kamil.PhotoGaleries.Entities.User;

import java.util.List;

@Controller
public class MainController {
    private User user;
    @Autowired
    UserRepository userRepository;

    @Autowired
    GalleryService galleryService;

    @Autowired
    PhotoService photoService;

    @Autowired
    UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/client")
    public String clientPanel(Model model)
    {
        User principal = ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
        model.addAttribute("galleryName",principal.getGallery().getGalleryName());
        if (principal.getGallery().getPhotos().size() != 0) {
            List<Photo> photos = principal.getGallery().getPhotos();
            model.addAttribute("photosList", photos);
            model.addAttribute("galleryName",principal.getGallery().getGalleryName());
        }
    return "client";
    }

    @GetMapping("/admin")
    public String adminPanel(Model model)
    {
   //     User user2 =  userService.getAllClients().get(1);
        model.addAttribute("user",user);
        if(user!=null) {
            model.addAttribute("galleryName",user.getGallery().getGalleryName());
            if (user.getGallery().getPhotos().size() != 0) {
                List<Photo> photos = user.getGallery().getPhotos();
                model.addAttribute("photosList", photos);
                model.addAttribute("galleryName",user.getGallery().getGalleryName());
            }
        }
        else
        {
            model.addAttribute("galleryName","<- Select a client");
        }

        List<User> allClients =  userService.getAllClients();
        model.addAttribute("allClients", allClients);
        return "admin";
    }

    @GetMapping("/login?logout")
    public String logout()
    {
        user = null;
        return "login";
    }

    @GetMapping("/showGallery")
    public String getClient(String clientName, Model model)
    {
       User user2 =  userService.getAllClients().get(1);
        user = userService.findByName(clientName);
        List<Photo> photos = user2.getGallery().getPhotos();

        model.addAttribute("photosList",photos);
        model.addAttribute("clientName",clientName);

        return "redirect:/admin";
    }

    @GetMapping("/table")
    public String getUsersData(Model model)
    {
        List<User> usersList = userService.getAllUsers();
        model.addAttribute("allUsers",usersList);
        return "table";
    }


    @PostMapping("/saveClient")
    public String saveClient(@RequestParam("login")String login,
                             @RequestParam("password")String password,
                             @RequestParam("name")String name,
                             @RequestParam("gallery_name")String gallery_name)
    {
        User user = new User(login,passwordEncoder.encode(password),name,"ROLE_USER");
        Gallery gallery = new Gallery(gallery_name);
        user.setGallery(gallery);
        userService.saveUser(user);

        return "redirect:/admin";
    }

    @PostMapping("/savePhoto")
    public String savePhoto(@RequestParam("photoName")String photoName,
                            @RequestParam("file")MultipartFile file,Model model)
    {

        Photo photo = new Photo(photoName,file);
        if(user!=null)
        {
            Gallery gallery = user.getGallery();
           gallery.addPhoto(photo);
            user.setGallery(gallery);
            photoService.savePhoto(photo);
            userService.saveUser(user);
        }
        return "redirect:/admin";
    }
}
