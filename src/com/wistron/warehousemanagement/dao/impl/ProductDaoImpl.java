package com.wistron.warehousemanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.wistron.warehousemanagement.util.JdbcUtils;
import com.wistron.warehousemanagement.dao.IProductDao;
import com.wistron.warehousemanagement.domain.Product;

public class ProductDaoImpl implements IProductDao {

	@Override
	public List<Product> query(Product product,int page) {
		// TODO Auto-generated method stub
		int currentpage=page;
		int count = 0;
		ArrayList<Product> list = new ArrayList<Product>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			
			
			
			

			int idInt = 0;
			String idString = "";
			if (product.getId() != "" && product.getId() != "null" && product.getId() != null) {
				count++;
				idInt = count;
				idString = "id=?";
			}
			int typeInt = 0;
			String typeString = "";
			if (product.getType() != "" && product.getType() != "null" && product.getType() != null) {
				count++;
				typeInt = count;
				typeString = "type=?";
			}

			int nameInt = 0;
			String nameString = "";
			if (product.getName() != "" && product.getName() != "null" && product.getName() != null) {

				count++;
				nameInt = count;
				nameString = "name=?";
			}
			int priceInt = 0;
			String priceString = "";
			if (product.getPrice() != "" && product.getPrice() != "null" && product.getPrice() != null) {
				count++;
				priceInt = count;
				priceString = "price=?";
			}
			int modifiedTimeInt = 0;
			String modifiedTimeString = "";
			if (product.getModifiedTime() != "" && product.getModifiedTime() != "null"
					&& product.getModifiedTime() != null) {
				count++;
				modifiedTimeInt = count;
				modifiedTimeString = "modifiedTime=?";
			}
			int keeperInt = 0;
			String keeperString = "";
			if (product.getKeeper() != "" && product.getKeeper() != "null" && product.getKeeper() != null) {
				count++;
				keeperInt = count;
				keeperString = "keeper=?";
			}
			int locationInt = 0;
			String locationString = "";
			if (product.getLocation() != "" && product.getLocation() != "null" && product.getLocation() != null) {
				count++;
				locationInt = count;
				locationString = "location=?";
			}
			int quantityInt = 0;
			String quantityString = "";
			if (product.getQuantity() != 0) {
				count++;
				quantityInt = count;
				quantityString = "quantity=?";
			}

			String sqlString = "select * from product where ";

			if (product.getId() != "" && product.getId() != "null" && product.getId() != null) {
				sqlString = sqlString + idString;

			}

			if (product.getType() != "" && product.getType() != "null" && product.getType() != null) {
				if (typeInt > 1)
					sqlString = sqlString + " and " + typeString;
				else {
					sqlString = sqlString + typeString;
				}

			}

			if (product.getName() != "" && product.getName() != "null" && product.getName() != null) {
				if (nameInt > 1)
					sqlString = sqlString + " and " + nameString;
				else {
					sqlString = sqlString + nameString;
				}
			}

			if (product.getPrice() != "" && product.getPrice() != "null" && product.getPrice() != null) {
				if (priceInt > 1) {
					sqlString = sqlString + " and " + priceString;
				} else {
					sqlString = sqlString + priceString;
				}
			}

			if (product.getModifiedTime() != "" && product.getModifiedTime() != "null"
					&& product.getModifiedTime() != null) {
				if (modifiedTimeInt > 1) {
					sqlString = sqlString + " and " + modifiedTimeString;
				} else {
					sqlString = sqlString + modifiedTimeString;
				}
			}

			if (product.getKeeper() != "" && product.getKeeper() != "null" && product.getKeeper() != null) {
				if (keeperInt > 1) {
					sqlString = sqlString + " and " + keeperString;
				} else {
					sqlString = sqlString + keeperString;
				}
			}

			if (product.getLocation() != "" && product.getLocation() != "null" && product.getLocation() != null) {
				if (locationInt > 1) {
					sqlString = sqlString + " and " + locationString;
				} else {
					sqlString = sqlString + locationString;
				}
			}

			if (product.getQuantity() != 0) {
				if (quantityInt > 1) {
					sqlString = sqlString + " and " + quantityString;
				} else {
					sqlString = sqlString + quantityString;
				}
			}
			
			
//			sqlString = sqlString + "order by id asc limit ?,5";
//			// ����銵�霂哨蕭?
			
			if(currentpage==0) {
			System.out.println(sqlString);

			st = conn.prepareStatement(sqlString);

			if (idInt != 0) {
				st.setString(idInt, product.getId());
			}

			if (typeInt != 0) {
				st.setString(typeInt, product.getType());
			}

			if (nameInt != 0) {
				st.setString(nameInt, product.getName());

			}

			if (priceInt != 0) {
				st.setString(priceInt, product.getPrice());
			}

			if (modifiedTimeInt != 0) {
				st.setString(modifiedTimeInt, product.getModifiedTime());
			}

			if (keeperInt != 0) {
				st.setString(keeperInt, product.getKeeper());
			}

			if (locationInt != 0) {
				st.setString(locationInt, product.getLocation());
			}

			if (product.getQuantity() != 0) {
				st.setInt(quantityInt, product.getQuantity());
			}
			
			

			}else {
				sqlString = sqlString + "  order by id asc limit ?,5";
				
				System.out.println(sqlString);

				st = conn.prepareStatement(sqlString);

				if (idInt != 0) {
					st.setString(idInt, product.getId());
				}

				if (typeInt != 0) {
					st.setString(typeInt, product.getType());
				}

				if (nameInt != 0) {
					st.setString(nameInt, product.getName());

				}

				if (priceInt != 0) {
					st.setString(priceInt, product.getPrice());
				}

				if (modifiedTimeInt != 0) {
					st.setString(modifiedTimeInt, product.getModifiedTime());
				}

				if (keeperInt != 0) {
					st.setString(keeperInt, product.getKeeper());
				}

				if (locationInt != 0) {
					st.setString(locationInt, product.getLocation());
				}

				if (product.getQuantity() != 0) {
					st.setInt(quantityInt, product.getQuantity());
				}
				
				//from current page 
				
				st.setInt(count+1, currentpage*5);
				}
				
				
			
			
		
		
				rs = st.executeQuery();
				
				
				//
				//
				//
				//
				//
				while (rs.next()) {
					// System.out.println(rs.getString("name")+" "+rs.getString("id"));
					Product product1 = new Product();
					product1.setId(rs.getString("id"));
					product1.setKeeper(rs.getString("keeper"));
					product1.setLocation(rs.getString("location"));
					product1.setModifiedTime(rs.getString("modifiedTime"));
					product1.setName(rs.getString("name"));
					product1.setPrice(rs.getString("price"));
					product1.setQuantity(Integer.parseInt(rs.getString("quantity")));
					product1.setType(rs.getString("type"));
					
					list.add(product1);}
					
					
		} catch (Exception e) {

		} finally {
			JdbcUtils.release(conn, st, rs);
		}
		
