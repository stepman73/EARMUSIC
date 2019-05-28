package book.bookReview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

//Класс для упрощения связывания данных с элементов управдения
class MusicAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<Music> musicArrayList;
    private LayoutInflater inflater;

    MusicAdapter(Activity activity, ArrayList<Music> musicArrayList) {
        this.activity = activity;
        this.musicArrayList = musicArrayList;
    }

    @Override
    public int getCount() {
        return this.musicArrayList.size();
    }

    @Override
    public Music getItem(int position) {
        return this.musicArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.movie_list_item, null);

        TextView name = (TextView) convertView.findViewById(R.id.nameTextView);
        TextView description = (TextView) convertView.findViewById(R.id.descriptionTextView);
        TextView author = (TextView) convertView.findViewById(R.id.authorTextView);
        ImageView image = (ImageView) convertView.findViewById(R.id.imageView);

        final Music music = getItem(position);
        name.setText(music.getName());
        if (music.getDescription().length() <= 150) {
            description.setText(music.getDescription());
        } else {
            description.setText(music.getDescription().substring(0, 150) + "...");
        }
        author.setText("Автор: " + music.getAuthor());


        Picasso.get().load(music.getImage()).into(image);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ListenMusicActivity.class);
                intent.putExtra("name", music.getName());
                intent.putExtra("description", music.getDescription());
                intent.putExtra("author", music.getAuthor());
                intent.putExtra("image", music.getImage());

                activity.startActivity(intent);
            }
        });

        return convertView;
    }
}
