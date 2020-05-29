package com.happytail.reservation.model.dao;


import java.util.List;

import com.happytail.reservation.model.MyReservationView;
import com.happytail.reservation.model.ReservationBean;





public interface ReservationDao {

	Object save(ReservationBean bean);
	
	ReservationBean UpdateStatuss(ReservationBean bean);
	
	ReservationBean UpdateEvaluationStatus(ReservationBean bean);
	
	List<MyReservationView> query(Integer Id);
	
	List<MyReservationView> queryAllView();
	
	ReservationBean queryReservationBean(Integer reservationId);

	ReservationBean select(Integer reservationId);
}
