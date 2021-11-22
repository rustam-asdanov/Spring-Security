package com.example.spring_group_one.lesson_three.controller;

import com.example.spring_group_one.lesson_three.dao.NewsDAO;
import com.example.spring_group_one.lesson_three.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager/news")
public class ControllerAdminNews {

    @Autowired
    private NewsDAO newsDAO;
    private final String mainURL = "/manager/news";

    @GetMapping
    public List<News> getNews(){
        return newsDAO.getNewsList();
    }

    @PostMapping
    public String addNews(@RequestBody News theNews){
        newsDAO.getNewsList().add(theNews);
        return mainURL;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteNews(@PathVariable("id") int id){
        newsDAO.deleteNewsById(id);
        return mainURL;
    }

    @PutMapping("/update/{id}")
    public String updateNews(
            @PathVariable("id") int id,
            @RequestBody News theNews
    ){
        newsDAO.updateNewsById(id,theNews);
        return mainURL;
    }
}
