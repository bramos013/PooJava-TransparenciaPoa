import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
public class Menu {
    public void inicializa() throws Exception{
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
                        dados.carregaCsv(arquivo);                
                break;

                case 2:        
                    try {
                        if(dados.consultaFrota()!=null){
                            System.out.println(dados.consultaFrota()); //Opção para apresentar todos os onibus cadastrados                    
                        }else{
                            throw new DadosAbertosException(registro);                        
                        }
                    }catch(DadosAbertosException e){
                        e.getMessage();
                    }                                                        
                break;

                case 3:        
                    try {
                        if(dados.consultaFrota() != null){ 
                            //Opção para pesquisar a frota utilizando filtros
                            System.out.println("\t\t ----------------------"); 
                            System.out.println("\t\t| Pesquisar onibus:    |");
                            System.out.println("\t\t ----------------------"); 
                            System.out.println("\t\t| [1] Prefixo          |");
                            System.out.println("\t\t| [2] Empresa          |");
                            System.out.println("\t\t| [3] Marca            |");
                            System.out.println("\t\t| [4] Placa            |");
                            System.out.println("\t\t| [5] Ano Fabricação   |");                                         
                            subEscolha = scan.nextInt();
                            switch (subEscolha) {  
                                case 1:
                                    System.out.println("\t\tInforme o prefixo do Onibus:");                    
                                        int prefixo = scan.nextInt();
                                    registro = dados.consultaPrefixo(prefixo);
                                        System.out.println(registro);
                                break;
                                case 2:                        
                                    System.out.println("\t\tInforme a empresa operadora do Onibus:");                    
                                        scan.nextLine();
                                    String empresa = scan.nextLine();
                                        registro = dados.consultaEmpresa(empresa);                               
                                        System.out.println(registro);
                                break;                                
                                case 3:                      
                                    System.out.println("\t\tInforme a marca do Onibus:");                    
                                        scan.nextLine();
                                    String marca = scan.nextLine();
                                        registro = dados.consultaMarca(marca);                               
                                        System.out.println(registro);
                                break;
                                case 4:
                                    System.out.println("\t\tInforme a placa do Onibus:");                   
                                        scan.nextLine(); 
                                    String placa = scan.nextLine();
                                        registro = dados.consultaPlaca(placa);
                                        System.out.println(registro);
                                break;
                                case 5:
                                    System.out.println("\t\tInforme o ano de fabricação do Onibus:");                    
                                        int ano_fabricacao = scan.nextInt();
                                    registro = dados.consultaAno(ano_fabricacao);
                                            System.out.println(registro);
                                break;
                                default:
                                    System.out.println("\t\tOpção inválida!");
                                break;                   
                            }                             
                        }
                        else{
                            throw new DadosAbertosException(registro);                        
                        }
                    }
                    catch(DadosAbertosException e){
                        e.getMessage();
                    }                                                    
                break;

                case 4:
                    try {
                        if(registro != null){
                            System.out.println("\t\tNome do arquivo para salvar os dados da consulta");                        
                                scan.nextLine();
                            String arquivoRegistro =  scan.nextLine();                                      
                            FileWriter reg = new FileWriter(arquivoRegistro);//Cria um arquivo de registro
                            PrintWriter gravaRegistro = new PrintWriter(reg); //Realiza a gravação dos dados no arquivo
                            gravaRegistro.write("Dados salvos na ultima consulta: " + registro);//Grava em Buffer os dados
                            reg.flush(); //Grava os dados no disco,
                            reg.close(); //Encerra a gravação de dados                    
                        }
                        else{
                            throw new DadosAbertosException();                        
                        }
                    }
                    catch(DadosAbertosException e){
                        e.getMessage();
                    }                                                
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