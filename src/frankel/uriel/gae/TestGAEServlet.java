package frankel.uriel.gae;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.QueryResultIterator;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

@SuppressWarnings("serial")
public class TestGAEServlet extends HttpServlet {
	ObjectifyService objectifyService ;
	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
	
		
	}


	String postedString = "";
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		 Objectify ofy = ObjectifyService.begin();
		resp.setContentType("text/plain");
		 Query<UserInfo> query = ofy.query(UserInfo.class);
		 QueryResultIterator<UserInfo>  iter = query.iterator();
		 String answer = "";
		 while (iter.hasNext()) {
			UserInfo userInfo = (UserInfo) iter.next();
			answer = answer + "Job Title: "+userInfo.jobTitle+ " , discipline: " + userInfo.discipline + " , company: " + userInfo.company + " , salary: " + userInfo.salary + " , seniority: " + userInfo.seniority;
		}
		resp.getWriter().println(answer);
		
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		StringBuffer jb = new StringBuffer();
		  String line = null;
		  try {
		    BufferedReader reader = req.getReader();
		    while ((line = reader.readLine()) != null)
		      jb.append(line);
		  } catch (Exception e) { /*report an error*/ }

		  try {
		    UserInfo userInfo = requestToUserInfoObject(jb);
		    Objectify ofy = ObjectifyService.begin();
		    ofy.put(userInfo);
		  } catch (Exception e) {
		    // crash and burn
		    throw new IOException("Error parsing JSON request string");
		  }
		  
		  
		  
	}


	private UserInfo requestToUserInfoObject(StringBuffer jb) throws JSONException {
		JSONObject jsonObject = new JSONObject(jb.toString());
		UserInfo userInfo = new UserInfo();
		
		userInfo.salary = Integer.parseInt(jsonObject.getString("salary"));
		userInfo.jobTitle = jsonObject.getString("jobTitle");
		userInfo.company = jsonObject.getString("company");
		userInfo.discipline = jsonObject.getString("discipline");
		userInfo.seniority = Integer.parseInt(jsonObject.getString("seniority"));
		return userInfo;
	}
	
	
}
