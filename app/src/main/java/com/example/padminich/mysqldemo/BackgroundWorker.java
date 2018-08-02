package com.example.padminich.mysqldemo;

import android.app.AlertDialog;
import android.content.Context;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import android.os.AsyncTask;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by P admini  ch on 16-04-2017.
 */

public class BackgroundWorker extends AsyncTask<String,Void,String>
{
    Context context;

    AlertDialog alertdialog;

    BackgroundWorker(Context ctx)
    {
        context=ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String login_url = "http://192.168.0.101/login.php";
        String reg_url = "http://192.168.0.101/reg.php";
        String sub_url = "http://192.168.0.101/sub.php";
        String exit_url="http://192.168.0.101/exit.php";
        if (type.equals("login")) {
            try {
                String email = params[1];
                String password = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLconnection = (HttpURLConnection) url.openConnection();
                httpURLconnection.setRequestMethod("POST");
                httpURLconnection.setDoOutput(true);
                httpURLconnection.setDoInput(true);
                OutputStream outputstream = httpURLconnection.getOutputStream();
                BufferedWriter bufferedwriter = new BufferedWriter(new OutputStreamWriter(outputstream, "UTF-8"));
                String post_data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&"
                        + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                bufferedwriter.write(post_data);
                bufferedwriter.flush();
                bufferedwriter.close();
                outputstream.close();
                InputStream inputstream = httpURLconnection.getInputStream();
                BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedreader.readLine()) != null) {
                    result += line;
                }
                bufferedreader.close();
                inputstream.close();
                httpURLconnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
else if(type.equals("register")) {
            try {
                String name=params[1];
                String email=params[2];
                String password=params[3];
                URL url=new URL(reg_url);
                HttpURLConnection httpURLconnection=(HttpURLConnection)url.openConnection();
                httpURLconnection.setRequestMethod("POST");
                httpURLconnection.setDoOutput(true);
                httpURLconnection.setDoInput(true);
                OutputStream outputstream=httpURLconnection.getOutputStream();
                BufferedWriter bufferedwriter= new BufferedWriter(new OutputStreamWriter(outputstream,"UTF-8"));
                String post_data=URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedwriter.write(post_data);
                bufferedwriter.flush();
                bufferedwriter.close();
                outputstream.close();
                InputStream inputstream = httpURLconnection.getInputStream();
                BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedreader.readLine()) != null) {
                    result += line;
                }
                bufferedreader.close();
                inputstream.close();
                httpURLconnection.disconnect();
                return result;
            }
            catch(MalformedURLException e) {
                e.printStackTrace();

            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
        else if (type.equals("sub")) {
            try {
                String age=params[1];
                String weight=params[2];
                URL url=new URL(sub_url);
                HttpURLConnection httpURLconnection=(HttpURLConnection)url.openConnection();
                httpURLconnection.setRequestMethod("POST");
                httpURLconnection.setDoOutput(true);
                httpURLconnection.setDoInput(true);
                OutputStream outputstream=httpURLconnection.getOutputStream();
                BufferedWriter bufferedwriter= new BufferedWriter(new OutputStreamWriter(outputstream,"UTF-8"));
                String post_data=URLEncoder.encode("age","UTF-8")+"="+URLEncoder.encode(age,"UTF-8")+"&"+URLEncoder.encode("weight","UTF-8")+"="+URLEncoder.encode(weight,"UTF-8");
                bufferedwriter.write(post_data);
                bufferedwriter.flush();
                bufferedwriter.close();
                outputstream.close();
                InputStream inputstream = httpURLconnection.getInputStream();
                BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedreader.readLine()) != null) {
                    result += line;
                }
                bufferedreader.close();
                inputstream.close();
                httpURLconnection.disconnect();
                return result;
            }
            catch(MalformedURLException e) {
                e.printStackTrace();

            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }

        else if(type.equals("logout"))
        {
            try {
                URL url=new URL(exit_url);
                HttpURLConnection httpURLconnection=(HttpURLConnection)url.openConnection();
                httpURLconnection.setRequestMethod("POST");
                httpURLconnection.setDoOutput(true);
                httpURLconnection.setDoInput(true);
                OutputStream outputstream=httpURLconnection.getOutputStream();
                BufferedWriter bufferedwriter= new BufferedWriter(new OutputStreamWriter(outputstream,"UTF-8"));

                bufferedwriter.flush();
                bufferedwriter.close();
                outputstream.close();
                InputStream inputstream = httpURLconnection.getInputStream();
                BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedreader.readLine()) != null) {
                    result += line;
                }
                bufferedreader.close();
                inputstream.close();
                httpURLconnection.disconnect();
                return result;
            }
            catch(MalformedURLException e) {
                e.printStackTrace();

            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
        return null;
          }

    @Override
    protected void onPreExecute() {
        alertdialog=new AlertDialog.Builder(context).create();
            alertdialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {
            alertdialog.setMessage(result);
            alertdialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {

        super.onProgressUpdate(values);
    }
}
