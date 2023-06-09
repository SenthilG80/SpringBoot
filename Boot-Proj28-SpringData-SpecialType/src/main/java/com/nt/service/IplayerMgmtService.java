package com.nt.service;

import java.util.List;

import com.nt.docment.PlayerInfo;

public interface IplayerMgmtService {
 public String registerPlayer(PlayerInfo player);
 public List<PlayerInfo> showAllPlayers();
 
}
