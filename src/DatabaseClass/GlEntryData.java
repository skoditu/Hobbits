///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package DatabaseClass;
//
////import DBClass.DBFacade;
////import HomePage.FinanceHome;
////import UsersGUI.Login;
////import com.mysql.jdbc.ResultSet;
//import java.sql.PreparedStatement;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// *
// * @author chamod
// */
//public class GlEntryData {
//
////    DBFacade db = new DBFacade();
//
//    public int saveGlmaster(String RefNo, String MasDes, String TensNo, String date, String PayMode, String transct) {
//        int val = 0;
//
//        String tempTransctionNo = transct;// getTransctionNo(date, "GL");
//        try {
//            PreparedStatement pst2 = (PreparedStatement) db.psmt("INSERT INTO `samrogl`.`gl_entry_master` (`Reference_No`,`master_Description`,`Transaction_No`,`insert_date`,`Paymode`,userID) VALUES (?,?,?,?,?,?);");
//            pst2.setString(1, RefNo);
//            pst2.setString(2, MasDes);
//            pst2.setString(3, tempTransctionNo);
//            pst2.setString(4, date);
//            pst2.setString(5, PayMode);
//            pst2.setInt(6, Login.userId);
//            val = pst2.executeUpdate();
//            ResultSet rsmax = (ResultSet) pst2.getGeneratedKeys();
//            if (rsmax.next()) {
//                val = rsmax.getInt(1);
//            }
//            pst2 = null;
//            rsmax = null;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return val;
//    }
//
//    public String getTransctionNo(String date, String Type) {
//        String tempNo = Type;
//        System.out.println("tempNo" + tempNo);
//        ResultSet rs = null;
//        String Refno = "";
//        try {
//            rs = (ResultSet) db.fetch("select Transaction_No from gl_entry_master where Transaction_No like '" + tempNo + "%'");
//            while (rs.next()) {
//                System.out.println("Transaction_No----" + rs.getString("Transaction_No"));
//                Refno = rs.getString("Transaction_No");
//            }
//            if (Refno.length() > 2) {
//                String refNo = Refno.substring(2);
//                System.out.println("refNo" + refNo);
//                int a = Integer.parseInt(refNo) + 1;
//                if (String.valueOf(a).length() == 1) {
//                    tempNo += "00" + a;
//                } else if (String.valueOf(a).length() == 2) {
//                    tempNo += "0" + a;
//                } else if (String.valueOf(a).length() == 3) {
//                    tempNo += a;
//                }
//            } else {
//                int a = 1;
//                if (String.valueOf(a).length() == 1) {
//                    tempNo += "00" + a;
//                } else if (String.valueOf(a).length() == 2) {
//                    tempNo += "0" + a;
//                } else if (String.valueOf(a).length() == 3) {
//                    tempNo += a;
//                }
//            }
//            rs.close();
//            rs = null;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return tempNo;
//    }
//
//    /* private int getmaxnumber(){
//    String qq="SELECT  MAX(Glno) FROM  gl_entry_master";
//    ResultSet maxrs=db.fetch(qq);
//    if(qq){}    
//    }*/
//    public ResultSet show_GLMaster_data(String transction) {
//        ResultSet rs = null;
//        try {
//            String query = ("SELECT Reference_No,master_Description,Transaction_No,insert_date,Paymode,ul.User_Name AS  addeduser,Addtime FROM  gl_entry_master AS gl,userlogin  AS ul \n"
//                    + " WHERE gl.userID=ul.User_Id AND Transaction_No='" + transction + "'");
//            rs = (ResultSet) db.fetch(query);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return rs;
//    }
//
//    public ResultSet showgrid(String gi) {
//        ResultSet rs = null;
//        try {
//            String query = ("SELECT * FROM posting WHERE Transaction_No LIKE '" + gi + "' ");
//            rs = (ResultSet) db.fetch(query);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return rs;
//    }
//
//    public ResultSet getGlNo() {
//        ResultSet rs = null;
//        try {
//            String query = ("SELECT Glno FROM gl_entry_master ORDER BY Glno DESC");
//            rs = (ResultSet) db.fetch(query);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return rs;
//    }
//
//    public int editGlmaster(String refNo, String des, String trno, String date, String payMod, String c) {
//        int val = 0;
//        try {
//            PreparedStatement pst = (PreparedStatement) db.psmt("UPDATE `samrogl`.`gl_entry_master` SET `Reference_No` = '" + refNo + "',`master_Description` = '" + des + "',`Transaction_No` = '" + trno + "',`insert_date` = '" + date + "',`Paymode` = '" + payMod + "' WHERE `Glno` = '" + c + "'");
//            val = pst.executeUpdate();
//            System.err.println("update complete");
//            val = 1;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return val;
//
//    }
//
//    public int editGldetails(String accNo, String accType, String accDes, String VNo, String amount, String c) {
//        int val = 0;
//        try {
//            PreparedStatement pst = (PreparedStatement) db.psmt("UPDATE `samrogl`.`gl_entry_details` SET ,`AccountNo` = '" + accNo + "',`Acc_type`='" + accType + "',`description` = '" + accDes + "',`voucherNo` = '" + VNo + "',`amount`='" + amount + "') WHERE `Glno` = '" + c + "'");
//            val = pst.executeUpdate();
//            pst = null;
//            val = 1;
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//        return val;
//
//    }
//
//    public ResultSet GetallMainCords(String searc) {
//        ResultSet rs = null;
//        try {
//            String quary = "SELECT  * FROM gl_entry_master where  Transaction_No like  '" + searc + "%'";
//            rs = (ResultSet) db.fetch(quary);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return rs;
//
//    }
//
//    public ResultSet getPayMethod() {
//        ResultSet rs = null;
//        try {
//            String quary = "SELECT  * FROM paymethod";
//            rs = (ResultSet) db.fetch(quary);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return rs;
//    }
//
//    public int deleteGLData(String trno) {
//        int val = 0;
//        try {
//            PreparedStatement pst = (PreparedStatement) db.psmt("DELETE FROM `samrogl`.`posting` WHERE `Transaction_No` = '" + trno + "'");
//            val = pst.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return val;
//    }
//
//    public boolean updateconfrmation(String transctionno) {
//        boolean val = false;
//        try {
//            // String datetime=new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date());
//            PreparedStatement pst = (PreparedStatement) db.psmt("UPDATE  posting SET  confirm='1' WHERE Transaction_No='" + transctionno + "'");
//            pst.executeUpdate();
//            String sql = "UPDATE  posting SET  confirmtime=NOW() WHERE Transaction_No='" + transctionno + "'";
//            db.saveForUpdate(sql);
//            val = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            val = false;
//        }
//        return val;
//    }
//
//    public int getMaxSysTransctionno() {
//        int a = 1;
//        ResultSet rs = null;
//        try {
//            String quary = "SELECT  (MAX(Sys_tra_no) +1 ) AS SysTra FROM  posting ";
//            rs = (ResultSet) db.fetch(quary);
//            while (rs.next()) {
//                a = rs.getInt("SysTra");
//            }
//            rs.close();
//            rs = null;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return a;
//    }
//}
