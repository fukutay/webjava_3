package jp.co.systena.model;

public class Form {

  private String name;
  private String motive;
  
  public Form(String name, String motive) {

	    this.name = name;
	    this.motive = motive;
	  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMotive() {
    return motive;
  }

  public void setMotive(String motive) {
    this.motive = motive;
  }
}
