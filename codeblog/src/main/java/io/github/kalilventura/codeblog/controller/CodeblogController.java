package io.github.kalilventura.codeblog.controller;

import io.github.kalilventura.codeblog.model.Post;
import io.github.kalilventura.codeblog.service.ICodeblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
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

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id") Long id) {
        Post post = codeblogService.findById(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("postDetails");
        // A chave que será buscada para buscar os dados na view
        modelAndView.addObject("post", post);

        return modelAndView;
    }

    @RequestMapping(value = "/newpost", method = RequestMethod.GET)
    public String getPostForm(){
        return "postForm";
    }

    @RequestMapping(value = "/newpost", method = RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors()){
            return "redirect:/newpost";
        }
        post.setDataCriacao(LocalDate.now());
        codeblogService.save(post);

        return "redirect:/posts";
    }

}
