package com.efass;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {

//    Logger logger = LoggerFactory.getLogger(HtmlController.class);

    @RequestMapping("/{page:^(?!.*[.].*$).*$}")
    public String requestPage(@PathVariable("page") String page) {
        String htmlPage = "/"+page+".html";
        System.out.println("forwarding request to {}"+ htmlPage);
        return htmlPage;
    }
}