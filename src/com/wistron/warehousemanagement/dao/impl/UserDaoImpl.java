package com.wistron.warehousemanagement.dao.impl;

import java.text.SimpleDateFormat;
import org.dom4j.Document;
import org.dom4j.Element;
import com.wistron.warehousemanagement.dao.IUserDao;
import com.wistron.warehousemanagement.domain.User;
import com.wistron.warehousemanagement.util.XmlUtils;

/**
 * IUserDao�����蝐�
 * @author gacl
 */
public class UserDaoImpl implements IUserDao {

	@Override
	public User find(String userName, String userPwd) {
		try{
			Document document = XmlUtils.getDocument();
			//雿輻XPath銵刻噢撘���ML��
			Element e = (Element) document.selectSingleNode("//user[@userName='"+userName+"' and @userPwd='"+userPwd+"']");
			if(e==null){
				return null;
			}
			User user = new User();
			user.setId(e.attributeValue("id"));
			
			user.setUserPwd(e.attributeValue("userPwd"));
			user.setUserName(e.attributeValue("userName"));
			
			
			
			return user;
		
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void add(User user) {
		try{
			Document document = XmlUtils.getDocument();
			Element root = document.getRootElement();
			Element user_node = root.addElement("user");  //��遣user蝏嚗僎��root
			user_node.setAttributeValue("id", user.getId());
			user_node.setAttributeValue("userName", user.getUserName());
			user_node.setAttributeValue("userPwd", user.getUserPwd());
			
		
			XmlUtils.write2Xml(document);
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public User find(String userName) {
		try{
			Document document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//user[@userName='"+userName+"']");
			if(e==null){
				System.out.println("User is null at Property");
				return null;
			}
			User user = new User();
			user.setId(e.attributeValue("id"));
			
			user.setUserPwd(e.attributeValue("userPwd"));
			user.setUserName(e.attributeValue("userName"));
			
			return user;
		
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
