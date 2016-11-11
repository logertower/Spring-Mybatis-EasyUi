/**
 * 
 */
package com.founder.medical.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

/**
 * 远程接口调用
 * <p>
 * 支持get、set方式。同时会有尝试的功能，可以指定尝试次数，当链接失败时，达到尝试次数后才结束远程调用
 * 
 * @author xl.li
 * 
 */
public class HttpSender {
	private HttpHeader header = null;
	public static final String GET = "GET";
	public static final String POST = "POST";
	private int times = 3;
	private int Connectiontimeout = 10000;
	private int Requesttimeout = 5 * 60 * 1000;
	private String method;

	private static HttpSender httpPostSender = new HttpSender(null, 3, 10000,
			100000, POST);

	private static HttpSender httpGetSender = new HttpSender(null, 3, 10000,
			100000, GET);

	/**
	 * 获取默认HttpSender实例
	 * 
	 * @return
	 */
	public static HttpSender Instance(String method) {
		if (method.equals(GET)) {
			return httpGetSender;
		}

		return httpPostSender;
	}

	public HttpSender(HttpHeader header, int times, int Conntimeout,
			int requestTimeout, String method) {

		this();

		this.header = header;
		this.Connectiontimeout = Conntimeout;
		this.Requesttimeout = requestTimeout;
		this.times = times;
		this.method = method;

	}

	public HttpSender() {
	}

	public String sendRequst(String url, String encoding) {
		HttpUriRequest httpmethod = this.getHttpMethod(url, method);
		this.addHeader(httpmethod);
		this.setParams(httpmethod, Connectiontimeout, this.Requesttimeout);
		String content = null;
		int n = 1;
		while (content == null) {
			try {
				content = this.sendRequest(httpmethod, encoding);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			n++;

			if (n > times)
				break;

		}

		return content;

	}

	/**
	 * 向服务器发送内容，并得到返回结果
	 * 
	 * @param url
	 * @param contentType
	 *            发送的内容类型
	 * @param encoding
	 *            编码
	 * @param data
	 * @return
	 */
	public String postData(String url, String contentType, String encoding,
			String data) throws Exception {
		HttpPost httpPost = new HttpPost(url);
		StringEntity myEntity = new StringEntity(data, encoding);
		httpPost.addHeader("Content-Type", contentType);
		httpPost.setEntity(myEntity);
		DefaultHttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(httpPost);
		HttpEntity resEntity = response.getEntity();
		InputStreamReader reader = new InputStreamReader(
				resEntity.getContent(), encoding);
		char[] buff = new char[1024];
		int length = 0;
		StringBuilder sb = new StringBuilder();
		while ((length = reader.read(buff)) != -1) {
			sb.append(new String(buff, 0, length));
		}

		client.getConnectionManager().shutdown();

		return sb.toString();
	}

	public HttpUriRequest getHttpMethod(String url, String method) {
		if (method.toLowerCase().equals("get")) {
			return new HttpGet(url);
		} else if (method.toLowerCase().equals("post")) {
			return new HttpPost(url);
		}

		return null;
	}

	public void addHeader(HttpUriRequest method) {
		if (this.header != null) {
			for (String hname : this.header.getHeaderNames()) {
				method.addHeader(hname, this.header.getValue(hname));

			}
		}
	}

	public void setParams(HttpUriRequest method, int Connectiontimeout,
			int requestTimeout) {
		HttpParams httpparameters = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpparameters,
				Connectiontimeout);// 设置连接超时
		HttpConnectionParams.setSoTimeout(httpparameters, requestTimeout);// 设置请求超时
		method.setParams(httpparameters);
	}

	public String sendRequest(HttpUriRequest method, String encoding)
			throws ClientProtocolException, IOException {
		String content = null;
		DefaultHttpClient client = new DefaultHttpClient();

		HttpResponse response = client.execute(method);
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				content = EntityUtils.toString(entity, encoding);
				EntityUtils.consume(entity);
			}
		}
		if (null != client) {
			client.getConnectionManager().shutdown();
		}
		return content;
	}

	/**
	 * 通过request Get请求获得String数据。 当有跨域连接获取数据时，请用此方法。
	 * 
	 * @param url
	 *            请求的url
	 * @param charset
	 *            编码格式(默认：utf-8)
	 * @return String数据
	 * @throws Exception
	 */
	public String getRequest(String url, String charset) throws Exception {
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(url);
		String response = "";

		if (null != charset) {

			method.addRequestHeader("Content-Type",
					"application/x-www-form-urlencoded; charset=" + charset);
		} else {
			method.addRequestHeader("Content-Type",
					"application/x-www-form-urlencoded; charset=" + "utf-8");
		}

		try {
			int statusCode = client.executeMethod(method);
			if (statusCode == HttpStatus.SC_OK) {

				InputStream resStream = method.getResponseBodyAsStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(
						resStream, charset));
				StringBuffer resBuffer = new StringBuffer();
				String resTemp = "";
				while ((resTemp = br.readLine()) != null) {

					resBuffer.append(resTemp);
				}

				response = resBuffer.toString();
			}

			method.releaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return response;
	}
}
