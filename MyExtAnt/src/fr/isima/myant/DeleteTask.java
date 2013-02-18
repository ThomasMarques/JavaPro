package fr.isima.myant;

public class DeleteTask extends Task {

	public DeleteTask(String fileName) {
		super();
		this.fileName = fileName;
	}



	private String fileName;
	
	
	
	public String getFileName() {
		return fileName;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	@Override
	public void execute() 
	{	
		System.out.println("Delete "+ fileName  + "...");
	}

}
