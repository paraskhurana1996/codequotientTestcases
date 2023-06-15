package baseClass;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
public class GetHttpResponse extends readFiles{
	 
	public static int httpStatus(String path) throws IOException {
		
	HttpURLConnection cn = (HttpURLConnection)new URL(path).openConnection();
	 // set HEADER request
    cn.setRequestMethod("HEAD");
    // connection initiate
    cn.connect();
    //get response code
	int res = cn.getResponseCode();
    return res;
	

}
}