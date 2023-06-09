package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.docment.PlayerInfo;
import com.nt.repository.PlayerInfoRepository;
@Service("PlayerService")
public class PlayerMgmtSerivceImpl implements IplayerMgmtService {
   
	 @Autowired
	private PlayerInfoRepository playerRepo;
	
	@Override
	public String registerPlayer(PlayerInfo player) {
		int idVal=playerRepo.insert(player).getId();
		return "player is saved with id value" + idVal;
		 
	}

	@Override
	public List<PlayerInfo> showAllPlayers() {
		
		return playerRepo.findAll();
	}
}
