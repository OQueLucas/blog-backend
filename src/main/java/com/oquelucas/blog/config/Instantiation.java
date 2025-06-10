package com.oquelucas.blog.config;

import com.oquelucas.blog.domain.User;
import com.oquelucas.blog.domain.post.Category;
import com.oquelucas.blog.domain.post.Comment;
import com.oquelucas.blog.domain.post.Post;
import com.oquelucas.blog.domain.post.Tag;
import com.oquelucas.blog.repository.CategoryRepository;
import com.oquelucas.blog.repository.PostRepository;
import com.oquelucas.blog.repository.TagRepository;
import com.oquelucas.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.OffsetDateTime;
import java.util.*;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TagRepository tagRepository;

    Map<String, Category> categories = new HashMap<>();
    Map<String, Tag> tags = new HashMap<>();

    @Override
    public void run(String... args) {

        // Limpa os dados antigos (descomente se quiser limpar)
//         userRepository.deleteAll();
//         postRepository.deleteAll();

        if (userRepository.existsBy() || postRepository.existsBy())
            return;

        initializeCategories();
        initializeTags();

        User user1 = new User("Alice Silva", "alice.silva@example.com");
        User user2 = new User("Bruno Costa", "bruno.costa@example.com");
        User user3 = new User("Carla Mendes", "carla.mendes@example.com");
        User user4 = new User("Diego Rocha", "diego.rocha@example.com");
        User user5 = new User("Eduarda Lima", "eduarda.lima@example.com");

        userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5));

        Post post1 = new Post(daysAgo(1), "Descobrindo o Java", "Uma introdução simples ao mundo da programação Java.",
                "Comece sua jornada no Java com esta introdução simples e clara.", user1);
        post1.setCategories(setCategories("Java", "Programação"));
        post1.setTags(setTags("java", "introdução", "aprendizado"));

        Post post2 = new Post(daysAgo(2), "Spring Boot para Iniciantes", "Como criar sua primeira API com Spring Boot.",
                "Veja como construir uma API com Spring Boot do zero.", user2);
        post2.setCategories(setCategories("Spring", "Backend"));
        post2.setTags(setTags("spring boot", "api","java"));

        Post post3 = new Post(daysAgo(3), "Trabalhando com Streams em Java", "Explorando o poder das Streams na manipulação de coleções.",
                "Aprenda a usar as Streams do Java para processar dados com eficiência.", user3);
        post2.setCategories(setCategories("Java", "Avançado"));
        post3.setTags(setTags("streams", "coleções", "java 8"));

        Post post4 = new Post(daysAgo(4), "Entendendo o JPA", "Aprenda como usar o JPA para persistência de dados em Java.",
                "Conceitos essenciais de JPA e como aplicá-los em seus projetos Java.", user4);
        post4.setCategories(setCategories("Java", "Banco de Dados"));
        post4.setTags(setTags("jpa", "hibernate", "persistência"));

        Post post5 = new Post(daysAgo(5), "Introdução ao Maven", "Gerencie suas dependências com Maven de forma eficiente.",
                "Guia rápido para começar a usar Maven em seus projetos Java.", user5);
        post5.setCategories(setCategories("Ferramentas", "Build"));
        post5.setTags(setTags("maven", "dependências", "build"));

        Post post6 = new Post(daysAgo(6), "Threads em Java", "Como lidar com programação concorrente em Java.",
                "Entenda como funcionam as threads e como usá-las corretamente.", user1);
        post6.setCategories(setCategories("Java", "Concorrência"));
        post6.setTags(setTags("threads", "concorrência", "multithreading"));

        Post post7 = new Post(daysAgo(7), "Tratamento de Exceções", "Boas práticas no uso de exceções em aplicações Java.",
                "Melhore a robustez do seu código com tratamento adequado de exceções.", user2);
        post7.setCategories(setCategories("Java", "Boas Práticas"));
        post7.setTags(setTags("exceções", "try-catch", "erros"));

        Post post8 = new Post(daysAgo(8), "REST APIs com Spring", "Crie APIs RESTful com facilidade usando Spring Framework.",
                "Passo a passo para construir APIs REST usando o Spring Framework.", user3);
        post8.setCategories(setCategories("Spring", "API"));
        post8.setTags(setTags("rest", "spring", "api"));

        Post post9 = new Post(daysAgo(9), "Integração com Banco de Dados", "Conectando aplicações Java ao banco de dados com JDBC.",
                "Veja como fazer a conexão com bancos de dados usando JDBC.", user4);
        post9.setCategories(setCategories("Java", "Banco de Dados"));
        post9.setTags(setTags("jdbc", "sql", "banco de dados"));

        Post post10 = new Post(daysAgo(10), "Deploy no Heroku", "Como fazer o deploy de uma aplicação Java no Heroku.",
                "Guia rápido para publicar sua aplicação Java na nuvem usando Heroku.", user5);
        post10.setCategories(setCategories("DevOps", "Deploy"));
        post10.setTags(setTags("heroku", "deploy", "java", "cloud"));

        Comment c1 = new Comment("Excelente explicação, me ajudou bastante!", user2, post1, null);
        Comment c2 = new Comment("Muito didático, parabéns!", user3, post1, null);
        Comment c3 = new Comment("Esse post esclareceu várias dúvidas.", user4, post2, null);
        Comment c4 = new Comment("Gostei das dicas práticas.", user5, post3, null);
        Comment c5 = new Comment("Muito útil para iniciantes!", user1, post1, null);
        Comment c6 = new Comment("Vou aplicar isso no meu projeto.", user2, post2, null);
        Comment c7 = new Comment("Conteúdo de qualidade, obrigado por compartilhar.", user3, post3, null);
        Comment c8 = new Comment("Post muito relevante para meu trabalho.", user4, post4, null);
        Comment c9 = new Comment("Explicações claras e objetivas.", user5, post5, null);
        Comment c10 = new Comment("Gostei da abordagem, simples e direta.", user1, post6, null);
        Comment c11 = new Comment("Ajudou a entender conceitos difíceis.", user2, post4, null);
        Comment c12 = new Comment("Conteúdo excelente, recomendo!", user3, post3, null);
        Comment c13 = new Comment("Informações valiosas, muito obrigado!", user4, post5, null);
        Comment c14 = new Comment("Texto muito bem escrito e explicado.", user5, post5, null);
        Comment c15 = new Comment("Perfeito para quem está começando.", user1, post6, null);

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

    private void initializeCategories() {
        categories.put("Java", new Category("Java", "Categoria relacionada a Java", null));
        categories.put("Programação", new Category("Programação", "Categoria relacionada a programação", null));
        categories.put("Spring", new Category("Spring", "Categoria para Spring Framework", null));
        categories.put("Backend", new Category("Backend", "Categoria para backend", null));
        categories.put("Avançado", new Category("Avançado", "Categoria avançada", null));
        categories.put("Banco de Dados", new Category("Banco de Dados", "Categoria de banco de dados", null));
        categories.put("Ferramentas", new Category("Ferramentas", "Categoria de ferramentas", null));
        categories.put("Build", new Category("Build", "Categoria de build", null));
        categories.put("Concorrência", new Category("Concorrência", "Categoria de concorrência", null));
        categories.put("Boas Práticas", new Category("Boas Práticas", "Categoria de boas práticas", null));
        categories.put("API", new Category("API", "Categoria API", null));
        categories.put("DevOps", new Category("DevOps", "Categoria DevOps", null));
        categories.put("Deploy", new Category("Deploy", "Categoria Deploy", null));

        categoryRepository.saveAll(categories.values());
    }

    private void initializeTags() {
        tags.put("java", new Tag("java", null));
        tags.put("introdução", new Tag("introdução", null));
        tags.put("aprendizado", new Tag("aprendizado", null));
        tags.put("spring boot", new Tag("spring boot", null));
        tags.put("api", new Tag("api", null));
        tags.put("streams", new Tag("streams", null));
        tags.put("coleções", new Tag("coleções", null));
        tags.put("java 8", new Tag("java 8", null));
        tags.put("jpa", new Tag("jpa", null));
        tags.put("hibernate", new Tag("hibernate", null));
        tags.put("persistência", new Tag("persistência", null));
        tags.put("maven", new Tag("maven", null));
        tags.put("dependências", new Tag("dependências", null));
        tags.put("build", new Tag("build", null));
        tags.put("threads", new Tag("threads", null));
        tags.put("concorrência", new Tag("concorrência", null));
        tags.put("multithreading", new Tag("multithreading", null));
        tags.put("exceções", new Tag("exceções", null));
        tags.put("try-catch", new Tag("try-catch", null));
        tags.put("erros", new Tag("erros", null));
        tags.put("rest", new Tag("rest", null));
        tags.put("spring", new Tag("spring", null));
        tags.put("jdbc", new Tag("jdbc", null));
        tags.put("sql", new Tag("sql", null));
        tags.put("banco de dados", new Tag("banco de dados", null));
        tags.put("heroku", new Tag("heroku", null));
        tags.put("deploy", new Tag("deploy", null));
        tags.put("cloud", new Tag("cloud", null));

        tagRepository.saveAll(tags.values());
    }

    private List<Category> setCategories(String... keys) {
        List<Category> categoriesList = new ArrayList<>();

        for (String key : keys) categoriesList.add(categories.get(key));
        return categoriesList;
    }

    private List<Tag> setTags(String... keys) {
        List<Tag> tagsList = new ArrayList<>();

        for (String key : keys) tagsList.add(tags.get(key));
        return tagsList;
    }

    private OffsetDateTime daysAgo(int days) {
        return OffsetDateTime.now().minusDays(days);
    }
}
