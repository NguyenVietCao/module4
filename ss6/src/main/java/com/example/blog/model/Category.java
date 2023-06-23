package com.example.blog.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private int categoryId;

    @Column(name = "category_name")
   private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Blog> blogList;

    public Category() {
    }

    public Category(int categoryId, String categoryName, List<Blog> blogList) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.blogList = blogList;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}
