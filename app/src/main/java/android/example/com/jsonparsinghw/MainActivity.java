package android.example.com.jsonparsinghw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "JSON BIRDS EXAMPLE";
    private List<Bird> birdFamilyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String originalJsonString = "{\n" +
                "  \"description\": \"Birds of Antarctica, grouped by family\",\n" +
                "  \"source\": \"https://en.wikipedia.org/wiki/List_of_birds_of_Antarctica\",\n" +
                "  \"birds\": [\n" +
                "    {\n" +
                "      \"family\": \"Albatrosses\",\n" +
                "      \"members\": [\n" +
                "        \"Wandering albatross\",\n" +
                "        \"Grey-headed albatross\",\n" +
                "        \"Black-browed albatross\",\n" +
                "        \"Sooty albatross\",\n" +
                "        \"Light-mantled albatross\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"family\": \"Cormorants\",\n" +
                "      \"members\": [\n" +
                "        \"Antarctic shag\",\n" +
                "        \"Imperial shag\",\n" +
                "        \"Crozet shag\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"family\": \"Diving petrels\",\n" +
                "      \"members\": [\n" +
                "        \"South Georgia diving petrel\",\n" +
                "        \"Common diving petrel\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"family\": \"Ducks, geese and swans\",\n" +
                "      \"members\": [\n" +
                "        \"Yellow-billed pintail\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"family\": \"Gulls\",\n" +
                "      \"members\": [\n" +
                "        \"Kelp gull\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"family\": \"Penguins\",\n" +
                "      \"members\": [\n" +
                "        \"King penguin\",\n" +
                "        \"Emperor penguin\",\n" +
                "        \"Gentoo penguin\",\n" +
                "        \"Adelie penguin\",\n" +
                "        \"Chinstrap penguin\",\n" +
                "        \"Rockhopper penguin\",\n" +
                "        \"Macaroni penguin\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"family\": \"Shearwaters and petrels\",\n" +
                "      \"members\": [\n" +
                "        \"Antarctic giant petrel\",\n" +
                "        \"Hall's giant petrel\",\n" +
                "        \"Southern fulmar\",\n" +
                "        \"Antarctic petrel\",\n" +
                "        \"Cape petrel\",\n" +
                "        \"Snow petrel\",\n" +
                "        \"Great-winged petrel\",\n" +
                "        \"White-headed petrel\",\n" +
                "        \"Blue petrel\",\n" +
                "        \"Broad-billed prion\",\n" +
                "        \"Salvin's prion\",\n" +
                "        \"Antarctic prion\",\n" +
                "        \"Slender-billed prion\",\n" +
                "        \"Fairy prion\",\n" +
                "        \"Grey petrel\",\n" +
                "        \"White-chinned petrel\",\n" +
                "        \"Kerguelen petrel\",\n" +
                "        \"Sooty shearwater\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"family\": \"Sheathbills\",\n" +
                "      \"members\": [\n" +
                "        \"Snowy sheathbill\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"family\": \"Skuas and jaegers\",\n" +
                "      \"members\": [\n" +
                "        \"South polar skua\",\n" +
                "        \"Brown skua\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"family\": \"Storm petrels\",\n" +
                "      \"members\": [\n" +
                "        \"Grey-backed storm petrel\",\n" +
                "        \"Wilson's storm petrel\",\n" +
                "        \"Black-bellied storm petrel\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"family\": \"Terns\",\n" +
                "      \"members\": [\n" +
                "        \"Arctic tern\",\n" +
                "        \"Antarctic tern\"\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        try {
            JSONObject jsonBirdsString = new JSONObject(originalJsonString);
            JSONArray jsonBirdsArray = jsonBirdsString.getJSONArray("birds");
            birdFamilyList = new ArrayList<>();

            for (int i = 0; i < jsonBirdsArray.length(); i++) {
                Bird bird = new Bird();
                bird.setFamily((String) jsonBirdsArray.getJSONObject(i).get("family"));
                birdFamilyList.add(bird);

                Members member = new Members();
                member.getMembers(jsonBirdsArray.getJSONObject(i).getJSONArray("members"));
                bird.setMembers(member);
            }

            Log.d(TAG, "OnCreate: " + birdFamilyList.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new BirdAdapter(birdFamilyList));
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));

    }
}
