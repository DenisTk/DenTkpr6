import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Work1 {
    public static void main(String[] args) throws Exception {


        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://lib.ru");
        try (CloseableHttpResponse resp = client.execute(get)) {
            String html= EntityUtils.toString(resp.getEntity());
            Pattern p=Pattern.compile("http://\\S+");
            Matcher m=p.matcher(html);
            while(m.find()){
                System.out.println(m.group());
            }

        }
        client.close();
    }
}
