package org.ks.photoapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientsController {

    @GetMapping("/clients")
    public String clients() {
        return "clients";
    }
}
