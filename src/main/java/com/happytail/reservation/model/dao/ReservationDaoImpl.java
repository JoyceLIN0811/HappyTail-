package com.happytail.reservation.model.dao;


import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.happytail.reservation.model.MyReservationView;
import com.happytail.reservation.model.ReservationBean;





@Repository
public class ReservationDaoImpl implements ReservationDao{
	
	@Autowired
	@Qualifier(value = "sessionFactory")
	private SessionFactory sessionFactory;
	
	public ReservationDaoImpl() {
	} 

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	

	@Override
	public Object save(ReservationBean bean) {
		getSession().save(bean);
		return bean;
	}


	@Override
	public List<MyReservationView> query(Integer Id) {
		Query<MyReservationView> query = getSession().createQuery("from MyReservationView where Id=:Id ", MyReservationView.class);
		query.setParameter("memberId", Id);
		List<MyReservationView> list = query.getResultList();
		return list;
	}

	@Override
	public ReservationBean UpdateStatuss(ReservationBean bean) {
		ReservationBean rb = getSession().get(ReservationBean.class, bean.getReservationId());
		rb.setReservationId(bean.getReservationId());
		rb.setStatuss(bean.getStatuss());
		getSession().update(rb);
		return rb;
	}
	
	@Override
	public ReservationBean UpdateEvaluationStatus(ReservationBean bean) {
		ReservationBean rb = getSession().get(ReservationBean.class, bean.getReservationId());
		rb.setReservationId(bean.getReservationId());
		rb.setEvaluationStatus(bean.getEvaluationStatus());
		getSession().update(rb);
		return rb;
	}

	@Override
	public ReservationBean queryReservationBean(Integer reservationId) {
		ReservationBean rb = getSession().get(ReservationBean.class, reservationId);
		return rb;
	}

	@Override
	public List<MyReservationView> queryAllView() {
		Query<MyReservationView> bean = getSession().createQuery("from MyReservationView order by createDate ", MyReservationView.class );
		List<MyReservationView> list = bean.list();
		return list;
	}

	@Override
	public ReservationBean select(Integer reservationId) {
		if(reservationId == null) {
			return null;
		}
		ReservationBean reservation = null;
		try {
			reservation = getSession().get(ReservationBean.class, reservationId);
		} catch (NoResultException e) {
			e.printStackTrace();
			System.out.println("No result");
			return null;
		}

		return reservation;
	}

	


	

	


	

	


	


	

}
