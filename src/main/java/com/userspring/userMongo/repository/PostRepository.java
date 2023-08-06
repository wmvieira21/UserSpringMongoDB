package com.userspring.userMongo.repository;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.userspring.userMongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	/*
	 * Consulta é criada automaticamente com base no nome do método
	 * (ContainingIgnoreCase) São métodos especiais (Query Methods) que o Spring
	 * fornece.
	 * 
	 * https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/
	 * https://docs.spring.io/spring-data/data-document/docs/current/reference/html/
	 */
	List<Post> findByTitleContainingIgnoreCase(String text);

	/*
	 * https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/
	 * https://docs.spring.io/spring-data/data-document/docs/current/reference/html/
	 * https://docs.mongodb.com/manual/reference/operator/query/regex/
	 */
	@Query("{ title: { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);

	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearchTitle(String text, LocalDate miDate, LocalDate maxDate);
}
