package mb.mvvm_viewmodel.repository;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import mb.mvvm_viewmodel.model.DogModel;

public class DogRepository {
    //Atributos - Normais
    private Context        context;
    private List<DogModel> listaDogs = new ArrayList<>();

    //Atributos - LiveData
    public MutableLiveData<DogModel>       dog_LD       = new MutableLiveData<>();
    public MutableLiveData<List<DogModel>> listaDogs_LD = new MutableLiveData<>();

    //Construtor
    public DogRepository(Context contextVindo) {
        context = contextVindo;
    }

    //Método - Buscar Todos
    public MutableLiveData<List<DogModel>> buscarTodosLD(){
        new AsyncTask<Void, Void, List<DogModel>>(){
            @Override protected List<DogModel> doInBackground(Void... voids) {
                listaDogs.add(new DogModel(1, "Xuxa", 17));
                listaDogs.add(new DogModel(2, "Simba", 13));
                return listaDogs;
            }

            @Override protected void onPostExecute(List<DogModel> dogModels) {
                super.onPostExecute(dogModels);
                listaDogs_LD.postValue(dogModels);
            }
        }.execute();
        return listaDogs_LD;
    }

    //Método - Editar
    public MutableLiveData<DogModel> editarLD(DogModel dogModelVindo){
        new AsyncTask<DogModel,Void, DogModel>(){
            @Override protected DogModel doInBackground(DogModel... dogModels) {
                DogModel dogModel = new DogModel(dogModels[0].getId(), "Belinha", 16);
                return dogModel;
            }
            @Override protected void onPostExecute(DogModel dogModelX) {
                super.onPostExecute(dogModelX);
                dog_LD.postValue(dogModelX);
            }
        }.execute(dogModelVindo);
        return dog_LD;
    }
}

