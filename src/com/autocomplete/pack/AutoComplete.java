package com.autocomplete.pack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class AutoComplete
 */
@WebServlet("/AutoComplete")
public class AutoComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AutoComplete() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("application/json");
		try {
			String term = request.getParameter("term");

			String[] array = { "vicky", "dinesh", "sathish", "ganesh", "dhivakar", "keerthana", "dhana", "sivalingam",
					"arjun", "rambabu", "swetha", "meenakshi" };
			
			List<String> allData = Arrays.asList(array);

			List<String> outputData = new ArrayList<String>();
			for(String data: allData){
				if(data.contains(term))
					outputData.add(data);					
			}				
				
			String wordList = new Gson().toJson(outputData);
			response.getWriter().write(wordList);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
