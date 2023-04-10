package co.com.tcs.certification.reqres.exceptions;

public class AssertionsServices extends AssertionError{

    private static final long serialVersionUID = 1L;
    public static final String THE_STATUS_CODE_SERVICE_IS_NOT_EXPECTED = "The status code services response isn't expected";

    public static final String QUANTITY_FIELDS_SERVICE_IS_NOT_EXPECTED = "Quantity fields services isn't expected";

    public static final String SCHEMA_SERVICE_IS_NOT_EXPECTED = "Schema service isn't expected";
    public static final String RESPONSE_FIELDS_ARE_NOT_EXPECTED = "Response fields are not expected";
    public static final String RESPOSE_DATA_ARE_NOT_EXPECTED = "Response data aren't expected";

    //Constructor
    public AssertionsServices(String message, Throwable cause){
        super(message, cause);
    }    public AssertionsServices(String message){
        super(message);
    }
}
