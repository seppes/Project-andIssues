package com.example.demo.repositories;

import com.example.demo.Video;
import org.springframework.data.repository.CrudRepository;

public interface VideoRepository extends CrudRepository<Video, Integer> {
}

