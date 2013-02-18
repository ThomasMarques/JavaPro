package fr.isima.myant;

public class CompileTask extends Task 
{
	
	private String repoSrc;
	private String repoBin;
	
	
	
	public CompileTask(String repoSrc, String repoBin) {
		super();
		this.repoSrc = repoSrc;
		this.repoBin = repoBin;
	}



	public String getRepoSrc() {
		return repoSrc;
	}



	public void setRepoSrc(String repoSrc) {
		this.repoSrc = repoSrc;
	}



	public String getRepoBin() {
		return repoBin;
	}



	public void setRepoBin(String repoBin) {
		this.repoBin = repoBin;
	}



	@Override
	public void execute() {
		System.out.println("Compile "+ repoSrc + "/* in " + repoBin + " ..." );
	}

}
