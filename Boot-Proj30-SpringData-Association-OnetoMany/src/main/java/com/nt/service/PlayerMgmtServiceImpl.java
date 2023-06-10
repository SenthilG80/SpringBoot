package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.docment.Player;
import com.nt.repository.IPlayerRepository;

@Service("playerService")
public class PlayerMgmtServiceImpl implements IPlayerMgmtService {

  @Autowired
   private IPlayerRepository playerRepo;
	
	@Override
	public String registerPlayer(Player player) {
		Integer idVal=playerRepo.insert(player).getPid();
		return "Players with Sports and Medals are saved with id vale of "+idVal ;
	}

}
