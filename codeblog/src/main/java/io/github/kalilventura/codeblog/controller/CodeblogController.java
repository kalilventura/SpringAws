package io.github.kalilventura.codeblog.controller;

import io.github.kalilventura.codeblog.model.Post;
import io.github.kalilventura.codeblog.service.ICodeblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CodeblogController {

    @Autowired
    private ICodeblogService codeblogService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts() {
        List<Post> posts = codeblogService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("posts");
        // A chave que será buscada para buscar os dados na view
        modelAndView.addObject("posts", posts);

        return modelAndView;
    }
}
