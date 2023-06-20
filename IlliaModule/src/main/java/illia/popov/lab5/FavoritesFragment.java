package illia.popov.lab5;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;
import android.widget.Toast;


public class FavoritesFragment extends Fragment {


    public FavoritesFragment() {

    }
    private int counter = 0;

    @Override
    public void onPause() {
        super.onPause();
        counter++;
        String message = "Counter: " + counter + "\nIllia Popov";
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
    private TextClock clockTC;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize your views and set up the text clock
        clockTC = view.findViewById(R.id.idTCClock);
        clockTC.setFormat12Hour("hh:mm:ss a");
    }





}