package cs3220.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.InputStreamReader;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.Question;


@WebServlet("/DrivingTestBrowser")
public class DrivingTestBrowser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DrivingTestBrowser() {
        super();
    }
 
	public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	int count = 0; 
    	try { 
    	File test = new File(getServletContext().getRealPath("/WEB-INF/DrivingTest.txt")); 
    	Scanner in = new Scanner(test);
    	List<Question> questions = new ArrayList<Question>();
    	while(in.hasNextLine()) {
	    	String description = in.nextLine(); 
	    	String answerA = in.nextLine(); 
	    	String answerB = in.nextLine(); 
	    	String answerC = in.nextLine(); 
	    	int correct = Integer.parseInt(in.nextLine());
	    	Question question = new Question(description, answerA, answerB, answerC, correct); 
	    	questions.add(question);
	    	if(in.hasNextLine()) {
	    		in.nextLine();
	    	}else {
	    		break; 
	    	}
    	}
    	in.close(); 
    	getServletContext().setAttribute("questions", questions); 
    	getServletContext().setAttribute("count", count); 
    	}
    	catch(IOException e){
    	}
    	
    	
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Question> questions = (List<Question>) getServletContext().getAttribute("questions");
		var count = request.getParameter("questionIndex"); 
		int index = count == null || count.trim().length() == 0 ? 0 : Integer.parseInt(count);
		if(index == questions.size()) {
			index = -1; 
		}
		request.setAttribute("questions", questions);
		request.getSession().setAttribute("index", index);
		request.getRequestDispatcher("/WEB-INF/DrivingTest.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
