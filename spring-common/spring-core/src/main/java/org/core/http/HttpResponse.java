package org.core.http;

import java.util.HashMap;
import java.util.Map;

public class HttpResponse {

    private int statusCode = Http.HTTP_OK;

    private Map<String, String> headers = new HashMap<String, String>();

    private String contentType = Http.APPLICATION_JSON;

    private Object content;

    private String message = Http.HTTP_SUCCESS;

    public HttpResponse() {

    }

    public HttpResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public HttpResponse(int statusCode, Object content, String message) {
        this.statusCode = statusCode;
        this.content = content;
        this.message = message;
    }

    public HttpResponse(int statusCode, String contentType, Object content, String message) {
        this.statusCode = statusCode;
        this.contentType = contentType;
        this.content = content;
        this.message = message;
    }

    public HttpResponse(int statusCode, Object content) {
        this.statusCode = statusCode;
        this.content = content;
    }

    public HttpResponse(int statusCode, String contentType, Object content) {
        this.statusCode = statusCode;
        this.contentType = contentType;
        this.content = content;
    }

    public static HttpResponse ok() {
        HttpResponse response = new HttpResponse(Http.HTTP_OK, Http.HTTP_SUCCESS);
        return response;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
