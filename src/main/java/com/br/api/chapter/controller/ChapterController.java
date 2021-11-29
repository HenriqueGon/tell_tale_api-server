package com.br.api.chapter.controller;

import com.br.api.chapter.repository.ChapterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.br.api.chapter.model.Chapter;

@RestController
public class ChapterController {
  
  @Autowired
  private ChapterRepository chapterRepository;

  @GetMapping("/chapters")
  public List<Chapter> findAll() {
    return this.chapterRepository.findAll();
  }

  @PostMapping("/chapters/save")
  @ResponseStatus(HttpStatus.CREATED)
  public Chapter add(@RequestBody Chapter Chapter) {
    return this.chapterRepository.save(Chapter);
  }

  @DeleteMapping("/chapters")
  public void remove(@RequestBody Chapter chapter) {
    this.chapterRepository.delete(chapter);
  }
}
