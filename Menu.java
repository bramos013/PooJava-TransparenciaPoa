import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {
    public void inicializa() throws IOException{
        CarregaDados dados = new CarregaDados();       
        int escolha = 0;
        int subEscolha = 0;
        boolean continua = true;
        Scanner scan = new Scanner(System.in);
        String registro = null; 
        do{        
            System.out.println("\t\t ---------------------------------"); 
            System.out.println("\t\t| [1] Carregar os Dados          |");
            System.out.println("\t\t| [2] Apresentar os Dados        |");
            System.out.println("\t\t| [3] Consultar um Dado          |");
            System.out.println("\t\t| [4] Salvar os Dados da Consulta|");
            System.out.println("\t\t| [0] Sair                       |");                    
            System.out.println("\t\t ---------------------------------"); 
            
            escolha = scan.nextInt();        
            switch(escolha){            
                case 1:    
                    System.out.println("\t\tInforme o arquivo a ser carregado");                        
                                scan.nextLine();
                        String arquivo =  scan.nextLine();
                        System.out.println("\t\tCarregando Dados do Arquivo: " + arquivo +"\n");                                                                                                 
                        dados.carregaCsv(arquivo);                                                
                break;
                case 2:                              
                    System.out.println(dados.consultaFrota()); //Opção para apresentar todos os onibus cadastrados
                break;
                case 3:
                    //Opção para pesquisar a frota utilizando filtros
                    System.out.println("\t\t| Pesquisar onibus:    |");
                    System.out.println("\t\t| [1] Prefixo          |");
                    System.out.println("\t\t| [2] Empresa          |");
                    System.out.println("\t\t| [3] Marca            |");
                    System.out.println("\t\t| [4] Placa            |");
                    System.out.println("\t\t| [5] Ano Fabricação   |"); 
                    
                    subEscolha = scan.nextInt();
                    switch (subEscolha) {  
                        case 1:
                            System.out.println("Informe o prefixo do Onibus:");                    
                            int prefixo = scan.nextInt();
                                registro = dados.consultaPrefixo(prefixo);
                                System.out.println(registro);
                        break;
                        case 2:                        
                            System.out.println("Informe a empresa operadora do Onibus:");                    
                                scan.nextLine();
                            String empresa = scan.nextLine();
                                registro = dados.consultaEmpresa(empresa);                               
                                System.out.println(registro);
                        break;
                        case 3:                      
                            System.out.println("Informe a marca do Onibus:");                    
                                scan.nextLine();
                            String marca = scan.nextLine();
                                registro = dados.consultaMarca(marca);                               
                                System.out.println(marca);
                        break;
                        case 4:
                            System.out.println("Informe a placa do Onibus:");                    
                                String placa = scan.next();
                                    registro = dados.consultaPlaca(placa);
                        break;
                        case 5:
                            System.out.println("Informe o ano de fabricação do Onibus:");                    
                                int ano_fabricacao = scan.nextInt();
                                   registro = dados.consultaAno(ano_fabricacao);
                                   System.out.println(registro);
                        break;
                        default:
                            System.out.println("Opção inválida!");
                        break;                   
                    }
                break;
                case 4:        
                    System.out.println("\t\tNome do arquivo para salvar os dados da consulta");                        
                        scan.nextLine();
                    String registro2 =  scan.nextLine();                                      
                    FileWriter reg = new FileWriter(registro2);//Cria um arquivo de registro
                    PrintWriter gravaRegistro = new PrintWriter(reg); //Realiza a gravação dos dados no arquivo
                    gravaRegistro.write("Dados salvos na ultima consulta: " + registro);//Grava em Buffer os dados
                        reg.flush(); //Grava os dados no disco,
                        reg.close(); //Encerra a gravação de dados
                                        
                break;
                case 0:
                    System.out.println("Encerrando...");       
                    continua = false;
                    scan.close();
                break;
                default:
                    System.out.println("Opção inválida!");
                break;
            } 
        }while(continua !=false);
    }
}
