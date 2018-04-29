package edu.ou.cs.hci.stages;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Book {
	public String title;
	public String author;
	public Genre genre;
	public String year;
	public String series;
	public String rating;

	String imageURL = "bookcover.jpg";
	BufferedImage bookcover;

	static HashMap<String, Genre> genreStrings = new HashMap<String, Genre>();

	// Static enum of all possible genres
	public static enum Genre {
		ACTION("Action"),
		ANTHOLOGY("Anthology"),
		ART("Art"),
		BIOGRAPHY("Biography"),
		CHILDREN("Children"),
		COMICS("Comics"),
		COOKBOOKS("Cookbooks"),
		DIARIES("Diaries"),
		DICTIONARY("Dictionary"),
		DRAMA("Drama"),
		ENCYCLOPEDIA("Encyclopedia"),
		FANTASY("Fantasy"),
		FICTION("Fiction"),
		HISTORY("History"),
		HORROR("Horror"),
		JOURNALS("Journals"),
		MATH("Math"),
		MYSTERY("Mystery"),
		POETRY("Poetry"),
		PROPAGANDA("Propaganda"),
		RELIGION("Religion"),
		ROMANCE("Romance"),
		SATIRE("Satire"),
		SCIENCE("Science"),
		SCIENCE_FICTION("Science Fiction"),
		TRAVEL("Travel");
		
		private String name;
		 
	    Genre(String genreName) {
	        this.name = genreName;
	    }
	 
	    public String getName() {
	        return name;
	    }
	}
	
	public Book(String title, String author, String year, String series, String rating, Genre genre, String imageURL)
	{
		this.title = title;
		this.author = author;
		this.year = year;
		this.series = series;
		this.rating = rating;
		this.genre = genre;
		this.imageURL = imageURL;

		// Load book cover image
		URL res_bc = getClass().getResource(imageURL);
		try {
			bookcover = ImageIO.read(res_bc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Book(String title, String author, String year, String series, String rating, String genre, String imageURL)
	{
	    genreStrings.put("Action", Genre.ACTION);
		genreStrings.put("Anthropology", Genre.ANTHOLOGY);
		genreStrings.put("Art", Genre.ART);
		genreStrings.put("Biography", Genre.BIOGRAPHY);
		genreStrings.put("Children", Genre.CHILDREN);
		genreStrings.put("Comics", Genre.COMICS);
		genreStrings.put("Cookbooks", Genre.COOKBOOKS);
		genreStrings.put("Diaries", Genre.DIARIES);
		genreStrings.put("Dictionary", Genre.DICTIONARY);
		genreStrings.put("Drama", Genre.DRAMA);
		genreStrings.put("Encyclopedia", Genre.ENCYCLOPEDIA);
		genreStrings.put("Fantasy", Genre.FANTASY);
		genreStrings.put("Fiction", Genre.FICTION);
		genreStrings.put("History", Genre.HISTORY);
		genreStrings.put("Horror", Genre.HORROR);
		genreStrings.put("Journals", Genre.JOURNALS);
		genreStrings.put("Math", Genre.MATH);
		genreStrings.put("Mystery", Genre.MYSTERY);
		genreStrings.put("Poetry", Genre.POETRY);
		genreStrings.put("Propaganda", Genre.PROPAGANDA);
		genreStrings.put("Religion", Genre.RELIGION);
		genreStrings.put("Romance", Genre.ROMANCE);
		genreStrings.put("Satire", Genre.SATIRE);
		genreStrings.put("Science", Genre.SCIENCE);
		genreStrings.put("Science Fiction", Genre.SCIENCE_FICTION);
		genreStrings.put("Travel", Genre.TRAVEL);

		this.title = title;
		this.author = author;
		this.year = year;
		this.series = series;
		this.rating = rating;
		this.genre = genreStrings.get(genre);
		this.imageURL = imageURL;

		System.out.println(imageURL);
		// Load book cover image
		URL res_bc = getClass().getResource(imageURL);
		try {
			bookcover = ImageIO.read(res_bc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getCSVLine()
	{
		return title + "," + author +  "," + series + "," + rating + "," + year + "," + genre.name + "," + imageURL;
	}
}
