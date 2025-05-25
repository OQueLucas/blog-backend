package com.oquelucas.blog.config;

import com.oquelucas.blog.domain.User;
import com.oquelucas.blog.domain.post.Author;
import com.oquelucas.blog.domain.post.Comment;
import com.oquelucas.blog.domain.post.Post;
import com.oquelucas.blog.repository.PostRepository;
import com.oquelucas.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Date;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User user1 = new User(null, "Alice Silva", "alice.silva@example.com");
        User user2 = new User(null, "Bruno Costa", "bruno.costa@example.com");
        User user3 = new User(null, "Carla Mendes", "carla.mendes@example.com");
        User user4 = new User(null, "Diego Rocha", "diego.rocha@example.com");
        User user5 = new User(null, "Eduarda Lima", "eduarda.lima@example.com");

        userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5));

        Post post1 = new Post(null, daysAgo(1), "Descobrindo o Java", "Uma introdução simples ao mundo da programação Java.", new Author(user1));
        Post post2 = new Post(null, daysAgo(2), "Spring Boot para Iniciantes", "Como criar sua primeira API com Spring Boot.", new Author(user2));
        Post post3 = new Post(null, daysAgo(3), "Trabalhando com Streams em Java", "Explorando o poder das Streams na manipulação de coleções.", new Author(user3));
        Post post4 = new Post(null, daysAgo(4), "Entendendo o JPA", "Aprenda como usar o JPA para persistência de dados em Java.", new Author(user4));
        Post post5 = new Post(null, daysAgo(5), "Introdução ao Maven", "Gerencie suas dependências com Maven de forma eficiente.", new Author(user5));
        Post post6 = new Post(null, daysAgo(6), "Threads em Java", "Como lidar com programação concorrente em Java.", new Author(user1));
        Post post7 = new Post(null, daysAgo(7), "Tratamento de Exceções", "Boas práticas no uso de exceções em aplicações Java.", new Author(user2));
        Post post8 = new Post(null, daysAgo(8), "REST APIs com Spring", "Crie APIs RESTful com facilidade usando Spring Framework.", new Author(user3));
        Post post9 = new Post(null, daysAgo(9), "Integração com Banco de Dados", "Conectando aplicações Java ao banco de dados com JDBC.", new Author(user4));
        Post post10 = new Post(null, daysAgo(10), "Deploy no Heroku", "Como fazer o deploy de uma aplicação Java no Heroku.", new Author(user5));

        Comment c1 = new Comment("Excelente explicação, me ajudou bastante!", daysAgo(1), new Author(user2));
        Comment c2 = new Comment("Muito didático, parabéns!", daysAgo(1), new Author(user3));
        Comment c3 = new Comment("Esse post esclareceu várias dúvidas.", daysAgo(2), new Author(user4));
        Comment c4 = new Comment("Gostei das dicas práticas.", daysAgo(2), new Author(user5));
        Comment c5 = new Comment("Muito útil para iniciantes!", daysAgo(3), new Author(user1));
        Comment c6 = new Comment("Vou aplicar isso no meu projeto.", daysAgo(3), new Author(user2));
        Comment c7 = new Comment("Conteúdo de qualidade, obrigado por compartilhar.", daysAgo(4), new Author(user3));
        Comment c8 = new Comment("Post muito relevante para meu trabalho.", daysAgo(5), new Author(user4));
        Comment c9 = new Comment("Explicações claras e objetivas.", daysAgo(5), new Author(user5));
        Comment c10 = new Comment("Gostei da abordagem, simples e direta.", daysAgo(6), new Author(user1));
        Comment c11 = new Comment("Ajudou a entender conceitos difíceis.", daysAgo(7), new Author(user2));
        Comment c12 = new Comment("Conteúdo excelente, recomendo!", daysAgo(7), new Author(user3));
        Comment c13 = new Comment("Informações valiosas, muito obrigado!", daysAgo(8), new Author(user4));
        Comment c14 = new Comment("Texto muito bem escrito e explicado.", daysAgo(8), new Author(user5));
        Comment c15 = new Comment("Perfeito para quem está começando.", daysAgo(9), new Author(user1));

        post1.getComments().addAll(Arrays.asList(c1, c2, c5));
        post2.getComments().addAll(Arrays.asList(c3, c6));
        post3.getComments().addAll(Arrays.asList(c4, c7, c12));
        post4.getComments().addAll(Arrays.asList(c8, c11));
        post5.getComments().addAll(Arrays.asList(c9, c13, c14));
        post6.getComments().addAll(Arrays.asList(c10, c15));

        postRepository.saveAll(Arrays.asList(post1, post2, post3, post4, post5, post6, post7, post8, post9, post10));

        user1.getPosts().addAll(Arrays.asList(post1, post6));
        user2.getPosts().addAll(Arrays.asList(post2, post7));
        user3.getPosts().addAll(Arrays.asList(post3, post8));
        user4.getPosts().addAll(Arrays.asList(post4, post9));
        user5.getPosts().addAll(Arrays.asList(post5, post10));
        userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5));
    }

    // Helper para gerar datas N dias atrás
    public static Date daysAgo(int days) {
        return new Date(System.currentTimeMillis() - days * 86_400_000L); // 1 dia = 86.400.000 ms
    }
}

