package org.txazo.spring.cloud.zuul;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author tuxiaozhou
 * @date 2021/1/31
 */
public class SpringCloudTest {

    private OkHttpClient httpClient;

    @Test
    public void test() throws Exception {
        httpClient = new OkHttpClient().newBuilder()
                .retryOnConnectionFailure(true)
                .connectTimeout(1000, TimeUnit.MILLISECONDS)
                .readTimeout(1000, TimeUnit.MILLISECONDS)
                .dispatcher(new Dispatcher(new ThreadPoolExecutor(10, 30,
                        60, TimeUnit.SECONDS, new LinkedBlockingQueue<>())))
                .build();
        httpClient.dispatcher().setMaxRequests(1000);
        httpClient.dispatcher().setMaxRequestsPerHost(100);

        for (; ; ) {
            System.out.println(get("http://127.0.0.1:8080/user-web/spring-cloud-web/user/10"));
            Thread.sleep(10);
        }
    }

    private String get(String url) throws Exception {
        return httpClient.newCall(buildRequest("GET", url, null, null)).execute().body().string();
    }

    private static Request buildRequest(String method, String url, Map<String, String> headers, RequestBody requestBody) {
        Request.Builder requestBuilder = new Request.Builder()
                .url(url)
                .method(method, requestBody);
        if (headers != null && headers.size() > 0) {
            headers.forEach((key, value) -> requestBuilder.addHeader(key, value));
        }
        return requestBuilder.build();
    }

}
