package com.visa.prj.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.visa.prj.entity.Article;

public class ArticleClient {

	public static void main(String[] args) {
		List<Article> articles = new ArrayList<>();
		articles.add(new Article("NoDBA",561,"bliki",Arrays.asList("nosql","people","orm")));
		articles.add(new Article("Infodesk",1145,"bliki",Arrays.asList("nosql","writing")));
		articles.add(new Article("OrmHate",1718,"bliki",Arrays.asList("nosql","orm")));
		articles.add(new Article("ruby",1313,"article",Arrays.asList("ruby")));
		articles.add(new Article("DDD_Aggregate",482,"bliki",Arrays.asList("nosql","ddd")));
		
		printTotalWordCount(articles); // 5219
		printArticlesByType(articles); //{bliki:4, article: 1}
		
		// use flatMap, Function.identity and groupingby and Collectors.counting to solve this
		printTagCount(articles); // nosql: 4, ruby : 1, 
	}

	private static void printTagCount(List<Article> articles) {
		 articles.stream()
		 .map(a -> a.getTags())
		 .flatMap(list -> list.stream())
		 .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		 .forEach((k, v) -> {
			 System.out.println(k + ": " + v);
		 });
	}
		

	private static void printArticlesByType(List<Article> articles) {
		articles.stream()
		.collect(Collectors
				.groupingBy(a -> a.getType())).forEach((k, v) -> {
			System.out.println(k + ": " + v);
		});
	}

	private static void printTotalWordCount(List<Article> articles) {
		int wordCount = articles.stream().map(a -> a.getWords()).reduce(0, (a1, a2) -> a1 + a2);
		System.out.println(wordCount);
		
	}

}
