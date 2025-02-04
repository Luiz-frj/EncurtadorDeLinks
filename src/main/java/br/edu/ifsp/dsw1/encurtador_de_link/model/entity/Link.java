package br.edu.ifsp.dsw1.encurtador_de_link.model.entity;

import java.util.Random;

public class Link {
	private String shortLink;
	private String link;
	private User user;
	
	public Link(String shortLink, String link, User user) {
		setShortLink(shortLink);
		setLink(link);
		setUser(user);
	}
	
	public String getShortLink() {
		return shortLink;
	}
	public String getLink() {
		return link;
	}
	public User getUser() {
		return user;
	}

	private void setUser(User user) {
		this.user = user;
	}
	private void setShortLink(String shortLink) {
		this.shortLink = shortLink;
	}
	private void setLink(String link) {
		this.link = link;
	}

	protected String generateShortLink(int size) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder string_builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int index = (int) (random.nextFloat() * chars.length());
            string_builder.append(chars.charAt(index));
        }
        String generatedLink = string_builder.toString();
        return generatedLink;

    }
}