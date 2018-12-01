package qenawi.panda.android_tutorial;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter
{
    private Context context;
    public CustomInfoWindowAdapter(Context context){this.context=context;}

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker)
    {
        View view = ((AppCompatActivity)context).getLayoutInflater()
                .inflate(R.layout.custom_window_layout, null);

        TextView name_tv = view.findViewById(R.id.main_title);
        TextView details_tv = view.findViewById(R.id.description);
        name_tv.setText(marker.getTitle());
        details_tv.setText(marker.getSnippet());

      //  InfoWindowData infoWindowData = (InfoWindowData) marker.getTag();


        return view;
    }
}
