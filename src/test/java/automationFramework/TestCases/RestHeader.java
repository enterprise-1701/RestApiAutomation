package automationFramework.TestCases;

public class RestHeader {
	
	private String authorization;
	private String xCubUid;
	private String xCubDevice;
	
	public RestHeader(){
		authorization = "d2ViOnBhc3N3b3jk";
		xCubUid = "11111111111";
		xCubDevice = "web";
	}
	
	public String getAuthorization() {
		return authorization;
	}
	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}
	public String getxCubUid() {
		return xCubUid;
	}
	public void setxCubUid(String xCubUid) {
		this.xCubUid = xCubUid;
	}
	public String getxCubDevice() {
		return xCubDevice;
	}
	public void setxCubDevice(String xCubDevice) {
		this.xCubDevice = xCubDevice;
	}
   	

}
