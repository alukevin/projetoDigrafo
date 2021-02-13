package digrafo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluke
 */
public class Leitura {
	private static Leitura instance;
	public static Leitura getInstance() {
        if (instance == null) {
            instance = new Leitura();
        }
        return instance;
    }
    public static String ConsertaString(String str) {
        String resultado = remover(str.toLowerCase());
        return resultado;  
    }
    
    static String acentuado = "çÇáéíóúıÁÉÍÓÚİàèìòùÀÈÌÒÙãõñäëïöüÿÄËÏÖÜÃÕÑâêîôûÂÊÎÔÛ";
    static String semAcento = "cCaeiouyAEIOUYaeiouAEIOUaonaeiouyAEIOUAONaeiouAEIOU";
    static char[] tabela;
   
   
    @SuppressWarnings("rawtypes")
	public List lerArq() {
    	 String linha = new String(); //Variavel que vai armazenar cada linha do documento
         String nomeArquivo = "texto1 (2).txt"; //nome e endereço do arquivo no PC
         List<String> listaPalavras = new ArrayList<String>(); //lista das palavras 
         File arq = new File(nomeArquivo); //le o arquivo do endereço
         if(arq.exists()){ // se o arquivo existir
             try{
                 new FileReader(nomeArquivo);
                 BufferedReader bufferDeArquivo = new BufferedReader(new InputStreamReader(
                 new FileInputStream(nomeArquivo), "UTF-8")); //armazena a linha lida no leitor em um buffer com caracter utf-8
    
                 while(true){
                   
                     linha=ConsertaString( bufferDeArquivo.readLine()); // conserta cada linha do documento
                     
                     if(linha==null){
                         break;
                     }
                     int var = linha.split(" ",-1).length - 1; //separa cada palavra por espaço
                     String var2[]=new String[var]; //cria a lista de palavras separadas
                     var2=linha.split(" "); //recebe as palavras separadas
                     for(int i = 0; i <= var; i++){
                         listaPalavras.add(var2[i]);
                               //adiciona as palavras a lista 'listaPalavra'
                     }
                    
                     
                 }
                
             }catch(Exception e){
                 System.out.println("");
             }
         }
             return listaPalavras;
    }
        
   /*public static void main(String[] args) {
        String linha = new String(); //Variavel que vai armazenar cada linha do documento
        String nomeArquivo = "C:\\Users\\maquina1\\Documents\\Wallace\\unicamp\\aulas\\POO2\\texto1.txt"; //nome e endereço do arquivo no PC
        List<String> listaPalavras = new ArrayList<String>(); //lista das palavras       
        File arq = new File(nomeArquivo); //le o arquivo do endereço
        if(arq.exists()){ // se o arquivo existir
            try{
                new FileReader(nomeArquivo);
                BufferedReader bufferDeArquivo = new BufferedReader(new InputStreamReader(
		  new FileInputStream(nomeArquivo), "UTF-8")); //armazena a linha lida no leitor em um buffer com caracter utf-8
   
                while(true){
                  
                    linha=ConsertaString( bufferDeArquivo.readLine()); // conserta cada linha do documento
                    
                    if(linha==null){
                        break;
                    }
                    int var = linha.split(" ",-1).length - 1; //separa cada palavra por espaço
                    String var2[]=new String[var]; //cria a lista de palavras separadas
                    var2=linha.split(" "); //recebe as palavras separadas
                    for(int i = 0; i <= var; i++){
                        listaPalavras.add(var2[i]);
                              //adiciona as palavras a lista 'listaPalavra'
                    }
                   
                    
                }
               
            }catch(Exception e){
                System.out.println("");
            }
             System.out.println(listaPalavras);

             
        }
        saida.setDigrafo(listaPalavras);
        saida.Treemaptreat();	
        saida.order_graphi();
        saida.Write_csv_File();
    }*/
    
   

     public static String remover (final String s) {
     
         
        
        tabela = new char[256]; //tabela de letras ascii
        for (int i = 0; i < tabela.length; ++i) {
	    tabela [i] = (char) i;
        }
        for (int i = 0; i < acentuado.length(); ++i) {
            tabela [acentuado.charAt(i)] = semAcento.charAt(i);
        }
    
        StringBuffer sb = new StringBuffer();
        
        //troca o acento
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt (i);
            if (ch < 256) { 
                sb.append (tabela [ch]);
            } else {
                sb.append (ch);
            }
        }
        return sb.toString().replaceAll("[^ A-Za-z0-9]","");
     }
}