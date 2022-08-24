/**
 * 
 */
package com.tera.homepage.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ElasticsearchClientConfig {

	@Bean
	public ElasticsearchClient elasticsearchClient() {
		JacksonJsonpMapper jacksonJsonpMapper = new JacksonJsonpMapper();
		jacksonJsonpMapper.objectMapper().registerModule(new JavaTimeModule());
		jacksonJsonpMapper.objectMapper().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		ElasticsearchTransport transport = new RestClientTransport(buildRestClient(), jacksonJsonpMapper);
		return new ElasticsearchClient(transport);
	}

	private RestClient buildRestClient() {
		return RestClient.builder(
				new HttpHost("localhost", 9200)).build();
	}

}
