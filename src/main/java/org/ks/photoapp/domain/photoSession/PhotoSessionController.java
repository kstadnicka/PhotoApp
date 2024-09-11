package org.ks.photoapp.domain.photoSession;

import org.ks.photoapp.domain.client.Client;
import org.ks.photoapp.domain.client.dto.ClientDto;
import org.ks.photoapp.domain.photoSession.dto.PhotoSessionDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;


@Controller
public class PhotoSessionController {

    PhotoSessionService photoSessionService;

    @GetMapping("/all-photosessions")
    public String getAllPhotoSession(Model model) {
        List<PhotoSessionDto> photoSession = photoSessionService.getAllPhotoSession();
        model.addAttribute("photoSessions", photoSession);
        return "pohtosessions";
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

    @PostMapping("/photosession/new-photosession")
    public String newPhotoSession(PhotoSessionDto photoSession) {
        photoSessionService.createNewSession(photoSession);
        System.out.println("Dodano nową sesję");
        return "redirect:/all-photosessions";
    }

    @GetMapping("/photosession/delete")
    public String deletePhotoSession(@RequestParam long id) {
        photoSessionService.deleteSession(id);
        System.out.println("Usunięto sesję");
        return "redirect:/all-photosessions";
    }

    @PostMapping("/photosession/update")
    public String updatePhotosession(@RequestParam long id, PhotoSessionDto photoSession){
        photoSessionService.updateSession(photoSession,id);
        System.out.println("Dane zostały zaktualinowane");
        return "redirect:/photosession/{id}";
    }
}
