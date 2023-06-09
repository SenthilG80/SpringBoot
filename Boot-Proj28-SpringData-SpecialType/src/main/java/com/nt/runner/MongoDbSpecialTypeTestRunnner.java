package com.nt.runner;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.docment.PlayerInfo;
import com.nt.service.IplayerMgmtService;

@Component
public class MongoDbSpecialTypeTestRunnner implements CommandLineRunner {
    @Autowired
	 private IplayerMgmtService playerService;
	@Override
	public void run(String... args) throws Exception {
//	 PlayerInfo info=new PlayerInfo();
//	 info.setId(new Random().nextInt(10000));
//	 info.setPname("WeareAllWell");
//	 info.setNickNames(new String[] {"raj","king","maharaj"});
//	 info.setFriends(List.of("Srinivas","SAIRAM","MURGA"));
//	 info.setPhoneNumbers(Set.of(3333333L,4444444L,556656777L));
//	 Properties props=new Properties();
//	 props.put("Bat", "SG"); props.put("Batting Pads", "SS"); props.put("Ball", "Kookbura");
//	 info.setKitInfo(props);
//	 info.setIdDetails(Map.of("Aadhar",4435111L,"Voter ID",666773376L));
//	 
//	 try {
//		 System.out.println(playerService.registerPlayer(info));
//	 
//	 }catch (Exception e) {
//		e.printStackTrace();
//	}
//	 
     playerService.showAllPlayers().forEach(System.out::println);
	}

}
