package com.coba.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
@ComponentScan
@EnableAutoConfiguration
public class UploadDownloadController {

	@Autowired
	private JavaMailSender mailSender;

	// private static final Logger logger =
	// LoggerFactory.getLogger(UploadController.class);

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public ModelAndView upload(ModelAndView mv) {

		mv.setViewName("upload");
		return mv;
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView uploadHandler(MultipartFile file, ModelAndView mv) {
		// nurse.setUserPhoto(nurse.getUserName() + ".jpg");

		if (!file.isEmpty()) {

			///// Validasi tipe file harus PDF/////
			if (!file.getContentType().equals("application/pdf")) {
				throw new RuntimeException("Only PDF files are accepted");
			} else {
				try {

					/**
					 * Kalau file langsung ditaruh di folder local system
					 */
					// byte[] bytes = file.getBytes();
					//
					// // creating directory to store file
					// System.getProperty("catalina.home");
					// File dir = new File(File.separator + "resources_CV");
					// if (!dir.exists())
					// dir.mkdirs();
					// // Create file sesuai nama original file yg diupload
					// ("CV.pdf")
					// File serverFile = new File(dir.getAbsolutePath() +
					// File.separator + file.getOriginalFilename());
					// BufferedOutputStream stream = new
					// BufferedOutputStream(new FileOutputStream(serverFile));
					// stream.write(bytes);
					// stream.close();
					// logger.info("Server file locaton= " +
					// serverFile.getAbsolutePath());

					/**
					 * File langsung dikirim ke email, dalam hal ini email HR
					 */
					MimeMessage message = mailSender.createMimeMessage();
					try {
						MimeMessageHelper mailMessage = new MimeMessageHelper(message, true, "UTF-8");
						mailMessage.setTo("topik.nopyana@pactera-indonesia.com");
						mailMessage.setSubject("IONIC - <DoNotReply> This email is generated automatically"
								+ "by Spring Boot");
						mailMessage.setText("Yeuh Masbroh :D http://www.google.com");

						mailMessage.addAttachment(file.getOriginalFilename(), file);
					} catch (MessagingException e) {
						throw new MailParseException(e);
					}
					mailSender.send(message);

				} catch (Exception e) {
					System.out.println("failed to upload file " + e);
				}
			}
		} else {
			System.out.println("Empty file");
		}

		mv.setViewName("uploadSuccess");
		return mv;
	}

	/**
	 * 
	 * Untuk DOWNLOAD
	 * 
	 */
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ModelAndView download(ModelAndView mv){
		mv.setViewName("download");
		return mv;
	}
	
	
	@RequestMapping(value = "/downloadCV", method = RequestMethod.GET)
	public ModelAndView downloadCV(ModelAndView mv, HttpServletRequest request, HttpServletResponse response) {
		try {
			String filePath = "/resources_CV/file.pdf";

			// get absolute path of the application
			ServletContext context = request.getServletContext();
			String appPath = context.getRealPath("");
			System.out.println("appPath = " + appPath);

			// construct the complete absolute path of the file dari DIREKTORI
			String fullPath = appPath + filePath;
			File downloadFile = new File("D:/resources_CV/file.pdf");
			FileInputStream inputStream = new FileInputStream(downloadFile);

			// get MIME type of the file
			String mimeType = context.getMimeType(fullPath);
			if (mimeType == null) {
				// set to binary type if MIME mapping not found
				mimeType = "application/octet-stream";
			}
			System.out.println("MIME type: " + mimeType);

			// set content attributes for the response
			response.setContentType(mimeType);
			response.setContentLength((int) downloadFile.length());

			// set headers for the response
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
			response.setHeader(headerKey, headerValue);

			// get output stream of the response
			OutputStream outStream = response.getOutputStream();

			byte[] buffer = new byte[10240];
			int bytesRead = -1;

			// write bytes read from the input stream into the output stream
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}

			inputStream.close();
			outStream.close();
		} catch (Exception e) {
			System.out.println("failed to Download file " + e);
		}

		mv.setViewName("download");
		return mv;
	}

}