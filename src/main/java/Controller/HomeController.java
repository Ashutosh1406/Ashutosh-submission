package Controller;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.tools.javac.util.Log;

import Model.Task;
import Service.TasksService;
import config.config;

@Controller
public class HomeController {
	
	// kind of an entry point at "/" index.jsp fetch
	
	@RequestMapping(value="/" , method = RequestMethod.GET)   
	public String gettasks(Model model) 
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(config.class);
		TasksService tasksService = ctx.getBean("tasksService",TasksService.class);
		List<Task> tasks = tasksService.gettasks();
		model.addAttribute("tasks",tasks);
		ctx.close();
		return "index";
	}
	
	// Delete task route by id
	
	@RequestMapping(value = "/deletetask" , method = RequestMethod.POST)   
	public String deleteTask(@RequestParam("taskId") int taskId)
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(config.class);
		TasksService tasksService = ctx.getBean("tasksService",TasksService.class);
		
		boolean deleted = tasksService.deleteTask(taskId);
		
		ctx.close();
		return "redirect:/";   // same page redirect 
	}
	 
	//To mark tasks as Completed and put in completed list
	
	@PostMapping(value = "/completetask")   
	public String completeTask(@RequestParam("taskId") int taskId)
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(config.class);
		TasksService tasksService = ctx.getBean("tasksService",TasksService.class);
		
		tasksService.completeTask(taskId);   
		
		ctx.close();
		return "redirect:/";   // same page redirect 
	}
	
	@RequestMapping(value="/completedTask" , method = RequestMethod.GET)   
	public String getcompletedtasks(Model model) 
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(config.class);
		TasksService tasksService = ctx.getBean("tasksService",TasksService.class);
		List<Task> tasks = tasksService.getCompletedTasks();
		model.addAttribute("tasks",tasks);
		ctx.close();
		return "completedTask";  //return to completedTask.jsp
	}
	
} 
