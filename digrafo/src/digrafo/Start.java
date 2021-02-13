package digrafo;

import java.util.List;

public class Start {
	public static void main(String[] args) {
		List<String> listapalavras = Controller.getInstance().lerArq();
		Controller.getInstance().setDigrafo(listapalavras);
		Controller.Treemaptreat();
		Controller.order_graphi();
		Controller.Write_csv_File();
		System.out.println("Final");
	}
}