		return list;

	}
	
	
	
	
	@Override
	public void add(Product product) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			// ���蕭?銝芣�摨�
			conn = JdbcUtils.getConnection();
			// 閬銵�QL�隞歹�QL銝剔��雿輻?雿蛹���蕭?
			String sql = "insert into product(id,type,name,price,modifiedTime,keeper,location,quantity) values(?,?,?,?,?,?,?,?)";
			// ��onn撖寡情����提�銵QL�隞斤�repareStatement撖寡情
			st = conn.prepareStatement(sql);
			// 銝搴QL霂剖銝剔��韏蕭?嚙踝�釣���揣撘嚙�?1嚙�?憪��
			/**
			 * SQL霂剖銝剖�葵摮挾��掩����蕭?
			 * 
			 * Id,Type,Name,Price,ModifiedTime,keeper,location,quantity
			 */
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");

			st.setString(1, product.getId());// id�int蝐餃�蕭?
			st.setString(2, product.getType());// name�varchar(摮泵銝脩掩嚙�?)
			st.setString(3, product.getName());// password�varchar(摮泵銝脩掩嚙�?)
			st.setString(4, product.getPrice());// email�varchar(摮泵銝脩掩嚙�?)
			st.setString(5, product.getModifiedTime());// birthday�date蝐餃��
			// �銵�����xecuteUpdate�瘜�����嚙�?
			st.setString(6, product.getKeeper());
			st.setString(7, product.getLocation());
			st.setInt(8, product.getQuantity());

			int num = st.executeUpdate();
			if (num > 0) {
				System.out.println("��������");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// SQL�銵�������韏��
			JdbcUtils.release(conn, st, rs);
		}

	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from product where id=?";
			st = conn.prepareStatement(sql);
			st.setString(1, product.getId());
			int num = st.executeUpdate();
			if (num > 0) {
				System.out.println("��������");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(conn, st, rs);
		}

	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update product set name=?,type=?,price=?,modifiedTime=?,keeper=?,location=?,quantity=? where id=?";
			st = conn.prepareStatement(sql);
			st.setString(1, product.getName());
			st.setString(2, product.getType());
			st.setString(3, product.getPrice());
			st.setString(4, product.getModifiedTime());
			st.setString(5, product.getKeeper());
			st.setString(6, product.getLocation());
			st.setInt(7, product.getQuantity());
			st.setString(8, product.getId());

			int num = st.executeUpdate();
			if (num > 0) {
				System.out.println("��������");
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JdbcUtils.release(conn, st, rs);
		}

	}

	@Override
	public List<Product> query(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
