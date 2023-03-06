package edu.kh.game.dto;

import java.util.Objects;

public class Item {
	
   private String name;
   private int Status = 0;
   private int evasion = 0;
   
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getStatus() {
      return Status;
   }

   public void setStatus(int status) {
      Status = status;
   }

   public int getEvasion() {
      return evasion;
   }

   public void setEvasion(int evasion) {
      this.evasion = evasion;
   }

   public Item() {
      super();
   }

   public Item(String name, int status, int evasion) {
      super();
      this.name = name;
      this.Status = status;
      this.evasion = evasion;
   }
}