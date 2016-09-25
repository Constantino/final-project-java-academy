/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.jsp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController{

	private String DbFile = "HobbiesStored.dat";
	
	private String message = "Hello!... Welcome my Lord ";

	@GetMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		return "welcome";
	}
	
	@GetMapping("/hobbies")
    public String greetingForm(Model model) {
        model.addAttribute("hobby", new Hobby());
        return "hobbies";
    }
	
	@GetMapping("/search")
    public String search(Model model) {
        
		FileReader reader = null;
		
		String filePath = new File("").getAbsolutePath();
		
		String text = "";
		
		try 
		{
			
			
			reader = new FileReader(filePath+"/"+DbFile);
			BufferedReader buffer = new BufferedReader(reader);
			
			String line;
			
			try {
				while( (line = buffer.readLine()) != null){
					text += line+"\n";
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			if(reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		model.addAttribute("textFromDBFile", text);
		
        return "search";
    }
	
	@PostMapping("/hobbiesResult")
	public String hobbiesSubmit(ServletRequest req) {
		
		String filePath = new File("").getAbsolutePath();
		
		PrintWriter writer = null;
		
		try {
			
			writer = new PrintWriter(new FileWriter(filePath+"/"+DbFile,true));

			String username = req.getParameter("username");
			String userHobbies = req.getParameter("UserHobbies");
			
			System.out.println("UserName: "+username);
			System.out.println("UserHobbies: "+userHobbies);
			
			writer.println(username+":"+userHobbies+"\n");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(writer != null){
				writer.close();
			}
		}
		
		return "hobbiesResult";
	}

	@RequestMapping("/foo")
	public String foo(Map<String, Object> model) {
		throw new RuntimeException("Foo");
	}

}
