package io.github.kalilventura.codeblog.repository;

import io.github.kalilventura.codeblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeBlogRepository  extends JpaRepository<Post, Long> {

}
