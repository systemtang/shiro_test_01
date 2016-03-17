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
		
		//��ȡ�����ļ�����ʼ��SecurityManager����
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
	
		//��ȡSecurityManagerʵ��
		SecurityManager securitymanager = factory.getInstance();
		
		//��SecurityManager�󶨵�SecurityUtils
		SecurityUtils.setSecurityManager(securitymanager);
		
		//�õ���ǰִ�е��û�
		Subject currentUser = SecurityUtils.getSubject();
		
		//����token���ƣ��û���/������ʽ
		UsernamePasswordToken token = new UsernamePasswordToken("admin","admin");
		
		//�����֤ 
		try {
			currentUser.login(token);
			System.out.println("��½�ɹ���");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��֤ʧ�ܣ�");
		}
		
		//�˳�
		currentUser.logout();
		
	
	}
}
