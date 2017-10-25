package com.logiston.repository;

import com.logiston.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Pavel Putrenkov
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
}