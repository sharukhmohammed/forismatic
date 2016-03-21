import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Quote
{
    String text;

    public Quote(String format)
    {
        try
        {
            /*Creating Apache HTTP Client and HTTP Post Method*/
            HttpClient httpclient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost("http://api.forismatic.com/api/1.0/");

            /*Setting API towards Forismatic*/
            List<NameValuePair> reqSetting = new ArrayList<>();
            reqSetting.add(new BasicNameValuePair("method", "getQuote"));
            reqSetting.add(new BasicNameValuePair("format", format));
            //reqSetting.add(new BasicNameValuePair("key", "1"));
            reqSetting.add(new BasicNameValuePair("lang", "en"));
            httppost.setEntity(new UrlEncodedFormEntity(reqSetting, "UTF-8"));

            /*Sending the HTTP Request*/
            HttpResponse response = httpclient.execute(httppost);

            /*Getting the Response*/
            HttpEntity entity = response.getEntity();
            if (entity != null)
            {
                InputStream inputStream;
                inputStream = entity.getContent();
                text = getQuoteFromStream(inputStream);
                //TODO: Convert Input Stream into XML||JSON||String Res
            }
        }
        catch (UnsupportedEncodingException | ClientProtocolException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.getMessage();
            e.printStackTrace();
        }
    }


    private static String getQuoteFromStream(InputStream is) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        String line ;
        StringBuilder stringBuilder = new StringBuilder();
        while((line = in.readLine()) != null)
        {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }
}
