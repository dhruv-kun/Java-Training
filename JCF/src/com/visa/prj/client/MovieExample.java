package com.visa.prj.client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class MovieExample {

	public static void main(String[] args) {
		/* 
		try (Stream<String> stream = Files.lines(Paths.get("movies.csv"))) {
			stream.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		// A Beautiful Mind Director
		System.out.println("A Beautiful Mind Director");
		printDirector("A Beautiful Mind");
		System.out.println("Top 5 Movies");
		top5Movies();
	}

	private static void top5Movies() {
		try (Stream<String> stream = Files.lines(Paths.get("movies.csv"))) {
			 stream
			.skip(1)
			.map(line -> line.split(";"))
			.filter(movie -> {
				String imdbVotes = movie[9].trim();
				return !imdbVotes.equals("");
			})
			.sorted((movie1, movie2) -> {
				String m1Votes = movie1[9].trim();
				String m2Votes = movie2[9].trim();
				return Integer.valueOf(m2Votes).compareTo(Integer.valueOf(m1Votes));
			})
			.limit(5)
			.forEach(movie -> {
				System.out.println(movie[0] + " --- " + movie[9]);
			});
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void printDirector(String string) {
		try (Stream<String> stream = Files.lines(Paths.get("movies.csv"))) {
				stream
				.skip(1)
				.map(line -> line.split(";"))
				.filter(movie -> {
					String movieName = movie[0];
					return movieName.trim().equalsIgnoreCase("A Beautiful Mind");
				})
				.forEach(movie -> {
					String director = movie[2];
					System.out.println("A Beautiful Mind was directed by " + director);
				});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
