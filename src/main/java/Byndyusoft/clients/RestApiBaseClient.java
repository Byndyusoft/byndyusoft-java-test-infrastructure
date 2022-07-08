package Byndyusoft.clients;


import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class RestApiBaseClient {

    public static CloseableHttpResponse postWithParams(String uri, String contentType, HttpEntity entity)
            throws IOException {
        CloseableHttpClient client = HttpClients.custom().build();
        HttpUriRequest request = RequestBuilder.post()
                .setUri(uri)
                .setHeader(HttpHeaders.ACCEPT, "*/*")
                .setHeader(HttpHeaders.CONTENT_TYPE, contentType)
                .setEntity(entity)
                .build();
        System.out.println(request);

        return client.execute(request);
        /*String bodyAsString = EntityUtils.toString(response.getEntity());
        int code = response.getStatusLine().getStatusCode();
        client.close();

        return bodyAsString + "\n" + "Статус ответа от сервера: " + code;*/
    }

    public static CloseableHttpResponse postWithParamsA(String uri, String contentType, HttpEntity entity)
            throws IOException {
        CloseableHttpClient client = HttpClients.custom().build();
        HttpUriRequest request = RequestBuilder.post()
                .setUri(uri)
                .setHeader(HttpHeaders.ACCEPT, "*/*")
                .setHeader(HttpHeaders.CONTENT_TYPE, contentType)
                .setHeader("id-token", "eyJhbGciOiJSUzI1NiIsImtpZCI6Ijg4RkNCNEY2OEIyNEZEMDZDNkNFQTI1NTI0RTIyQ0MzMkM3ODQwNDYiLCJ0eXAiOiJKV1QiLCJ4NXQiOiJpUHkwOW9za19RYkd6cUpWSk9Jc3d5eDRRRVkifQ.eyJuYmYiOjE2NTY0MTYwNzYsImV4cCI6MTY1NjQxNjM3NiwiaXNzIjoiaHR0cHM6Ly90LWxlZ29hdXRoLWFzMDIuaHEucnUuY29ycC5sZXJveW1lcmxpbi5jb20iLCJhdWQiOiJsbS1icG1zLXZlZC1leHQiLCJpYXQiOjE2NTY0MTYwNzYsImF0X2hhc2giOiJtMF9XODFoc0NkdnUyMjdLdWJ3U0Z3Iiwic3ViIjoiOTY5IiwiYXV0aF90aW1lIjoxNjU2NDEwMzE0LCJpZHAiOiJsb2NhbCIsInRpdGxlIjoidGVzdC5zYW1wbGVjb29yZGluYXRvciIsInZlZF9tb2RlIjoiVHJhZGUiLCJ2ZWRfb3JnYW5pemF0aW9uSWQiOiI2MGFjYjY3NmVjNjUxOTAwMTg4MGM1Y2QiLCJ2ZWRfcm9sZSI6IlNhbXBsZUNvb3JkaW5hdG9yIiwiZnVsbF9uYW1lIjoidGVzdC5zYW1wbGVjb29yZGluYXRvciIsIm5hbWUiOiJ0ZXN0LnNhbXBsZWNvb3JkaW5hdG9yIiwiZW1haWwiOiJ0ZXN0LnNhbXBsZWNvb3JkaW5hdG9yQGxlcm95bWVybGluLnJ1IiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImFtciI6WyJwd2QiXX0.Ps9a5knLQ1KELlzU7c5p66VEd_LPqTmp_OmkVtOdqtn0lyuojKjZooiCysdIMQ1mk73NkuiCmY-IMdeyBMEIK9HGaiOsNBRyFI_4BwKzZxGUs4P2z1XFm6BP1wCi6yFXCPgcrchGiQqffxyl44bm7FwkQRE9mvWxPhKg35KnGrxzzm5BG_BUuVLQ4d5WhPdk6iNHDDVTr0o_eVLnFLUDCltLNP3UkdThQzSpw_hh9BgxdopGmvaT-w3Y7osZ20EpgUDcf3VSRWtoXdR6skQ8qJEpax_HL-BDPtUaPEIV5ErOTcR9NOWIxT-pVbqdIfm_bq0Mfo6zVJi74z7minAXaA")
                .setEntity(entity)
                .build();
        System.out.println(request);

        /*CloseableHttpResponse response = client.execute(request);
        String bodyAsString = EntityUtils.toString(response.getEntity());
        int code = response.getStatusLine().getStatusCode();
        client.close();*/

        return client.execute(request);
    }

    public static CloseableHttpResponse getWithParams(String uri, Header[] headers)
            throws IOException {
        CloseableHttpClient client = HttpClients.custom().build();
        HttpUriRequest request = RequestBuilder.get()
                .setUri(uri)
                .setHeader(HttpHeaders.ACCEPT, "*/*")
                .build();
        request.setHeaders(headers);
        //System.out.println(headers);
        //System.out.println(httpGet);

        return client.execute(request);
        /*int code = response.getStatusLine().getStatusCode();
        client.close();

        return Integer.toString(code);*/
    }

}
