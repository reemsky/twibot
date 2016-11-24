package lv.glusakovs.twitter;

public class TwitterAccount {
    private String consumerKey;
    private String consumerSecret;
    private String accessToken;
    private String accessTokenSecret;
    
	public String toString(){
		return "consumerKey:" + this.consumerKey + ", consumerSecret:" + this.consumerSecret 
				+ ", accessToken:" + this.accessToken + ", accessSecret:" + this.accessTokenSecret;
		
	}

	public String getConsumerKey() {
		return consumerKey;
	}

	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	public String getConsumerSecret() {
		return consumerSecret;
	}

	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessTokenSecret() {
		return this.accessTokenSecret;
	}

	public void setAccessTokenSecret(String accessTokenSecret) {
		this.accessTokenSecret = accessTokenSecret;
	}
	
	public boolean isValid(){
		if (consumerKey == null || consumerKey.equals("") || consumerSecret == null || consumerSecret.equals("")){
			return false;
		}
		
		if (accessToken == null || accessToken.equals("") || accessTokenSecret == null || accessTokenSecret.equals("")){
			return false;
		}
		return true;
	}

}
