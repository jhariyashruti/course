package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	//List<Course> list;
	
	public CourseServiceImpl()
	{
//	list = new ArrayList<>();
//	list.add(new Course(145,"java" , "core java"));
//	list.add(new Course(146,"sql" , "db sql"));
//	
	
	}
	
	@Override
	public List<Course> getCourses() {
		
		//return list;
		return courseDao.findAll();
		}

	@SuppressWarnings("deprecation")
	@Override
	public Course getCourse(long courseId) {
//		Course c =  null;
//		for (Course cou : list) {
//			if (cou.getId() == courseId) {
//				c = cou;
//				break;
//				}
//				}
//			return c;
		return courseDao.getOne(courseId);
	}

	@Override
	public Course addCourse(Course course) {
//		list.add(course);
//		return course;
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
//		list.forEach(e -> {
//			if (e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//				
//			}
//						
//		});
		courseDao.save(course);
		return course;
//		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
//		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList()); 
		Course entity = courseDao.getOne(parseLong);
		courseDao.delete(entity);
	}
	
}
