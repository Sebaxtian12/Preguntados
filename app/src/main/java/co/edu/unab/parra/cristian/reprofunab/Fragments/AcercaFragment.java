package co.edu.unab.parra.cristian.reprofunab.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import co.edu.unab.parra.cristian.reprofunab.Model.AcercaModel;
import co.edu.unab.parra.cristian.reprofunab.R;

public class AcercaFragment extends Fragment {

    private AcercaModel mViewModel;

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