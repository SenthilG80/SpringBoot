package com.nt.runner;

import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.docment.Medal;
import com.nt.docment.Player;
import com.nt.docment.Sport;
import com.nt.service.IPlayerMgmtService;

@Component
public class OneToManyAssociationRunner implements CommandLineRunner {
	
@Autowired
 private IPlayerMgmtService playerService;
	/**
	 *
	 */
	@Override
	public void run(String... args) throws Exception {
		
	try {
		

	 //Save Object Using Parent
		
      Player player=new Player();
		player.setPid(new Random().nextInt(1000));player.setPname("Raja");player.setPaddrs("Chennai");
		
      //Saving child object
	
		Sport  sport1=new Sport();
		sport1.setSid(new Random().nextLong(1000));
		sport1.setType("Cricket");
		sport1.setKititems(new String[] {"bat","ball","Legpad","Guard"});
		
		Sport  sport2=new Sport();
		sport2.setSid(new Random().nextLong(1000));
		sport2.setType("Batmitton");
		sport2.setKititems(new String[] {"cock","bat","Net","Shoe"});
		 
		Medal m1=new Medal();
		m1.setMid(1001);
		m1.setMname("Gold-Cricket");
		m1.setEvent("World Championship");
		m1.setPlace("Chennai");
		
		Medal m2=new Medal();
		m2.setMid(1002);
		m2.setMname("Silver-Bat");
		m2.setEvent("ManoftheMatch");
		m2.setPlace("Mumbai");
		
	//Perform Association
	  player.setSports(Set.of(sport1,sport2));
	  player.setMedals(Map.of("Gold",m1,"Silver",m2));
		//Access Service
		System.out.println(playerService.registerPlayer(player));

	}catch (Exception e) {
		e.printStackTrace();
	}
   
	}

}
