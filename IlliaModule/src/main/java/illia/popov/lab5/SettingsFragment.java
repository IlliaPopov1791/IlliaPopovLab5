package illia.popov.lab5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;


public class SettingsFragment extends Fragment {

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        TextView pass = view.findViewById(R.id.email_text_view);
        Switch swi = view.findViewById(R.id.switch_button);
        //coordinatorlayout.findViewById(R.id.settingsLayout);

        getParentFragmentManager().setFragmentResultListener("requestEmail", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                pass.setText(result.getString("email"));
            }
        });

        swi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    Snackbar snackbar = Snackbar.make(view, getResources().getString(R.string.on), Snackbar.LENGTH_INDEFINITE);
                    snackbar.setAction(getResources().getString(R.string.close), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });
                    snackbar.show();
                } else {
                    Snackbar snackbar = Snackbar.make(view, getResources().getString(R.string.off), Snackbar.LENGTH_INDEFINITE);
                    snackbar.setAction(getResources().getString(R.string.close), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });
                    snackbar.show();
                }
            }
        });
        return view;
    }
}