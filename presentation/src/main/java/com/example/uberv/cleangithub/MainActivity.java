package com.example.uberv.cleangithub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.data.converters.DataModelConverter;
import com.example.data.models.Repo;
import com.example.data.net.GitHubApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GitHubApiService service = retrofit.create(GitHubApiService.class);
        final Call<List<Repo>> repos = service.getUserRepos("Rikharthu");
        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                Timber.d("success");
                List<Repo> repos = response.body();
                List<com.example.domain.model.Repo> domainRepos = new ArrayList<>(repos.size());
                for (Repo repo : repos) {
                    domainRepos.add(DataModelConverter.convertRepoToDomainModel(repo));
                }
                int a=4;
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Timber.e("fail");
            }
        });
    }
}
