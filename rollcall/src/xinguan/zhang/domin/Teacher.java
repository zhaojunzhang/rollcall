package xinguan.zhang.domin;

import java.sql.Timestamp;
import java.util.List;
/*
 * ΩÃ ¶±Ì
 */
public class Teacher {
   private int id;
   private String username;
   private String password;
   private String nickname;
   private String email;
   private String role;
   private Timestamp registtime;    
   private int state;
   private String activecode;
   private List<Course> courses;
public int getId() {
	return id;
}
public List<Course> getCourses() {
	return courses;
}
public void setCourses(List<Course> courses) {
	this.courses = courses;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getNickname() {
	return nickname;
}
public void setNickname(String nickname) {
	this.nickname = nickname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public Timestamp getRegisttime() {
	return registtime;
}
public void setRegisttime(Timestamp registtime) {
	this.registtime = registtime;
}
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
public String getActivecode() {
	return activecode;
}
public void setActivecode(String activecode) {
	this.activecode = activecode;
}
}
