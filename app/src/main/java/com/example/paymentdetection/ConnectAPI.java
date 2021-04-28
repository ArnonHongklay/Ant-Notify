package com.example.paymentdetection;

public class ConnectAPI {
//    public String getPOST(String url, List params) {
//        StringBuilder str = new StringBuilder();
//        HttpClient client = new DefaultHttpClient();
//        HttpPost httpPost = new HttpPost(url);
//
//        try {
//            httpPost.setEntity(new UrlEncodedFormEntity(params));
//            HttpResponse response = client.execute(httpPost);
//            StatusLine statusLine = response.getStatusLine();
//            int statusCode = statusLine.getStatusCode();
//            if (statusCode == 200) {
//                HttpEntity entity = response.getEntity();
//                InputStream content = entity.getContent();
//                BufferedReader reader_buffer = new BufferedReader
//                        (new InputStreamReader(content));
//
//                String line;
//                while ((line = reader_buffer.readLine()) != null) {
//                    str.append(line);
//                }
//            } else {
//                Log.e("Log", "Failed to download file..");
//            }
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return str.toString();
//    }
//
//    public static String getGET(String url) {
//        StringBuilder str = new StringBuilder();
//        HttpClient client = new DefaultHttpClient();
//        HttpGet httpGet = new HttpGet(url);
//        try {
//            HttpResponse response = client.execute(httpGet);
//            StatusLine statusLine = response.getStatusLine();
//            int statusCode = statusLine.getStatusCode();
//            if (statusCode == 200) { // Download OK
//                HttpEntity entity = response.getEntity();
//                InputStream content = entity.getContent();
//                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    str.append(line);
//                }
//            } else {
//                Log.e("Log", "Failed to download result..");
//            }
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return str.toString();
//    }
}
