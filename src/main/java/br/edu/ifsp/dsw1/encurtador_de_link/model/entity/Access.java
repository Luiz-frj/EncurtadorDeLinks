package br.edu.ifsp.dsw1.encurtador_de_link.model.entity;

public class Access {
	private String link;
	private String ip;
	
	public Access(String link, String ip) {
		setLink(link);
		setIp(ip);
	}
	
	public String getLink() {
		return link;
	}
	private void setLink(String link) {
		this.link = link;
	}
	public String getIp() {
		return ip;
	}
	private void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "Access [link=" + link + ", ip=" + ip + "]";
	}
}
