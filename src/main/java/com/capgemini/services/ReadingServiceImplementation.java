package com.capgemini.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Lob;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.capgemini.exception.NoSuchConnectionException;
import com.capgemini.exception.NoSuchCustomerException;
import com.capgemini.model.FileUploadUtil;
import com.capgemini.model.Reading;
import com.capgemini.repository.ConnectionRepository;
import com.capgemini.repository.ReadingRepository;

@Service
public class ReadingServiceImplementation implements ReadingService{

	@Autowired
	private ReadingRepository readingRepo;
	
	@Autowired
	private ConnectionRepository connectionRepo;
	
	@Override
	public Reading findMeterReadingByConsumerNumberAndBillDate(Long consumerNumber, LocalDate billDate)throws NoSuchCustomerException {
		if(connectionRepo.findByConsumerNumber(consumerNumber)==null) {
			throw new NoSuchCustomerException("No such customer exists");
		}
		return readingRepo.findReadingByConsumerNumberAndBillDate(consumerNumber, billDate);
	}

	@Override
	public List<Reading> findMeterReadingByConsumerNumber(Long consumerNumber) throws NoSuchCustomerException {
		if(connectionRepo.findByConsumerNumber(consumerNumber)==null) {
			throw new NoSuchCustomerException("No such customer exists");
		}
		return readingRepo.findReadingByConsumerNumber(consumerNumber);
	}

	@Override
	public ResponseEntity<Object> selfSubmitReading(Long consumerNumber,int unitsConsumed,LocalDate readingDate, MultipartFile multipartFile) throws NoSuchConnectionException, IOException {
		
		if(connectionRepo.findByConsumerNumber(consumerNumber)==null) {
			throw new NoSuchCustomerException("No such customer exists");
		}
		String readingPhotoName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		
		Reading newReading = new Reading();
		newReading.setConsumerNumber(consumerNumber);
		newReading.setUnitsConsumed(unitsConsumed);
		newReading.setReadingDate(readingDate);
		
		readingRepo.save(newReading);
		
		
		String uploadDir = "reading-photos/" + newReading.getConsumerNumber()+"_"+newReading.getReadingId();
		 
        String path = FileUploadUtil.saveFile(uploadDir, readingPhotoName, multipartFile);
        
        System.out.println(path);
        
        newReading.setReadingPhoto(path+readingPhotoName);
        
        readingRepo.save(newReading);

		return new ResponseEntity<Object>("Reading Submitted Successfully",HttpStatus.OK);
	}

}