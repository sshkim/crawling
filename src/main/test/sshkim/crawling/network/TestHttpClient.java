package sshkim.crawling.network;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpCoreContext;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by sshkim on 2016. 11. 7..
 */
public class TestHttpClient {

    @Test
    public void testHttpClient(){
        HttpRequestExecutor httpRequestExecutor = new HttpRequestExecutor();
        HttpCoreContext httpCoreContext = HttpCoreContext.create();
    }

    @Test
    public void getHttpClient() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080");
        CloseableHttpResponse response = null;
        response = httpClient.execute(httpGet);
        try {
            System.out.println(response.getStatusLine());

            HttpEntity entity = response.getEntity();
            EntityUtils.consume(entity);

            InputStream inputStream = entity.getContent();
            inputStream.read();
        } finally {
            response.close();
        }
    }

    @Test
    public void postHttpClient(){
        HttpPost httpPost = new HttpPost("http://localhost:8080");

    }
}
