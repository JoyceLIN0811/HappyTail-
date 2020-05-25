package com.happytail.general.model.dao;


import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.general.model.CodeMap;

@Repository
public class CodeMaoDAOImpl implements CodeMapDAO{

	@Autowired
	private SessionFactory sessionfactory;
	
	public Session getSession() {
		Session session = sessionfactory.getCurrentSession();
		return session;
	}
	
	public CodeMaoDAOImpl() {
	}
	
	private final String selectValue =
			"FROM com.happytail.general.model.CodeMap WHERE module=:module and type=:type and key=:key";


	@Override
	public CodeMap insert(CodeMap codeMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CodeMap update(CodeMap CodeMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CodeMap selectValue(String module, String type, String key) {
		Query<CodeMap> check = getSession().createQuery(selectValue,CodeMap.class);
		check.setParameter("module", module);
		check.setParameter("type", type);
		check.setParameter("key", key);
		
		List<CodeMap> list = check.list();

		if (list == null || list.size() == 0) {
			System.out.println("No result");
			return null;	
		} else {
			return list.get(0);
		}
	}
		
}
