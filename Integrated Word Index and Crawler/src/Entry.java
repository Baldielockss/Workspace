
public class Entry {
	
	 private String string;
     private long value;
     private long link;

     public Entry(String string, long value, long link){
    	 this.string = string;
    	 this.value = value;
    	 this.link = link;
     }

     public String getString(){
    	 return string;
     }

     public long getValue(){
    	 return value;
     }

     public void setValue(long value){
    	 this.value = value;
     }

     public long getLink(){
    	 return link;
     }

     public void setLink(long link){
    	 this.link = link;
     }
}
