package com.zfgc.zfgbb.dataprovider.forum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.BoardDao;
import com.zfgc.zfgbb.dao.CategoryDao;
import com.zfgc.zfgbb.dataprovider.AbstractDataProvider;
import com.zfgc.zfgbb.dbo.BoardDboExample;
import com.zfgc.zfgbb.dbo.BoardSummaryViewDboExample;
import com.zfgc.zfgbb.dbo.CategoryDboExample;
import com.zfgc.zfgbb.mappers.BoardSummaryViewDboMapper;
import com.zfgc.zfgbb.model.forum.Board;
import com.zfgc.zfgbb.model.forum.BoardSummary;
import com.zfgc.zfgbb.model.forum.Category;

@Repository
public class CategoryDataProvider extends AbstractDataProvider {

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private BoardSummaryViewDboMapper boardSummaryMapper;
	
	public List<Category> getCategories(CategoryDboExample exC){
		List<Category> categories = super.convertDboListToModel(categoryDao.get(exC), Category.class);
		
		categories.forEach(cat ->{
			BoardSummaryViewDboExample ex = new BoardSummaryViewDboExample();
			ex.createCriteria().andCategoryIdEqualTo(cat.getCategoryId());
			cat.setBoards(convertDboListToModel(boardSummaryMapper.selectByExample(ex), BoardSummary.class));
		});
		
		return categories;
	}
	
}