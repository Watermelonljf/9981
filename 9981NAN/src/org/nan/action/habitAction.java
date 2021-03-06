package org.nan.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.sql.Delete;
import org.nan.entities.Habit;
import org.nan.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;



/**
 * 习惯模块控制器
 * @author Watermelon_R
 *
 */

@Controller
@Scope("prototype")
public class habitAction extends ActionSupport implements ModelDriven<Habit>,ServletResponseAware{
	private static final long serialVersionUID = 1L;
	
	//通过ModelDriven封装前台数据
	private Habit habit;
	
	@Autowired
	private HabitService habitService;
	
	public void save(){
		habit.setStartTime(new Date());
		habitService.add(habit);
	}
	

	private Integer id;
	public void delete(){
		habitService.delete(id);
	}
	
	public void DaysUp(){
		habitService.daysUp(id);
	}
	
	public void DaysDown(){
		habitService.daysUp(id);
	}
	
	public void getAllHabits(){
		try {
			PrintWriter out = this.response.getWriter();
			List<Habit> all = habitService.getAll();
			JSONObject obj = new JSONObject();
			if(all != null && all.size()>0){
				obj.put("allHabits", all);
				obj.put("code",1);
			}else{
				obj.put("code",0);
			}
			out.print(obj);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Habit getModel() {
		habit = new Habit();
		return habit;
	}

	private HttpServletResponse response;
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		this.response.setCharacterEncoding("utf-8");
		
	}
	
	
	

}
