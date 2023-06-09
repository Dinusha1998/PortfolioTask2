package Abominodo;

public class Location extends SpacePlace {
  public int c;
  public int r;
  public DIRECTION d;
  
  public enum DIRECTION {VERTICAL, HORIZONTAL};
  
  public Location(int r, int c) {
    this.r = r;
    this.c = c;
  }

  public Location(int r, int c, DIRECTION d) {    
    this(r,c);
    this.d=d;
  }
  
  public String toString() {
	    String result = "(" + (c+1) + "," + (r+1);

	    if (d != null) {
	        result += "," + d;
	    }

	    return result + ")";
	}

}
