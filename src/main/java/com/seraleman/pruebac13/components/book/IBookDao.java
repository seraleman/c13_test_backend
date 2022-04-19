package com.seraleman.pruebac13.components.book;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IBookDao extends MongoRepository<Book, String> {

}
