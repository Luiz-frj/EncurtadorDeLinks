package br.edu.ifsp.dsw1.encurtador_de_link.model.entity;

import java.util.Random;

public class Link {
	private String shortLink;
	private String link;
	private String userName;
	private int size = 5;
	
	public Link(String shortLink, String link) {
		setShortLink(shortLink);
		setLink(link);
	}
	public Link(String link) {
		setLink(link);
		setShortLink(generateShortLink());
	}
	public Link(String shortLink, String link, String userName) {
		setShortLink(shortLink);
		setLink(link);
		setUserName(userName);
	}
	public Link(String link, User user) {
		setShortLink(generateShortLink());
		setLink(link);
		setUserName(user.getName());
	}
	
	public String getShortLink() {
		return shortLink;
	}
	public String getLink() {
		return link;
	}
	public String getUserName() {
		return userName;
	}
	
	private void setUserName(String userName) {
		this.userName = userName;
	}
	private void setShortLink(String shortLink) {
		this.shortLink = shortLink;
	}
	private void setLink(String link) {
		this.link = link;
	}
	
	public void change_short_link() {
		if (size < 12) {
			size++;
		}
		setShortLink(generateShortLink());
	}

	protected String generateShortLink() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz_1234567890";
        StringBuilder string_builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int index = (int) (random.nextFloat() * chars.length());
            string_builder.append(chars.charAt(index));
        }
        String generatedLink = string_builder.toString();
        return generatedLink;

    }
	@Override
	public String toString() {
		return "Link [shortLink=" + shortLink + ", link=" + link + ", userName=" + userName + ", size=" + size + "]";
	}
	
}