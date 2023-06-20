package illia.popov.lab5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;


public class HomeFragment extends Fragment {


    AutoCompleteTextView autocomplete;
    Button button;
    private String[] emailArray;


    public HomeFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        autocomplete = view.findViewById(R.id.email_auto_complete_text_view);
        button = view.findViewById(R.id.submit_button);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.emails));


        autocomplete.setThreshold(2);
        autocomplete.setAdapter(adapter);
        Bundle bundle = new Bundle();

        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String email = autocomplete.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    autocomplete.setError(getResources().getString(R.string.empty));
                    String s = getResources().getString(R.string.n_data);
                    bundle.putString("email", s);
                    getParentFragmentManager().setFragmentResult("requestEmail", bundle);

                } else if (!isValidEmail(email)) {
                    autocomplete.setError(getResources().getString(R.string.invalid));
                } else {
                    autocomplete.setText("");
                    bundle.putString("email", email);
                    getParentFragmentManager().setFragmentResult("requestEmail", bundle);

                }

            }
        });


        return view;
    }


    private boolean isValidEmail(CharSequence email){
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}