package customExceptions;

import java.io.Serializable;

public class CustomException extends Exception implements Serializable{

	private static final long serialVersionUID = 1L;
    
	public CustomException() {
        super();
    }
    public CustomException(String msg)   {
        super(msg);
    }
    public CustomException(String msg, Exception e)  {
        super(msg, e);
    }
    
    public CustomException(String msg, Throwable t)  {
        super(msg, t);
    }
}
