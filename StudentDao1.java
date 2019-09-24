package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import java.util.List;

import cn.itcast.chapter09.entity.Student1;
import util.DBUtil;

public class StudentDao1 {
	//����ѧ����Ϣ
	public boolean insert(Student1 stu){
		Connection con = null;
  		Statement sta = null;
  		try {
  			con=DBUtil.getConnection();
			sta=con.createStatement();
			String sql="INSERT INTO student1 VALUES('"+stu.getStuId()+"','"+stu.getStuName()+"'"
					+ ",'"+stu.getStuSex()+"',"+stu.getStuAge()+" ,'"+stu.getNumber()+"')";
			int num=sta.executeUpdate(sql);
			if(num>0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(con);
		}
  		return false;
	}
	//��ѯ����
	public  ArrayList<Student1> queryAll(){
			Connection con = null;
	  		Statement sta = null;
	  		ResultSet res = null;
	  		ArrayList<Student1> students = new ArrayList<Student1>();
	  		try
	  		{
	  			con = DBUtil.getConnection();
				String sql = "SELECT * FROM student1 ORDER BY stuId ASC";
				sta = con.createStatement();
				res = sta.executeQuery(sql);
				while(res.next()){
					String stuId = res.getString("stuId");
					String stuName = res.getString("stuName");
					String stuSex = res.getString("stuSex");
					int stuAge = res.getInt("stuAge");
					String number=res.getString("number");
					Student1 student = new Student1(stuId,stuName,stuSex,stuAge,number);
					students.add(student);
				}
	  		}
	  		catch(Exception ex)
	  		{
	  			ex.printStackTrace();
	  		}
	  		DBUtil.closeConnection(con);
	  		return students;
		}
    //ɾ��
	// ɾ���û�
	public boolean delete(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// ������ݵ�����
			conn = DBUtil.getConnection();
			// ���Statement����
			stmt = conn.createStatement();
			// ����SQL���
			String sql = "DELETE FROM student1 WHERE stuId=" + id;
			int num = stmt.executeUpdate(sql);
			if (num > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
		return false;
	}
	//�޸�
	public boolean update(Student1 stu) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// ������ݵ�����
			conn = DBUtil.getConnection();
			// ���Statement����
			stmt = conn.createStatement();
			// ����SQL���
			String sql = "UPDATE student1 SET stuName='" + stu.getStuName() + "',stuSex='"
					+ stu.getStuSex() + "',stuAge=" + stu.getStuAge()
					+ ",number='" + stu.getNumber()+"' where stuId='"+stu.getStuId()+"'";
			int num = stmt.executeUpdate(sql);
			if (num > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
		return false;
	}
	//��ҳ����
	public List<Student1> listStu(int start,int count){
		Connection con = null;
  		Statement sta = null;
  		ResultSet res = null;
  		List<Student1> students = new ArrayList<Student1>();
  		try
  		{
  			con = DBUtil.getConnection();
			String sql = "SELECT * FROM student1 limit "+start+","+count;
			sta = con.createStatement();
			res = sta.executeQuery(sql);
			while(res.next()){
				String stuId = res.getString("stuId");
				String stuName = res.getString("stuName");
				String stuSex = res.getString("stuSex");
				int stuAge = res.getInt("stuAge");
				String number=res.getString("number");
				Student1 student = new Student1(stuId,stuName,stuSex,stuAge,number);
				students.add(student);
			}
  		}
  		catch(Exception ex)
  		{
  			ex.printStackTrace();
  		}
  		DBUtil.closeConnection(con);
  		return students;
	}

    //��ȡѧ������
	public int getStuCount(){
		Connection con = null;
  		Statement sta = null;
  		ResultSet res = null;
  		int recordsNum=0;
  		try {
  			con=DBUtil.getConnection();
			sta=con.createStatement();
			String sql="SELECT COUNT(*) FROM student1";
			res=sta.executeQuery(sql);
			while(res.next()){
				recordsNum=res.getInt("COUNT(*)");
			}
			return recordsNum;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(con);
		}
  		return 0;
	}
}
