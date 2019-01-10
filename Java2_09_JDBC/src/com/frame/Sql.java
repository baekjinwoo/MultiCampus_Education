package com.frame;

public class Sql {
	public static String selectUserAll = "SELECT * FROM T_USER";
	public static String selectUser = "SELECT * FROM T_USER WHERE ID = ?";
	public static String insertUser = "INSERT INTO T_USER VALUES (?,?,?)";
	public static String insertItem = "INSERT INTO T_ITEM VALUES (?,?,?)";
	public static String insertUserItem ="INSERT INTO T_USERITEM VALUES (?,?)";
	
	public static String selectuseritem =
		"SELECT IT.ID AS ID, IT.NAME AS NAME, IT.PRICE  AS PRICE FROM "+ 
		"T_USER us ,T_ITEM it,T_USERITEM ui "+
		"WHERE us.id = ui.userid "+
		"AND   ui.itemid = it.id "+
		"AND   us.id = ?";
}








