package edu.ou.cs.hci.stages;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Book {
	public String title;
	public String author;
	public Genre genre;
	
	String imageURL = "bookcover.jpg";
	BufferedImage bookcover;

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
	
	public Book(String title, String author, Genre genre)
	{
		this.title = title;
		this.author = author;
		this.genre = genre;

		// Load book cover image
		URL res_bc = getClass().getResource("bookcover.jpg");
		try {
			bookcover = ImageIO.read(res_bc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
