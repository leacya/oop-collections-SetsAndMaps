package dkit.sd2.maps;


public class Book
{
    int code;       // scanner code
    String title;

    public Book(int code, String title){
        this.code = code;
        this.title = title;
    }

    public int getCode(){
        return code;
    }

    public String getTitle(){
        return title;
    }
}

