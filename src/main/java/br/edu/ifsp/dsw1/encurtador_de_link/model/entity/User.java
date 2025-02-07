package br.edu.ifsp.dsw1.encurtador_de_link.model.entity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
	private String name;
	private String password;
	
	public User(String name, String password, Boolean newUser) {
		setName(name);
		if (newUser) {
			setPassword(sha256(password));
		} else {
			setPassword(password);
		}
	}

	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	
	private void setName(String name) {
		this.name = name;
	}
	private void setPassword(String password) {
		this.password = password;
	}
	
	public Boolean verify(String password) {
		if (sha256(password).equals(this.password)) {
			return true;
		}
		return false;
	}
	
	private static String sha256(String password) {
        try {
            var digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = digest.digest(password.getBytes());

            var string_builder = new StringBuilder();
            for (byte b : bytes) {
                String h = Integer.toHexString(0xff & b);
                if (h.length() == 1) {
                	string_builder.append('0');
                }
                string_builder.append(h);
            }
            return string_builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + "]";
	}
}
