package book.bookReview;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ListenMusicActivity extends AppCompatActivity {

    Button play,pause;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //Задаем внешний вид интерфейса
        setContentView(R.layout.watch_movie);
        //Добавляем размещение элементов

        final Intent intent = getIntent();
        //Получаем нужные данные
        final String name = intent.getStringExtra("name");
        String description = intent.getStringExtra("description");
        String author = intent.getStringExtra("author");
        String image = intent.getStringExtra("image");
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (actionBar != null) {
            actionBar.setTitle(name);
        }

        TextView nameTextView = (TextView) findViewById(R.id.nameTextView);
        TextView authorTextView = (TextView) findViewById(R.id.authorTextView);
        TextView descriptionTextView = (TextView) findViewById(R.id.descriptionTextView);
        ImageView imageView = (ImageView) findViewById(R.id.movieImage);

        nameTextView.setText(name);
        authorTextView.setText("Автор: " + author);
        descriptionTextView.setText(description);
        Picasso.get().load(image).into(imageView);

        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);

        final MediaPlayer rock = MediaPlayer.create(ListenMusicActivity.this, R.raw.rock);
        final MediaPlayer pop = MediaPlayer.create(ListenMusicActivity.this, R.raw.pop);
        final MediaPlayer rap = MediaPlayer.create(ListenMusicActivity.this, R.raw.rap);
        final MediaPlayer country = MediaPlayer.create(ListenMusicActivity.this, R.raw.country);
        final MediaPlayer retro = MediaPlayer.create(ListenMusicActivity.this, R.raw.retro);

        play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (name.equals("Rock")) {
                    rock.start();
                } else if (name.equals("Pop")) {
                    pop.start();
                } else if (name.equals("Rap")) {
                    rap.start();
                } else if (name.equals("Retro")) {
                    retro.start();
                } else if (name.equals("Country")) {
                    country.start();
                }



            }
        });


        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rock.isPlaying()){
                    rock.pause();
                } else if (pop.isPlaying()) {
                    pop.pause();
                } else if (rap.isPlaying()) {
                    rap.pause();
                } else if (country.isPlaying()) {
                    country.pause();
                } else if (retro.isPlaying()) {
                    retro.pause();
                }
            }
        });

    }

}
