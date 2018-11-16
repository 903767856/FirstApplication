package com.example.a90376.firstapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class LoginActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button loginbutton=(Button)findViewById(R.id.button);
        Button register=(Button)findViewById(R.id.button2);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyApiEndpointInterface apiService=retrofit.create(MyApiEndpointInterface.class);
                String username="sarahjean";
                Call<User> call=apiService.getUser(username);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        int statusCode=response.code();
                        User user=response.body();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.content.Intent re=new android.content.Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(re);
            }
        });
    }
    public static final String Base_URL="http://api.myservice.com/" ;
    Retrofit retrofit=new Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();



    public interface MyApiEndpointInterface{//Request method and URL specified in the annotation
        @GET("userId/{userId}")
        Call<User> getUser(@Path("userId") String userId);
//        @GET("group/")
        @POST("/user/new")
        Call<User>createUser(@Body User user);

    }
}



