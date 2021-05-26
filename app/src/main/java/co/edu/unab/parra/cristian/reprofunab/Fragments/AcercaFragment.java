package co.edu.unab.parra.cristian.reprofunab.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import co.edu.unab.parra.cristian.reprofunab.Model.AcercaModel;
import co.edu.unab.parra.cristian.reprofunab.R;

public class AcercaFragment extends Fragment {

    private AcercaModel mViewModel;

    private Button _btn_link;
    String _url = "https://docs.google.com/forms/d/e/1FAIpQLSd3fou92K3rLtBTDfZ8rzy5F6mo2kVVk2rJ1-kK_X2XDiwLCw/viewform?usp=sf_link";


    public static AcercaFragment newInstance() {
        return new AcercaFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_acerca, container, false);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AcercaModel.class);
        // TODO: Use the ViewModel


    }


}