/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.forumproject.model;

/**
 *
 * @author daviddonley
 */
public class Entry {
       private String entry;
       private String user;
       private String time;

       public Entry(){
              setEntry("");
              setUser("");
              setTime("");
       }

       public Entry(String entry, String user, String time) {
              this.setEntry(entry);
              this.setUser(user);
              this.setTime(time);
       }

       public String getEntry() {
       return entry;
       }

       public void setEntry(String entry) {
              this.entry = entry;
       }

       public String getUser() {
              return user;
       }
     
       public void setUser(String user) {
              this.user = user;
       }

       public String getTime() {
              return time;
       }

       public void setTime(String time) {
              this.time = time;
       }
}
