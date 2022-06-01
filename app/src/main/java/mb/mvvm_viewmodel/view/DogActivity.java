package mb.mvvm_viewmodel.view;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import mb.mvvm_viewmodel.R;
import mb.mvvm_viewmodel.databinding.ActivityDogBinding;

import mb.mvvm_viewmodel.model.DogModel;
import mb.mvvm_viewmodel.viewmodel.DogViewModel;

public class DogActivity extends AppCompatActivity {
    //Atributos
    private ActivityDogBinding binding;         //Tela   Xml
    private DogViewModel       dogViewModel;    //Camada VM
    private List<DogModel>     listaDogs = new ArrayList<>();

    //Método Inicial
    @Override protected void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);
        //Tela, ViewModel, Contexto
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dog);
        dogViewModel = new ViewModelProvider(this).get(DogViewModel.class);
        dogViewModel.receberContexto(DogActivity.this);

        //////////////////////////////////////////////

        //Observers (Quando Alteração Já Seta)
        dogViewModel.listaDogs2_LD.observe(this, new Observer<List<DogModel>>() {
            @Override
            public void onChanged(List<DogModel> dogModels) {
                listaDogs.addAll(dogModels);
                Log.d("myLog Activity", listaDogs.toString());

            }
        });

        dogViewModel.dogModel_LD.observe(this, new Observer<DogModel>() {
        @Override public void onChanged(DogModel dogModelX) {
            Log.d("myLog Activity", dogModelX.toString());
        }});

        //////////////////////////////////////////////

        //Eventos
        binding.dogBtnBuscarXml.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View view) {
            dogViewModel.buscarTodosLD();
        }});

        binding.dogBtnEditarXml.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View view) {
            DogModel dogModel = new DogModel(5, "Xuxa", 17);
            dogViewModel.editarLD(dogModel);
        }});
    }
}

//Dúvidas
//* Passar Contexto é Via Factory, Mas Acho Mais Fácil Criar um Método soh para Isto;
//* No Emulador Não esta Perdendo Dados ao Virar, Mas no Celular Fisico Sim;

//Links
//https://www.youtube.com/watch?v=d7UxPYxgBoA
//https://www.youtube.com/watch?v=_T8ln2ig5hE
//https://www.youtube.com/watch?v=R1PnEB9Zu6s

//setvalue duplica o postvalue não!!!!!!!!!!!!

