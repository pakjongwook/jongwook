package edu.kh.io.run;

import edu.kh.io.service.IOService;

public class IORun {
	
	public static void main(String[] args) {
		
		IOService service = new IOService();
		
//		service.byteOutPut();
//		service.charOutPut();
//		service.byteInput();
//		service.charInput();
//		service.fileCopy();
//		service.objectOutput();
//		service.objectinput();
//		service.listOutput();  // object 폴더 에서 F5
		service.listInput();
		
	}
	
}
