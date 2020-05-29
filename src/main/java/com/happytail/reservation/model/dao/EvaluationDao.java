package com.happytail.reservation.model.dao;



import java.util.List;

import com.happytail.reservation.model.Evaluation;
import com.happytail.reservation.model.backView;




public interface EvaluationDao {
	
	Object save(Evaluation bean);
	
	List<Evaluation> queryAllEvaluation();
	
	List<backView> queryAllEvaluationView();
	
	List<backView> queryByDateEvaluationView(String createMonth);
	
	Double ScoreAvg();
	
}
