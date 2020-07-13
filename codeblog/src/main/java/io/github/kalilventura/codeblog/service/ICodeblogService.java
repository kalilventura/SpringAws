package io.github.kalilventura.codeblog.service;

import io.github.kalilventura.codeblog.model.Post;

import java.util.List;

public interface ICodeblogService {
    List<Post> findAll();
    Post findById(Long id);
    Post save(Post post);
}
