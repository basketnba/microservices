package com.epam.training.microservices.service.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.epam.training.microservices.service.graphql.post.Post;
import com.epam.training.microservices.service.graphql.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

  @Autowired
  private PostRepository postRepository;

  public Post renamePost(Integer id, String title) {
    final Post post = postRepository.findById(id.longValue()).get();
    post.setTitle(title);
    return postRepository.save(post);
  }
}