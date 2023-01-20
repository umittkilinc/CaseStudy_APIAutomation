package resources;

public enum APIResources {

	LoginAPI("/api/login"),
	CreateUserAPI("/api/v1/users/"),
	AssignSessionAPI("/api/v1/sessions"),
	SessionTemplatesAPI("api/v1/session-templates");

	private String resource;
	
	APIResources(String resource) {
		this.resource=resource;
	}
	
	public String getResource() {
		return resource;
	}
}
