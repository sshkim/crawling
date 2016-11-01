package sshkim.crawling.network.model;

import io.netty.handler.codec.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sshkim on 2016. 10. 31..
 */
public class HttpRequestModel {

    private HttpMethod httpMethod;
    private String uri;
    private Map<String, String> parameterMap = new HashMap<String, String>();

}
