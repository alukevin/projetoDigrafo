package digrafo;

import java.util.List;

public class Controller{
	private static Controller instance;
	public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }
	@SuppressWarnings("unchecked")
	public List<String> lerArq(){
		return Leitura.getInstance().lerArq();
    }
	public void setDigrafo(List<String> listaPalavras) {
		 Saida.setDigrafo(listaPalavras);
	}
	public static void Treemaptreat() {
		 Saida.Treemaptreat();
	}
	public static void order_graphi() {
		 Saida.order_graphi();
	}
	public static void Write_csv_File() {
		Saida.Write_csv_File();
	}
	
}