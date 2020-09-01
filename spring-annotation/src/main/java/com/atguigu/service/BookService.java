package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.atguigu.dao.BookDao;

@Service
public class BookService {

	@Qualifier("bookDao")
	@Autowired(required =false)
	private BookDao bookDao2;
	
	public BookService() {
	}

	@Override
	public String toString() {
		return "BookService [bookDao=" + bookDao2 + "]";
	}
	
	
}
