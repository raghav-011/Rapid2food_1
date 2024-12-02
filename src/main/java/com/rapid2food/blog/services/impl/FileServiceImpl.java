package com.rapid2food.blog.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rapid2food.blog.services.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		
		// file name
		String name=file.getOriginalFilename();
		
		// fullpath
		String randomID=UUID.randomUUID().toString();
		String filename1=randomID.concat(name.substring(name.lastIndexOf(".")));
		
		String filepath=path+File.separator+filename1;
		
		//create folder if not created
		File file1=new File(path);
		if(!file1.exists())
		{
			file1.mkdir();
		}
		
		Files.copy(file.getInputStream(), Paths.get(filepath));
		
		return filename1;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		String fullpath=path+File.separator+fileName;
		InputStream is=new FileInputStream(fullpath);
		return is;
	}

}
