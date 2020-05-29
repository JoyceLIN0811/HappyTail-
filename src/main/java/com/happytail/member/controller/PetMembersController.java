package com.happytail.member.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.happytail.member.model.PetMembers;
import com.happytail.member.model.service.PetMembersService;


@Controller
public class PetMembersController {	
	
	@Autowired
	PetMembersService service;
	
	@Autowired
	PetMembers petMember;
	
	@Autowired
	ServletContext context;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String processRregister() {
		return "Member/memberRegister";
//		return "Member/register";
	}	
	
	
	@RequestMapping(value = "/memberUpdate", method = RequestMethod.POST)
	public String updatePetMembers(
//			@RequestParam(name="account") String account,
			@RequestParam(name="memberId") String memberId,
			@RequestParam(name="username") String username,
			@RequestParam(name="password") String password,
//			@RequestParam(name="email") String email,
			@RequestParam(name="gender") String gender,
			@RequestParam(name="bday") String bday,
			@RequestParam(name="age") String age,
			@RequestParam(name="address") String address,
			@RequestParam(name="phone") String phone,
			@RequestParam(name="petType") String petType,
			@RequestParam(name="memberImage") MultipartFile memberImage,
			HttpServletRequest request,
			Model model		
			
			) {	
//		System.out.println(gender);
		PetMembers petmember = service.selectPetMembers(Integer.valueOf(memberId));
		Map<String, String> errorMsg = new HashMap<String, String>();	
		model.addAttribute("errorMsg", errorMsg);		
		
		if(username == null || username.trim().length() == 0) {
			errorMsg.put("usernameError", "帳號欄不可空白");
		}else if(!username.isEmpty()) {
			String un = service.selectPetMembers(username);			
			if(un != null && un != petmember.getUsername()) {
				errorMsg.put("userIsExist", "會員帳號重複");				
			}			
		}		
		
		if(password == null || password.trim().length() == 0) {
			errorMsg.put("passwordError", "密碼欄不可空白");
		}
		
		Date bdate = null;
		try {
			bdate = Date.valueOf(bday);
		}catch(Exception e) {
			e.printStackTrace();
			errorMsg.put("mBbday", "出生日期格式錯誤");
		}
		
		Integer age2 = null;
		try {
			age2 = Integer.parseInt(age);
			
		}catch(Exception e) {
			e.printStackTrace();
			errorMsg.put("mAge", "年齡格式錯誤");
		}
		
		if(memberImage.getSize() == 0) {
			
		} else {		
			String originalFilename = memberImage.getOriginalFilename();			
			if (originalFilename.length() > 0 && originalFilename.lastIndexOf(".") > -1) {
				petmember.setFileName(originalFilename);
//					ext = picture.getOriginalFilename().substring(originalFilename.lastIndexOf("."));
			}else {
				petmember.setFileName(username);
			}			
			
			if (memberImage != null && !memberImage.isEmpty()) {				
				try {
					byte[] b = memberImage.getBytes();
					Blob blob = new SerialBlob(b);
					petmember.setMemberImage(blob);
				} catch (IOException e) {					
						e.printStackTrace();
				} catch (SerialException e) {					
						e.printStackTrace();
				} catch (SQLException e) {					
						e.printStackTrace();
				}				
			}
		}
		
		if (!errorMsg.isEmpty()) {	
			String gen = "M";
			if(gender.equalsIgnoreCase(gen)) {
				model.addAttribute("gender", true);
			}else {
				model.addAttribute("gender", false);
			}			
			return "Member/member_CRUD";
		}
//		petmember.setAccount(account);
		petmember.setUsername(username);
		petmember.setPassword(password);
//		petMember.setEmail(account);
		petmember.setGender(gender);
		petmember.setBday(bdate);
		petmember.setAge(age2);
		petmember.setAddress(address);
		petmember.setPhone(phone);
//		petmember.setPetType(petType);
		petmember.setUpdateDate(new Timestamp(System.currentTimeMillis()));
		
		PetMembers um = service.updatePetMembers(petmember);
		HttpSession session = request.getSession();
		session.setAttribute("LoginOK", um);
		
		return "../../index";
	}
	
