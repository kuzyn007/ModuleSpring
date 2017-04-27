package pl.javastart.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public class HomeEndpoint {
    @RequestMapping("/")
    public String home() {
        return "index.html";
    }   
}