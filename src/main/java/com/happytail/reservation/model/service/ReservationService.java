package com.happytail.reservation.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happytail.reservation.model.MyReservationView;
import com.happytail.reservation.model.ReservationBean;
import com.happytail.reservation.model.dao.ReservationDaoImpl;






@Service
@Transactional
public class ReservationService {
	@Autowired
	private ReservationDaoImpl daoImpl;
	

	public Object save(ReservationBean bean) {
		return daoImpl.save(bean);
	}
	
	public List<MyReservationView> query(int Id) {
		return daoImpl.query(Id);
	}
	
	public List<MyReservationView> queryAllView(){
		return daoImpl.queryAllView();
	}
	
	public ReservationBean updateStatuss(ReservationBean bean) {
		return daoImpl.UpdateStatuss(bean);
	}
	
	public ReservationBean updateEvaluationStatus(ReservationBean bean) {
		return daoImpl.UpdateEvaluationStatus(bean);
	}
	
	public ReservationBean queryReservationBean(Integer reservationId) {
		return daoImpl.queryReservationBean(reservationId);
		
	}
}
