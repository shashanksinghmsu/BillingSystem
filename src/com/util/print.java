///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.util;
//
///**
// *
// * @author OmBhatt
// */
//public void printsave() {
//
//        javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel) ovtable.getModel();
//
//
//
//            MessageFormat header;
//            MessageFormat footer;
//
//            if (ovcombox.getSelectedItem().equals("")) {
//                //When no category is selected
//                header = new MessageFormat("Expenses from " + dtFrom + " to " + dtTo);
//            } else {
//                //When category is selected
//                header = new MessageFormat("Expenses from " + dtFrom + " to " + dtTo + " for " + ovcombox.getSelectedItem());
//            }
//
//            String u = (String) ovcomboxuser.getSelectedItem();
//
//            if (title.getText().equals("Expenses Overview for " + finaluser)) {
//                //When logged in user's data is printed/saved
//                footer = new MessageFormat("User : " + finaluser + " | Total Cost : " + totc);
//            } else {
//                //When selected username's data is printed/saved
//                footer = new MessageFormat("User : " + u + " | Total Cost : " + totc);
//            }
//
//            try {
//                //performing the print operation
//                ovtable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, e);
//            }
//
//        }
//    }
//public class print {
//    
//}
