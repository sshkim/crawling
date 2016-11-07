package sshkim.crawling.network.service;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by sshkim on 2016. 10. 11..
 */
public class ApplicationServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    private final Logger logger = LoggerFactory.getLogger(ApplicationServerHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest req) throws Exception {

        for(Map.Entry<String, String> header : req.headers()){
            System.out.println(header.getKey() + " | " + header.getValue());
        }
        final FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);

        response.headers().set("custom-response-header", "Some value");

        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
//
//        HttpRequestModel httpRequestModel = new HttpRequestModel();
//        HttpMethod httpMethod = req.getMethod();
//
//        httpRequestModel.setHttpMethod(httpMethod);
//        httpRequestModel.setUri(req.getUri());
//
//
//        System.out.println(httpRequestModel.getUri());
//        if (HttpMethod.POST.equals(httpMethod)) {
//
//        } else if (HttpMethod.GET.equals(httpMethod)) {
//
//        }

//        if (HttpHeaders.is100ContinueExpected(fullHttpRequest)) {
//            channelHandlerContext.write(new DefaultFullHttpResponse(HTTP_1_1, CONTINUE));
//        }
//
//        byte[] returnMessageBypes = null;
//
//        HttpRequestModel httpRequestModel = getHttpModel(fullHttpRequest); 										//
//        HttpValidateStatus httpValidateStatus = httpValidatorExecuter.execute(httpRequestModel);				//
//
//        if(HttpValidateStatus.REQUEST_STATUS_TRUE == httpValidateStatus.getStatus()){							//
//            logger.warn(httpRequestModel.toString());
//            returnMessageBypes = requestRouter.doProcess(httpRequestModel);
//        } else {
//            returnMessageBypes = httpValidateStatus.getStatusMessage();											//
//        }
//
//        boolean close = HttpHeaders.Values.CLOSE.equalsIgnoreCase(fullHttpRequest.headers().get(CONNECTION))	//
//                || fullHttpRequest.getProtocolVersion().equals(HttpVersion.HTTP_1_0)
//                && HttpHeaders.Values.KEEP_ALIVE.equalsIgnoreCase(fullHttpRequest.headers().get(CONNECTION)) == false;
//
//
//        FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(returnMessageBypes));
//        response.headers().set(CONTENT_TYPE, NettyHttpHeaderConstant.CONTENT_TYPE_APPLICATION_JSON_CHARSET_UTF_8);
//        response.headers().set(CONTENT_LENGTH, response.content().readableBytes());
//        channelHandlerContext.write(response);
//        ChannelFuture future = channelHandlerContext.writeAndFlush(Unpooled.EMPTY_BUFFER);
//
//        if(close == true){
//            future.addListener(ChannelFutureListener.CLOSE);
//        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