	@RequestMapping(value = "/memberCenter", method = RequestMethod.GET)
	public String selectPetMembers(HttpServletRequest request, Model model) {		
		HttpSession session = request.getSession();
		PetMembers pMember = (PetMembers) session.getAttribute("LoginOK");
		PetMembers petmember = service.selectPetMembers(Integer.valueOf(pMember.getId()));
		
		String gen = "M";		
		boolean re =  petmember.getGender().equalsIgnoreCase(gen) ;
		System.out.println(re);
		System.out.println( petmember.getGender());
		
		if( petmember.getGender().equalsIgnoreCase(gen)) {
			model.addAttribute("gender", true);
		}else {
			model.addAttribute("gender", false);
		}
		model.addAttribute("petMember",  petmember);
		return "Member/member_CRUD";			
	}	
	
	
	@RequestMapping(value = "/registerInsert", method = RequestMethod.POST)
	public String insertMembers(
		@RequestParam(name="account") String account,	
		@RequestParam(name="username") String username,
		@RequestParam(name="password") String password,
//		@RequestParam(name="email") String email,
		@RequestParam(name="gender") String gender,
		@RequestParam(name="bday") String bday,
		@RequestParam(name="age") String age,
		@RequestParam(name="address") String address,
		@RequestParam(name="phone") String phone,
//		@RequestParam(name="petType") String petType,		
		@RequestParam(name="memberImage") MultipartFile memberImage,
		Model model
			) {
//		System.out.println(username);
//		System.out.println(password);
//		System.out.println(gender);
	
		
		Map<String, String> errorMsg = new HashMap<String, String>();	
		model.addAttribute("errorMsg", errorMsg);
		
		if(account == null || account.trim().length() == 0) {
			errorMsg.put("accountError", "帳號欄不可空白");
		}else if(!account.isEmpty()) {
			String un = service.selectPetMembers(account);
			
			if(un != null) {
				errorMsg.put("accountIsExist", "會員帳號重複");				
			}			
		}	
		
		if(username == null || username.trim().length() == 0) {
			errorMsg.put("usernameError", "姓名欄不可空白");
		}
		
		if(password == null || password.trim().length() == 0) {
			errorMsg.put("passwordError", "密碼欄不可空白");
		}
		
		Date bdate = null;
		try {
			bdate = Date.valueOf(bday);
		}catch(Exception e) {
			e.printStackTrace();
//			errorMsg.put("mBbday", "出生日期格式錯誤");
		}
		
		Integer age2 = null;
		try {
			age2 = Integer.parseInt(age);
			
		}catch(Exception e) {
			e.printStackTrace();
			errorMsg.put("mAge", "年齡格式錯誤");
		}		
		
//		if(memberImage.getSize() == 0) {
//			errorMsg.put("noImage", "請附上圖片");
//		} 
		
		if (!errorMsg.isEmpty()) {	
			String gen = "M";
			if(gender.equalsIgnoreCase(gen)) {
				model.addAttribute("gender", true);
			}else {
				model.addAttribute("gender", false);
			}
			return "Member/memberRegister";
		}
		
		String originalFilename = memberImage.getOriginalFilename();			
		if (originalFilename.length() > 0 && originalFilename.lastIndexOf(".") > -1) {
				petMember.setFileName(originalFilename);
//				ext = picture.getOriginalFilename().substring(originalFilename.lastIndexOf("."));
		}else {
			petMember.setFileName(username);
		}			
		
		if (memberImage != null && !memberImage.isEmpty()) {				
			try {
				byte[] b = memberImage.getBytes();
				Blob blob = new SerialBlob(b);
				petMember.setMemberImage(blob);
			} catch (IOException e) {					
					e.printStackTrace();
			} catch (SerialException e) {					
					e.printStackTrace();
			} catch (SQLException e) {					
					e.printStackTrace();
			}				
		}
		
		petMember.setAccount(account);
		petMember.setUsername(username);
		petMember.setPassword(password);
		petMember.setEmail(username);
		petMember.setGender(gender);
		petMember.setBday(bdate);
		petMember.setAge(age2);
		petMember.setAddress(address);
		petMember.setPhone(phone);
//		petMember.setPetType(petType);	
		
//		System.out.println(petMember.getUsername());
//		System.out.println(petMember.getPassword());
	
		PetMembers pm = service.insertPetMembers(petMember);		
		
		if (pm != null) {
			return "../../index";
		} else {
			return "Member/memberRegister";
		}
	}
	
	@GetMapping("/memberImage/{id}")
	public ResponseEntity<byte[]> getMemberImage(@PathVariable("id") Integer id) {
		byte[] body = null;
		ResponseEntity<byte[]> re = null;
		MediaType mediaType = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		
		PetMembers pMember = service.selectPetMembers(id);
		if (pMember == null) {
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}
		
		String filename = pMember.getFileName();
		if (filename != null) {
			if (filename.toLowerCase().endsWith("jfif")) {
				mediaType = MediaType.valueOf(context.getMimeType("dummy.jpeg"));
			} else {
				mediaType = MediaType.valueOf(context.getMimeType(filename));
				headers.setContentType(mediaType);
			}
		}
		
		Blob blob = pMember.getMemberImage();
		if (blob != null) {
			body = blobToByteArray(blob);
		}else {
			String path = "/img/NoImage.png";			
			body = fileToByteArray(path);			
		}		
		re = new ResponseEntity<byte[]>(body, headers, HttpStatus.OK);

		return re;		
	}
	
	private byte[] fileToByteArray(String path) {
		byte[] result = null;
		try (InputStream is = context.getResourceAsStream(path);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
			byte[] b = new byte[819200];
			int len = 0;
			while ((len = is.read(b)) != -1) {
				baos.write(b, 0, len);
			}
			result = baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public byte[] blobToByteArray(Blob blob) {
		byte[] result = null;
		try (InputStream is = blob.getBinaryStream(); ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
			byte[] b = new byte[819200];
			int len = 0;
			while ((len = is.read(b)) != -1) {
				baos.write(b, 0, len);
			}
			result = baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}	
