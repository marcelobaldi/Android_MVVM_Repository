package mb.mvvm_viewmodel.viewmodel;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import mb.mvvm_viewmodel.model.DogModel;
import mb.mvvm_viewmodel.repository.DogRepository;

public class DogViewModel extends ViewModel {
    //Atributos - Normais
    private Context       context;
    private DogRepository dogRepository;
    private List<DogModel> listaDogs = new ArrayList<>();

    //Atributos - LiveData
    public MutableLiveData<DogModel>       dogModel_LD  = new MutableLiveData<>();
    public MutableLiveData<List<DogModel>> listaDogs_LD = new MutableLiveData<>();
    public MutableLiveData<List<DogModel>> listaDogs2_LD = new MutableLiveData<>();

    //Construtor
    public void receberContexto(Context contextVindo){
        context = contextVindo;                             //Receber
        dogRepository = new DogRepository(context);         //Repassar
    }

    //=================================

    public void buscarTodosLD(){
        dogRepository.buscarTodosLD().observe((LifecycleOwner) context, new Observer<List<DogModel>>() {
            @Override public void onChanged(List<DogModel> dogModels) {
                listaDogs_LD.postValue(dogModels);
                listaDogs.addAll(dogModels);
            }});
            listaDogs2_LD.postValue(listaDogs);
    }

    public void editarLD(DogModel dogModelVindo){
        dogRepository.editarLD(dogModelVindo).observe((LifecycleOwner) context, new Observer<DogModel>() {
        @Override public void onChanged(DogModel dogModelX) {
            dogModel_LD.postValue(dogModelX);
        }});
    }

}


