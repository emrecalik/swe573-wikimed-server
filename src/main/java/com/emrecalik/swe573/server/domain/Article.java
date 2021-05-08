package com.emrecalik.swe573.server.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "article", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "entity_id",
                "user_id"
        })
})
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entity_id")
    private Long entityId;

    private String title;

    @Lob
    private String articleAbstract;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "article_id")
    private Set<ArticleAuthor> authors = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "article_keyword",
            joinColumns = @JoinColumn(name = "article_id"))
    @Column(name = "keyword")
    private Set<String> keywords = new HashSet<>();

    @JsonBackReference
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "article_wiki_item",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "wiki_item_id"))
    private Set<WikiItem> wikiItems = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "article_id")
    private Set<Rate> rates = new HashSet<>();
}