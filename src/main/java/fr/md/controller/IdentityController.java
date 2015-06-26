/**
 * 
 */
package fr.md.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView; 

import fr.md.bean.IdentityBean;
import fr.md.iam.datamodel.*;
import fr.md.service.IdentityService;

/**
 * @author Manish
 * Identity controller class 
 */

@Controller
public class IdentityController {
	
	@Autowired
	private IdentityService identityService;
	
	//method to write the identity in database
	@RequestMapping(value = "/save", method = RequestMethod.POST)  
	public ModelAndView saveIdentity(@ModelAttribute("command")IdentityBean idbean,   
	   BindingResult result) {  
		Identity identity = prepareModel(idbean);  
		identityService.write(identity);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("identity", prepareIdentityBean(identity));  
		model.put("identities",  prepareListofBean(identityService.readAllIdentities()));  
		return new ModelAndView("create",model);  
	 }  
	
	//method to login into database
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login(@Valid @ModelAttribute("command")IdentityBean idbean, BindingResult result) {
		final String userID = "root";
	    final String password = "1234";

		Identity identity = prepareModel(idbean);  
		String user = identity.getUid();
        String pwd = identity.getPassword();
		
		Map<String, Object> model = new HashMap<String, Object>();		
		 model.put("identities", prepareListofBean(identityService.readAllIdentities()));  
	    
	    if(userID.equals(user) && password.equals(pwd))
	    {
	    	return new ModelAndView("welcome", model); 
	    }
	    else{
	    	return new ModelAndView("index", model); 
	    }		
	}
	
	//method to logout
	@RequestMapping(value = "/logout", method = RequestMethod.GET)  
	 public ModelAndView logout(@ModelAttribute("command")IdentityBean identityBean,  
	   BindingResult result) {  
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("identities", null);  
		return new ModelAndView("index", model);  
	 } 
	
	
	@RequestMapping(value = "/backwelcome", method = RequestMethod.GET)  
	 public ModelAndView backtowelcome(@ModelAttribute("command")IdentityBean identityBean,  
	   BindingResult result) {  
		Map<String, Object> model = new HashMap<String, Object>();
		  model.put("identities", null);  
		  return new ModelAndView("welcome", model);  
	 }  
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)  
	 public ModelAndView addIdentity(@ModelAttribute("command")IdentityBean identityBean,  
	   BindingResult result) {  
		Map<String, Object> model = new HashMap<String, Object>();
		  model.put("identities", prepareListofBean(identityService.readAllIdentities()));  
		  return new ModelAndView("create", model);  
	 }  
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)  
	 public ModelAndView searchIdentity(@ModelAttribute("command")IdentityBean identityBean,  
	   BindingResult result) {  
		Map<String, Object> model = new HashMap<String, Object>();
	  model.put("identities", null);  
	  return new ModelAndView("search", model);  
	 }  
	
	@RequestMapping(value = "/find", method = RequestMethod.POST)  
	public ModelAndView findIdentity(@ModelAttribute("command")IdentityBean identityBean,  
	   BindingResult result) {  
		Map<String, Object> model = new HashMap<String, Object>();
		Identity searchedIdentity = identityService.getIdentity(identityBean.getUid());
		model.put("identity", searchedIdentity); 
		return new ModelAndView("search", model);  
	 }  
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)  
	public ModelAndView deleteIdentity(@ModelAttribute("command")IdentityBean identityBean,  
	   BindingResult result) {  
		Identity identity = prepareModel(identityBean);  
		identityService.delete(identity);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("identity", null);  
		model.put("identities",  prepareListofBean(identityService.readAllIdentities()));  
		return new ModelAndView("search", model);  
	 }  
	
	@RequestMapping(value = "/loadedit", method = RequestMethod.GET)  
	public ModelAndView loadModifyIdentity(@ModelAttribute("command")IdentityBean identityBean,  
	   BindingResult result) {  
		Map<String, Object> model = new HashMap<String, Object>();
		Identity searchedIdentity = identityService.getIdentity(identityBean.getUid());
		model.put("identity", searchedIdentity);
		model.put("identities", prepareListofBean(identityService.readAllIdentities()));  
	    return new ModelAndView("modify", model);  
	 }  
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)  
	public ModelAndView deleteEmployee(@ModelAttribute("command")IdentityBean identityBean,  
	   BindingResult result) {  
	    Map<String, Object> model = new HashMap<String, Object>();  
		Identity identity = prepareModel(identityBean);  
		identityService.update(identity);
	    model.put("identity", prepareIdentityBean(identity));  
	    model.put("identities",  prepareListofBean(identityService.readAllIdentities()));  
	    return new ModelAndView("modify", model);  
	 }  
		
	@RequestMapping(value = "/index", method = RequestMethod.GET)  
	public ModelAndView welcome() {  
	  return new ModelAndView("index");  
	 } 
	
	private Identity  prepareModel(IdentityBean identityBean){  
		Identity identity = new Identity();  
		identity.setUid(identityBean.getUid());  
		identity.setFirstName(identityBean.getFirstName());  
		identity.setLastName(identityBean.getLastName());  
		identity.setEmail(identityBean.getEmail());  
		identity.setPassword(identityBean.getPassword());  
		identityBean.setUid(null);  
		 return identity;  
		 }  
		   
	 private List<IdentityBean> prepareListofBean(List<Identity> identities){  
		  List<IdentityBean> beans = null;  
		  if(identities != null && !identities.isEmpty()){  
			   beans = new ArrayList<IdentityBean>();  
			   IdentityBean bean = null;  
			   for(Identity identity : identities){  
				    bean = new IdentityBean();  
				    bean.setUid(identity.getUid());
				    bean.setFirstName(identity.getFirstName());
				    bean.setLastName(identity.getLastName()); 
				    bean.setEmail(identity.getEmail());  
				    bean.setPassword(identity.getPassword());  
				    beans.add(bean);  
			   }  
		  }  
		  return beans;  
		 }  
		   
		 private IdentityBean prepareIdentityBean(Identity identity){  
			 	IdentityBean bean = new IdentityBean();  
			    bean.setUid(identity.getUid());
			    bean.setFirstName(identity.getFirstName());
			    bean.setLastName(identity.getLastName()); 
			    bean.setEmail(identity.getEmail());  
			    bean.setPassword(identity.getPassword());  
			    return bean;  
		 }  
}
