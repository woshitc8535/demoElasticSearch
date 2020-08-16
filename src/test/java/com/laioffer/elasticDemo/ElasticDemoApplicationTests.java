package com.laioffer.elasticDemo;

import com.laioffer.elasticDemo.entity.Book;
import com.laioffer.elasticDemo.repository.BookRepository;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ElasticDemoApplicationTests {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	RestHighLevelClient client;

	@Test
	void contextLoads() {
	}


	@Test
	public void testInsert(){
		Book book = new Book(2, "Jk.R", "Harry Potter");
		bookRepository.index(book);
	}
	@Test
	public void testRead() throws IOException {
		List<Book> bookList = bookRepository.findBookByName("Harry Potter");
		for (Book book: bookList) {
			System.out.println(book);
		}
//		SearchRequest request = new SearchRequest("test");
//		request.searchType("_doc");
//		SearchSourceBuilder builder = new SearchSourceBuilder();
//		builder.from(0);
//		builder.size(5);
//		builder.query(QueryBuilders.termQuery("name", "Harry"));
//
//		request.source(builder);
//		SearchResponse response = client.search(request, RequestOptions.DEFAULT);

	}

	@Test
	public void testUpdate() throws IOException {
		Map<String, Object> doc = new HashMap<>();
		doc.put("name" , "Harry Potter2");
		UpdateRequest request = new UpdateRequest("test", "_doc", "2");
		request.doc(doc);

		UpdateResponse update = client.update(request, RequestOptions.DEFAULT);

	}


}
