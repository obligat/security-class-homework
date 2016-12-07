package data;
public class UserBean {

	private int id;
	private String username;
	private String password;
	private String publicKey;
	private String digestAlgorithm;
	private String RSA;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRSA() {
		return RSA;
	}

	public void setRSA(String rSA) {
		RSA = rSA;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getDigestAlgorithm() {
		return digestAlgorithm;
	}

	public void setDigestAlgorithm(String digestAlgorithm) {
		this.digestAlgorithm = digestAlgorithm;
	}

	public String getAsymCryptography() {
		return RSA;
	}

	public void setAsymCryptography(String asymCryptography) {
		this.RSA = asymCryptography;
	}

}
