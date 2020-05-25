package com.happytail.general.model.dao;

import com.happytail.general.model.CodeMap;

public interface CodeMapDAO {
	
	public CodeMap insert(CodeMap codeMap);
	
	public boolean delete(Integer id);
	
	public CodeMap update(CodeMap CodeMap);
	
	public CodeMap selectValue(String module, String type, String key);

}
