package cn.bluethink.dto;

public class UserDTO {
	/** �û����� */
    private String userName;
    /** �û��Ա� */
    private Integer userSex;
    /** �û����� */
    private Integer userAge;
    /** �û��ֻ��� */
    private String userPhone;
    /** �û����� */
    private String userEmail;
    /** �û����� */
    private String userPassword;
    /** �û�Ȩ�� */
    private String userAuth;
    
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserSex() {
		return userSex;
	}
	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}
	public Integer getUserAge() {
		return userAge;
	}
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserAuth() {
		return userAuth;
	}
	public void setUserAuth(String userAuth) {
		this.userAuth = userAuth;
	}
	@Override
	public String toString() {
		return "UserDTO [userName=" + userName + ", userSex=" + userSex + ", userAge=" + userAge + ", userPhone="
				+ userPhone + ", userEmail=" + userEmail + ", userPassword=" + userPassword + ", userAuth=" + userAuth
				+ "]";
	}
    
    
}
