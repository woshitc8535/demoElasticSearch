package com.laioffer.elasticDemo.configuration;



import org.apache.http.Header;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.*;

import org.elasticsearch.client.core.MainResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.omg.CORBA.portable.UnknownException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.io.IOException;


@Configuration
@EnableElasticsearchRepositories(basePackages = "com.laioffer.elasticDemo.repository")
//@ComponentScan(basePackages = { "com.baeldung.spring.data.es.service" })
public class ElasticSearchConfig {

    @Bean
    public RestHighLevelClient client() {
//        ClientConfiguration clientConfiguration
//                = ClientConfiguration.builder()
//                .connectedTo("https://d6cf1b4217804bcabcf434eb25691c3d.us-east-1.aws.found.io:9243")
//                .build();
//
//        final RestHighLevelClient rest = RestClients.create(clientConfiguration).rest();
//        return rest;

//        RestHighLevelClient client = new RestHighLevelClient(
//                RestClient.builder("travelplanner:dXMtZWFzdC0xLmF3cy5mb3VuZC5pbyRkNmNmMWI0MjE3ODA0YmNhYmNmNDM0ZWIyNTY5MWMzZCQxMjliZTZkMzEwNTk0NTY4YjE2MDgxMjQ1NWUxYWYwZg==").setDefaultHeaders
//                        (new Header[]{new BasicHeader("Authorization", "Bearer " + "YzJqLWg2ZTRUY1MxSTc2akZSVGc5dw==")}));


        final CredentialsProvider credentialsProvider =
                new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials("elastic", "uZrhKktrdFY7KmkWrmFn5N7J"));

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder("travelplanner:dXMtZWFzdC0xLmF3cy5mb3VuZC5pbyRkNmNmMWI0MjE3ODA0YmNhYmNmNDM0ZWIyNTY5MWMzZCQxMjliZTZkMzEwNTk0NTY4YjE2MDgxMjQ1NWUxYWYwZg==").setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder
                        .setDefaultCredentialsProvider(credentialsProvider)));

        return client;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(client());
    }
}
