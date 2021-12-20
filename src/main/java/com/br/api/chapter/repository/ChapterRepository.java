package com.br.api.chapter.repository;

import java.util.List;

import com.br.api.chapter.model.Chapter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterRepository extends JpaRepository<Chapter, Long>{

  List<Chapter> findChaptersByTaleName(String name);
}
