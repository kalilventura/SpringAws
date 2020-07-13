package io.github.kalilventura.codeblog.service.Impl;

import io.github.kalilventura.codeblog.model.Post;
import io.github.kalilventura.codeblog.repository.CodeBlogRepository;
import io.github.kalilventura.codeblog.service.ICodeblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeblogService implements ICodeblogService {

    @Autowired
    private CodeBlogRepository codeBlogRepository;

    @Override
    public List<Post> findAll() {
        return codeBlogRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return codeBlogRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return codeBlogRepository.save(post);
    }
}
