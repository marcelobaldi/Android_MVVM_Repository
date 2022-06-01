package mb.mvvm_viewmodel.model;
import java.io.Serializable;

public class DogModel implements Serializable {
    //Atributos
    private Integer id;
    private String  nome;
    private Integer idade;

    //Construtor
    public DogModel() {}
    public DogModel(String nome, Integer idade){this.nome = nome; this.idade = idade;}
    public DogModel(Integer id, String nome, Integer idade){this.id=id;this.nome=nome;this.idade=idade;}

    //GetterSetter
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public Integer getIdade() {return idade;}
    public void setIdade(Integer idade) {this.idade = idade;}

    //ToString
    @Override public String toString() {return "DogModel{"+"id="+id+",nome='"+nome+'\''+",idade="+idade+'}';}
}

