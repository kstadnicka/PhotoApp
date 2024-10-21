package org.ks.photoapp.domain.photoSession;

import org.ks.photoapp.domain.client.Client;
import org.ks.photoapp.domain.client.ClientService;
import org.ks.photoapp.domain.client.dto.ClientDto;
import org.ks.photoapp.domain.photoSession.dto.PhotoSessionDto;
import org.ks.photoapp.domain.sessionType.SessionType;
import org.ks.photoapp.domain.user.dto.UserRegistrationDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.ks.photoapp.domain.client.ClientController.NOTIFICATION_ATTRIBUTE;


@Controller
public class PhotoSessionController {

    private final ClientService clientService;
    PhotoSessionService photoSessionService;

    public PhotoSessionController(ClientService clientService, PhotoSessionService photoSessionService) {
        this.clientService = clientService;
        this.photoSessionService = photoSessionService;
    }

    @GetMapping("/all-photosessions")
    public String getAllPhotoSession(Model model) {
        List<PhotoSessionDto> photoSessions = photoSessionService.getAllPhotoSession();
        model.addAttribute("heading", "Aktualne sesje");
        model.addAttribute("photoSessions", photoSessions);
        return "all-photosessions";
    }

    @GetMapping("/photosession/{client}")
    public String getPhotoSessionByClient(@PathVariable Client client, Model model) {
        PhotoSessionDto photoSession = photoSessionService.getPhotoSessionByClient(client)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("photoSession", photoSession);
        return "photosession-client";
    }

    @GetMapping("/photosession/{data}")
    public String getPhotoSessionByData(@PathVariable LocalDateTime data, Model model) {
        PhotoSessionDto photosession = photoSessionService.getPhotoSessionByDate(data)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("photoSession", photosession);
        return "photosession-data";
    }

    @GetMapping("/photosession/new-photosession")
    public String addPhotoSessionForm(Model model) {
        List<ClientDto> clients = clientService.getAllClients();
        List<SessionType> sessionType = Arrays.stream(SessionType.values()).toList();
        model.addAttribute("clients", clients);
        model.addAttribute("sessionTypes", sessionType);
        PhotoSessionDto photoSession = new PhotoSessionDto();
        model.addAttribute("photoSession", photoSession);
        return "photosession-form";
    }

    @PostMapping("/photosession/new-photosession")
    public String addPhotoSession(PhotoSessionDto photoSession, RedirectAttributes redirectAttributes) {
        photoSessionService.createNewSession(photoSession);
        redirectAttributes.addFlashAttribute("message", "Dodano nową sesję");
        return "redirect:/all-photosessions";
    }


    @GetMapping("/delete-photosession/{id}")
    public String delete(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        return "delete-photosession";
    }


    @PostMapping("/delete-photosession/{id}")
    public String deletePhotoSession(@PathVariable long id, RedirectAttributes redirectAttributes) {
        photoSessionService.deleteSession(id);
        redirectAttributes.addFlashAttribute(NOTIFICATION_ATTRIBUTE, "Usunięto sesję");
        return "redirect:/all-photosessions";
    }
}

//    @GetMapping("/delete-photosession/{id}")
//    public String deletePhotoSession(@PathVariable long id, PhotoSessionDto photoSessionDto) {
//        photoSessionService.deleteSession(id, photoSessionDto);
//        return "redirect:/all-photosessions";
//    }


//    @PostMapping("/photosession/update")
//    public String updatePhotosession(@RequestParam long id, PhotoSessionDto photoSession){
//        photoSessionService.updateSession(photoSession,id);
//        System.out.println("Dane zostały zaktualinowane");
//        return "redirect:/photosession/{id}";
//    }


