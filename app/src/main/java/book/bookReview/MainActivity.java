package book.bookReview;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<Music> musicArrayList;
    MusicAdapter adapter;

//    Создаем новый объект и вносим в него данные для приложения
    Music[] music = new Music[] {
        new Music("Rap",
                "американский рэпер, музыкальный продюсер, композитор и актёр. Помимо сольной карьеры, Маршалл также состоит в группе D12 и хип-хоп-дуэте Bad Meets Evil." +
                        " Эминем является одним из самых продаваемых музыкальных артистов в мире, а также самым продаваемым артистом 2000-х. Он назван одним из самых великих музыкантов всех времён многими журналами, включая Rolling Stone, который разместил Эминема под 83-м номером в списке 100 самых великих артистов." +
                        "Этот же журнал провозгласил его Королём хип-хопа. Если считать и студийные работы его групп, то у Эминема имеется 12 альбомов, которые достигали первой строчки в Billboard 200. " +
                        "Как сольный артист Эминем продал более 100 миллионов альбомов по всему миру и более 107 миллионов своих записей и 44 миллиона копий своих альбомов только в Америке.",
                "Eminem",
                "https://www.thoughtco.com/thmb/G20AvIG_RUNyDYe4LMLFWLpzrgw=/1417x1417/filters:no_upscale():max_bytes(150000):strip_icc()/the_marshall_mathers_lp_is-56a7d8173df78cf77299db4d.jpg"),
        new Music("Pop",
                "Рианна является одной из самых продаваемых артистов всех времён вследствие продажи более 20 миллионов копий альбомов и 60 миллионов синглов." +
                        " Она самая молодая певица в истории Billboard, которой удалось четырнадцать раз возглавить чарт Billboard Hot 100. " +
                        "По состоянию на март 2010 года Рианна продала 7,3 миллиона альбомов и более 33,7 миллиона синглов только на территории Соединённых Штатов Америки. " +
                        "По состоянию на июль 2015 года продано более 100 миллионов копий синглов певицы, таким образом, Рианна стала первым артистом в истории, достигшим такого показателя. " +
                        "Журнал Billboard назвал Рианну «Артистом цифровой эры 2000-х годов» и присудил общее 17 место среди артистов 2000-х.Певица получила множество наград, включая международную музыкальную премию World Music Awards 2007 года в номинациях Самая продаваемая певица в жанре поп-музыка и Артистка года, а также на церемонии BRIT Awards в категории Лучшая международная исполнительница.",
                "Rihanna",
                "https://i.ytimg.com/vi/vBt3-9ZZy4w/maxresdefault.jpg"),
        new Music("Rock",
                "Британская рок-группа,добившаяся широчайшей известности в середине 1970-х годов, и одна из наиболее успешных групп в истории рок-музыки." +
                        " Средства массовой информации называют группу «культовой» и пишут, что она и по сей день имеет сотни миллионов поклонников. Критики считают классикой рока такие песни группы как: «Bohemian Rhapsody», «We Will Rock You», «We Are the Champions», «Innuendo», «The Show Must Go On», «Radio Ga Ga», «I Want to Break Free», «A Kind of Magic»." +
                        " Группа выпустила пятнадцать студийных альбомов, пять концертных и многочисленные сборники. Восемнадцать хитов «Queen» занимали первые места в чартах разных стран. Каждый участник группы является автором как минимум одного хита" +
                        ", достигавшего вершины британского чарта. Концертные выступления группы также были признаны одними из самых ярких и значимых за всю историю рока.",
                "Queen",
                "https://media.pitchfork.com/photos/5bcdf9b8a8f1ec1406cb9892/1:1/w_320/Queen_Bohemian%20Rhapsody%20OST.jpg"),
        new Music("Retro",
                "Шведский музыкальный квартет, существовавший в 1972—1982 годах и названный по первым буквам имён исполнителей:" +
                        " Агнета Фельтског, Бьорн Ульвеус, Бенни Андерссон, Анни-Фрид Лингстад. Является одним из наиболее успешных коллективов за всю историю популярной музыки и самым успешным из числа созданных в Скандинавии: записи группы по всему миру были проданы тиражом более 350 миллионов экземпляров." +
                        "Синглы квартета занимали первые места в чартах с середины 1970-х («Waterloo») до начала 1980-х («One of Us»), а сборники возглавляли мировые хит-парады и в 2000-х. Музыка группы остаётся в плей-листах радиостанций, и их альбомы продолжают продаваться по сей день." +
                        "Они были первыми представителями континентальной Европы, завоевавшими первые места в чартах всех ведущих англоговорящих стран (США, Великобритания, Канада, Ирландия, Австралия и Новая Зеландия). За выдающиеся заслуги в музыке 15 марта 2010 года группа ABBA была включена в Зал славы рок-н-ролла[6][7].",
                "ABBA",
                "https://upload.wikimedia.org/wikipedia/en/thumb/6/6b/Abbadefinitivecollection.jpg/220px-Abbadefinitivecollection.jpg"),
        new Music("Country",
                " Американский бард, который является самым коммерчески успешным сольным исполнителем в истории фолк-музыки. За свою карьеру он записал более 300 песен, большинство из которых сам же и написал." +
                        "В конце 1960-х годов Денвер выступал в составе трио Чэда Митчелла, однако с 1969 года посвятил себя сольной карьере. Его песни отличали чувство родства с природой и внимание к экологическим проблемам. " +
                        "Вышедший в 1974 году альбом величайших хитов десять раз становился платиновым, а написанная для жены песня «Annie’s Song» дошла до первого места в Billboard Hot 100.",
                "John Denver",
                "https://images-na.ssl-images-amazon.com/images/I/51dQbTenhmL.jpg"),
    };

    //Связываем данные
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setIcon(R.drawable.ic_action_logo);
            actionBar.setTitle("    " + actionBar.getTitle());
        }

        musicArrayList = new ArrayList<>(Arrays.asList(music));
        adapter = new MusicAdapter(this, musicArrayList);

        ListView movieListView = (ListView) findViewById(R.id.movieListView);
        movieListView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
//        SearchView searchView = searchItem.getActionView() as SearchView;
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("Поиск", newText);

                musicArrayList.clear();

                if (newText.equals("")) {
                    musicArrayList.addAll(Arrays.asList(music));
                } else {
                    for (Music music : MainActivity.this.music) {
                        if (music.getName().toLowerCase().contains(newText.toLowerCase())) {
                            musicArrayList.add(music);
                        }
                    }
                }

                adapter.notifyDataSetChanged();

                return false;
            }
        });
            return super.onCreateOptionsMenu(menu);
    }

}
