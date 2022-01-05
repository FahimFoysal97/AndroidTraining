package com.example.androidtraining;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidtraining.databinding.ActivitySecondBinding;

import java.io.InputStream;

public class SecondActivity extends AppCompatActivity {
    private ActivitySecondBinding binding;
    private AsyncTaskRunner runner;
    private Downloader downloader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initUI();
    }

    void initUI() {
        runner = new AsyncTaskRunner();
        downloader = new Downloader();
        binding.buttonGoToThirdActivity.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), ThirdActivity.class)));
        binding.buttonDownload.setOnClickListener(v -> {
            //runner.execute("5");
            downloader.execute("https://wallpapercave.com/wp/wp4325401.jpg");
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (runner != null)
            if (!runner.isCancelled())
                runner.cancel(false);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private class AsyncTaskRunner extends AsyncTask<String, String, String> {
        private String resp;

        @Override
        protected String doInBackground(String... params) {
            publishProgress("Sleeping..."); // Calls onProgressUpdate()
            try {
                int time = Integer.parseInt(params[0]) * 1000;

                Thread.sleep(time);
                resp = "Slept for " + params[0] + " seconds";
            } catch (Exception e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            return resp;
        }

        @Override
        protected void onPostExecute(String result) {
            // execution of result of Long time consuming operation
            binding.progressHorizontal.setVisibility(View.GONE);
            binding.textView2.setText(result);
        }


        @Override
        protected void onPreExecute() {
            binding.progressHorizontal.setVisibility(View.VISIBLE);
        }


        @Override
        protected void onProgressUpdate(String... text) {
            binding.textView2.setText(text[0]);
        }
    }

    private class Downloader extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... strings) {
            String imageURL = strings[0];

            Bitmap bitmap = null;
            try {
                // Download Image from URL
                InputStream input = new java.net.URL(imageURL).openStream();
                // Decode Bitmap
                bitmap = BitmapFactory.decodeStream(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            binding.progressHorizontal.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            binding.progressHorizontal.setVisibility(View.GONE);
            binding.imageViewDownloadedImage.setImageBitmap(bitmap);
        }
    }
}