package com.oquelucas.blog.config;

import com.oquelucas.blog.domain.User;
import com.oquelucas.blog.domain.post.Comment;
import com.oquelucas.blog.domain.post.Post;
import com.oquelucas.blog.repository.PostRepository;
import com.oquelucas.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.OffsetDateTime;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) {

        // Limpa os dados antigos (descomente se quiser limpar)
//         userRepository.deleteAll();
//         postRepository.deleteAll();

        if (userRepository.existsBy() || postRepository.existsBy())
            return;

        User user1 = new User("Alice Silva", "alice.silva@example.com");
        User user2 = new User("Bruno Costa", "bruno.costa@example.com");
        User user3 = new User("Carla Mendes", "carla.mendes@example.com");
        User user4 = new User("Diego Rocha", "diego.rocha@example.com");
        User user5 = new User("Eduarda Lima", "eduarda.lima@example.com");

        userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5));

        Post post1 = new Post(daysAgo(1), "Descobrindo o Java", "Uma introdução simples ao mundo da programação Java.",
                "Comece sua jornada no Java com esta introdução simples e clara.", user1);
        post1.setCategories(Arrays.asList("Java", "Programação"));
        post1.setTags(Arrays.asList("java", "introdução", "aprendizado"));

        Post post2 = new Post(daysAgo(2), "Spring Boot para Iniciantes", "Como criar sua primeira API com Spring Boot.",
                "Veja como construir uma API com Spring Boot do zero.", user2);
        post2.setCategories(Arrays.asList("Spring", "Backend"));
        post2.setTags(Arrays.asList("spring boot", "api", "java"));

        Post post3 = new Post(daysAgo(3), "Trabalhando com Streams em Java", "Explorando o poder das Streams na manipulação de coleções.",
                "Aprenda a usar as Streams do Java para processar dados com eficiência.", user3);
        post3.setCategories(Arrays.asList("Java", "Avançado"));
        post3.setTags(Arrays.asList("streams", "coleções", "java 8"));

        Post post4 = new Post(daysAgo(4), "Entendendo o JPA", "Aprenda como usar o JPA para persistência de dados em Java.",
                "Conceitos essenciais de JPA e como aplicá-los em seus projetos Java.", user4);
        post4.setCategories(Arrays.asList("Java", "Banco de Dados"));
        post4.setTags(Arrays.asList("jpa", "hibernate", "persistência"));

        Post post5 = new Post(daysAgo(5), "Introdução ao Maven", "Gerencie suas dependências com Maven de forma eficiente.",
                "Guia rápido para começar a usar Maven em seus projetos Java.", user5);
        post5.setCategories(Arrays.asList("Ferramentas", "Build"));
        post5.setTags(Arrays.asList("maven", "dependências", "build"));

        Post post6 = new Post(daysAgo(6), "Threads em Java", "Como lidar com programação concorrente em Java.",
                "Entenda como funcionam as threads e como usá-las corretamente.", user1);
        post6.setCategories(Arrays.asList("Java", "Concorrência"));
        post6.setTags(Arrays.asList("threads", "concorrência", "multithreading"));

        Post post7 = new Post(daysAgo(7), "Tratamento de Exceções", "Boas práticas no uso de exceções em aplicações Java.",
                "Melhore a robustez do seu código com tratamento adequado de exceções.", user2);
        post7.setCategories(Arrays.asList("Java", "Boas Práticas"));
        post7.setTags(Arrays.asList("exceções", "try-catch", "erros"));

        Post post8 = new Post(daysAgo(8), "REST APIs com Spring", "Crie APIs RESTful com facilidade usando Spring Framework.",
                "Passo a passo para construir APIs REST usando o Spring Framework.", user3);
        post8.setCategories(Arrays.asList("Spring", "API"));
        post8.setTags(Arrays.asList("rest", "spring", "api"));

        Post post9 = new Post(daysAgo(9), "Integração com Banco de Dados", "Conectando aplicações Java ao banco de dados com JDBC.",
                "Veja como fazer a conexão com bancos de dados usando JDBC.", user4);
        post9.setCategories(Arrays.asList("Java", "Banco de Dados"));
        post9.setTags(Arrays.asList("jdbc", "sql", "banco de dados"));

        Post post10 = new Post(daysAgo(10), "Deploy no Heroku", "Como fazer o deploy de uma aplicação Java no Heroku.",
                "Guia rápido para publicar sua aplicação Java na nuvem usando Heroku.", user5);
        post10.setCategories(Arrays.asList("DevOps", "Deploy"));
        post10.setTags(Arrays.asList("heroku", "deploy", "java", "cloud"));

        Comment c1 = new Comment("Excelente explicação, me ajudou bastante!", user2, post1,null);
        Comment c2 = new Comment("Muito didático, parabéns!", user3, post1,null);
        Comment c3 = new Comment("Esse post esclareceu várias dúvidas.", user4, post2,null);
        Comment c4 = new Comment("Gostei das dicas práticas.", user5, post3,null);
        Comment c5 = new Comment("Muito útil para iniciantes!", user1, post1,null);
        Comment c6 = new Comment("Vou aplicar isso no meu projeto.", user2, post2,null);
        Comment c7 = new Comment("Conteúdo de qualidade, obrigado por compartilhar.", user3, post3,null);
        Comment c8 = new Comment("Post muito relevante para meu trabalho.", user4, post4,null);
        Comment c9 = new Comment("Explicações claras e objetivas.", user5, post5,null);
        Comment c10 = new Comment("Gostei da abordagem, simples e direta.", user1, post6,null);
        Comment c11 = new Comment("Ajudou a entender conceitos difíceis.", user2, post4,null);
        Comment c12 = new Comment("Conteúdo excelente, recomendo!", user3, post3,null);
        Comment c13 = new Comment("Informações valiosas, muito obrigado!", user4, post5,null);
        Comment c14 = new Comment("Texto muito bem escrito e explicado.", user5, post5,null);
        Comment c15 = new Comment("Perfeito para quem está começando.", user1, post6,null);

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

    private OffsetDateTime daysAgo(int days) {
        return OffsetDateTime.now().minusDays(days);
    }
}

