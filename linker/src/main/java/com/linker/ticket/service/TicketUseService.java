package com.linker.ticket.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linker.ticket.dao.TicketUseDao;
import com.linker.ticket.dto.TicketUseDto;

@Service
public class TicketUseService {

	@Autowired
	TicketUseDao dao;
	
	public List<TicketUseDto> selectAll(int start, String userid){
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("start", start);
		m.put("count", 10);
		m.put("userid", userid);
		return dao.selectAll(m);
	}
	
	public int count(String userid) {
		return dao.count(userid);
	}
	
	public List<TicketUseDto> selectByDate(Date startDate, Date endDate, String userid, int start){
		Map<String, Object> m = new HashMap<>();
		m.put("startDate", startDate);
		m.put("endDate", endDate);
		m.put("userid", userid);
		m.put("start", start);
		m.put("count", 10);
		//limit 추가
		return dao.selectByDate(m);
	}
	
	public int selectByDateCount(Date startDate, Date endDate, String userid) {
		
		Map<String, Object> m = new HashMap<>();
		m.put("startDate", startDate);
		m.put("endDate", endDate);
		m.put("userid", userid);
		
		return dao.selectByDateCount(m);
	}
}
