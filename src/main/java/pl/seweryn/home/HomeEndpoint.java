package pl.seweryn.home;

import org.springframework.web.bind.annotation.RequestMapping;

public class HomeEndpoint {
    @RequestMapping("/")
    public String home() {
        return "index.html";
    }   
}