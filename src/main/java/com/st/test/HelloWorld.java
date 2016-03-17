package com.st.test;
//s
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class HelloWorld {
	public static void main(String[] args) {
		
		//读取配置文件。初始化SecurityManager工厂
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
	
		//获取SecurityManager实例
		SecurityManager securitymanager = factory.getInstance();
		
		//把SecurityManager绑定到SecurityUtils
		SecurityUtils.setSecurityManager(securitymanager);
		
		//得到当前执行的用户
		Subject currentUser = SecurityUtils.getSubject();
		
		//创建token令牌，用户名/密码形式
		UsernamePasswordToken token = new UsernamePasswordToken("admin","admin");
		
		//身份认证 
		try {
			currentUser.login(token);
			System.out.println("登陆成功！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("认证失败！");
		}
		
		//退出
		currentUser.logout();
		
	
	}
}
