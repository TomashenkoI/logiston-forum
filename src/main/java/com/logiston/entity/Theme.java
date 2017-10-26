package com.logiston.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel Putrenkov
 */
@Entity
@Getter
@Setter
@ToString
public class Theme implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "themeid")
    private Long themeId;

    private String title;

    public Long getThemeId() {
        return themeId;
    }

    public void setThemeId(Long themeId) {
        this.themeId = themeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "theme_comments",
//            joinColumns = {@JoinColumn(name = "themeId")},
//            inverseJoinColumns = {@JoinColumn(name = "commentsid")})
//    private List<Comment> comments = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,
        mappedBy = "theme")
    private List<Comment> comments = new ArrayList<>();

}
