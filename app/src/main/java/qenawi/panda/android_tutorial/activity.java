package qenawi.panda.android_tutorial;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.*;

public class activity extends AppCompatActivity implements OnMapReadyCallback {
    Marker start, end, animate;

    /**
     * sRC
     * https://www.oodlestechnologies.com/blogs/How-to-smoothly-move-and-rotate-a-marker-in-google-map
     *
     * @param
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps1);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng startpos = new LatLng(-35.016, 143.321);
        LatLng endpos = new LatLng(-32.491, 147.309);
        googleMap.setMinZoomPreference(4f);
        /*
custom map info window
         */
        CustomInfoWindowAdapter customInfoWindowAdapter=new CustomInfoWindowAdapter(this);
        googleMap.setInfoWindowAdapter(customInfoWindowAdapter);

        start = googleMap.addMarker(new MarkerOptions().position(startpos)
                .title("Start").snippet("LONG Text ASDASDASDasdasdasd")
        );
        animate = googleMap.addMarker(new MarkerOptions().position(startpos)
                .title("anmiation").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        end = googleMap.addMarker(new MarkerOptions().position(endpos)
                .title("end").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        Polyline polyline1 = googleMap.addPolyline((new PolylineOptions())
                .clickable(true)
                .add(new LatLng(-35.016, 143.321),
                        new LatLng(-34.747, 145.592),
                        new LatLng(-34.364, 147.891),
                        new LatLng(-33.501, 150.217),
                        new LatLng(-32.306, 149.248),
                        new LatLng(-32.491, 147.309)));


        googleMap.animateCamera(CameraUpdateFactory.newLatLng(startpos));
        moveVechile(animate, endpos);

    }

    public void moveVechile(final Marker myMarker, final LatLng finalPosition) {

        final LatLng startPosition = myMarker.getPosition();

        final Handler handler = new Handler();
        final long start = SystemClock.uptimeMillis();
        final Interpolator interpolator = new AccelerateDecelerateInterpolator();
        final float durationInMs = 8000;
        final boolean hideMarker = false;

        handler.post(new Runnable() {
            long elapsed;
            float t;
            float v;

            @Override
            public void run() {
                // Calculate progress using interpolator
                elapsed = SystemClock.uptimeMillis() - start;
                t = elapsed / durationInMs;
                v = interpolator.getInterpolation(t);

                LatLng currentPosition = new LatLng(
                        startPosition.latitude * (1 - t) + (finalPosition.latitude) * t,
                        startPosition.longitude * (1 - t) + (finalPosition.longitude) * t);
                myMarker.setPosition(currentPosition);
                // myMarker.setRotation(finalPosition.getBearing());


                // Repeat till progress is completeelse
                if (t < 1) {
                    // Post again 16ms later.
                    handler.postDelayed(this, 16);
                    // handler.postDelayed(this, 100);
                } else {
                    if (hideMarker) {
                        myMarker.setVisible(false);
                    } else {
                        myMarker.setVisible(true);
                    }
                }
            }
        });


    }

}
