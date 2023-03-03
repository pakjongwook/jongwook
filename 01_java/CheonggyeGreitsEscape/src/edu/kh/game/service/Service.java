package edu.kh.game.service;

import edu.kh.game.dto.Floor;
import edu.kh.game.dto.Item;
import edu.kh.game.dto.Player;
import edu.kh.game.dto.Zombie;
import edu.kh.game.view.GameView;

public class Service {
   
   Floor floor = new Floor("1", 1);
   Item item = new Item("asd", 1, 10);
   Player p1 = new Player("당신", 5, 0, 1, 5, 7);
   //name, hp, defense, power, stamina, floor
   Zombie zom = new Zombie("qkr", 2, 1);
   int zombieKill = 0;
   int itemGet = 0;
   int evasion = 90;
   
   
   
   // 플레이어 행동 관련
   public void died() {
      
      if(p1.getHp() == 0) {
         System.out.println("당신은 죽었습니다.");
      }
   }
   
   public int random() {
      int random = (int)(Math.random()*100)+1;
      
      return random;
   }
   
   public void attack() {
      
      if (random()+(item.getEvasion())>50) {
         zom.setHp(0);
         System.out.println("재빠르게 회피하고 좀비를 처리했습니다.");
         if(item!=null) {
            item.setEvasion(item.getEvasion()-1);
            broken(item);
         }
         
      }else {
         System.out.println("공격을 당했지만 좀비를 처리했습니다.");
         p1.setHp(p1.getHp()-zom.getPower());      
      }
      died();
   }
   
   public void run() {
      if(p1.getStamina()==3 ) {
         System.out.println("도망에 성공하였습니다.");
         p1.setStamina(2);
      } else if(p1.getStamina()==2) {
         p1.setStamina(1);
         if(random()>25) {
            System.out.println("도망에 성공하였습니다.");
            
         } else{
            System.out.println("도망에 실패하였습니다.");
            
            p1.setHp(p1.getHp()-1);
            p1.setStamina(p1.getStamina()-1);
         }
         
      } else if (p1.getStamina()==1){
         p1.setStamina(0);
         if(random()>50) {
            System.out.println("도망에 성공하였습니다.");
            
         } else{
            System.out.println("도망에 실패하였습니다.");
            
            p1.setHp(p1.getHp()-1);
            p1.setStamina(p1.getStamina()-1);
         }
      }
      else {
         System.out.println("스태미너가 부족하여 도망칠 수 없습니다.");
      }
   }
   
   
   public void broken(Item i) {
      i.setStatus(i.getStatus()-1);
      if(i.getStatus()==0) {
         System.out.printf("방어구가 깨졌습니다.");
         item=null;
      }
   }
   
   public void eat(int i) {
      
   }
   
   
   
   // UI전용
    public int viewHp() {
         int hp = p1.getHp();
         return p1.getHp();
      }
      
      public int viewStamina() {
         int stamina = p1.getStamina();
         return stamina;
      }
      
      public int viewFloor() {   //현재 층
         int floor = p1.getFloor();
         return floor;
      }
      
      public void moveFloor(boolean move) {   //층 이동
         p1.setFloor(p1.getFloor()-1);
      }
      
      public int getPlayerHp(int getPlayerHp) {   //플레이어 힐
         int nowHp = p1.getHp()+getPlayerHp;
         p1.setHp(nowHp);
         return p1.getHp();
      }
      
      public int hitPlayer(int damage) {   //플레이어 맞음
         int nowHp = p1.getHp()-damage;
         p1.setHp(nowHp);
         return p1.getHp();
      }
      
      public int getStamina(int getStamina) {   //스테미나 획득
         int nowStamina = p1.getStamina()+getStamina;
         p1.setStamina(nowStamina);
         return p1.getStamina();
      }
      
      public void zombieK() {
  		
  		if(zombieKill >= 10) {
  			System.out.println("나는야 좀비마스터 하하하");
  		}
  	}
      
      public int useStamina(int useStamina) {   //스테미나 사용
         int nowStamina = p1.getStamina()-useStamina;
         p1.setStamina(nowStamina);
         return p1.getStamina();
      }
      
      public int getPlayerDefense(int getPlayerDefense) {   //플레이어 방어 획득
         int nowDefense = p1.getDefense()+getPlayerDefense;
         p1.setDefense(nowDefense);
         return p1.getDefense();
      }
      
      public int usePlayerDefense(int usePlayerDefense) {   //플레이어 방어 사용(필요?)
         int nowDefense = p1.getDefense()+usePlayerDefense;
         p1.setDefense(nowDefense);
         return p1.getDefense();
      }
      
      public void addItem(int index, String itemName) {   //원하는 빈칸에 입력 가능
         p1.setItem(index, itemName);
      }
       
      public void useItem(int index) {   //사용하면 삭제"null"로 변경
         p1.getItem(index);
         p1.setItem2(index);
      }
      
      public String getItem(int index) {//아이템 로드
         return p1.getItem(index);
      }

      
      
      
      
      
      
      
      
      // 세이브 로드
      public void save() {
          
          ObjectOutputStream oos = null;
          try {
             oos = new ObjectOutputStream(new FileOutputStream("object/save.dat"));
             Player i = p1;
             Equipment e = equipment;
             
             
             oos.writeObject(i);
             oos.writeObject(e);
          
          }catch (Exception e) {
             e.printStackTrace();
          }finally {
             try {
                if(oos != null) oos.close();
             }catch (IOException e) {
                e.printStackTrace();
             }
             
          }
       }
       
       public void start() {
          System.out.println(p1.getHp());
          System.out.println(equipment.getStatus());
          p1.setHp(20);
          equipment.setStatus(99);
          equipment.setName("99");         
          System.out.println(p1.getHp());
          System.out.println(equipment.getStatus());
       }
       
       public void status() {
          System.out.println(p1.getHp());
          System.out.println(equipment.getStatus());
          System.out.println(equipment.getName());
       }
       
       public void load() {
          ObjectInputStream ois = null;
          try {
             ois = new ObjectInputStream(new FileInputStream("object/save.dat"));
             
             p1 = (Player)ois.readObject();
             equipment = (Equipment)ois.readObject();
             System.out.println(p1.getHp());
             System.out.println(equipment.getStatus());
             System.out.println(equipment.getName());
             
          }catch (Exception e) {
             e.printStackTrace();
          }finally {
             try {
                if(ois != null) ois.close();
             }catch (IOException e) {
                e.printStackTrace();
             }
             
          }
       }
   
}