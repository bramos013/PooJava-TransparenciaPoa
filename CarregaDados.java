import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class CarregaDados{
    private List<Onibus> frota = new ArrayList<>();    
        //Metodo para extrair os dados do arquivo CSV e inserir os registros como Objetos no ArrayList
    public void carregaCsv(String arquivo){                   
        //Realiza a leitura do arquivo mantendo os caracteres armazenados em Buffer          
        try(BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            System.out.println("\n\n\t\tCarregando Dados do Arquivo: " + arquivo);
            String linha = br.readLine();
            linha = br.readLine();    
            
            while(linha != null){                
                String[] linhas = linha.split(";"); //Separa os registros a partir do regex ";"
                int prefixo = Integer.parseInt(linhas[1]);//Armazena as informações de cada coluna conforme o header do CSV
                String empresa = linhas[2];
                String placa = linhas[3];
                String marca = linhas[4];
                int ano_fabricacao = Integer.parseInt(linhas[7]);
                
                //Cria o objeto e armazena no ArrayList
                Onibus onibus = new Onibus(prefixo, empresa, placa, marca, ano_fabricacao);
                frota.add(onibus);
                
                linha = br.readLine();                   
            }                    
        }
            //Exception caso o arquivo não existir
            catch(IOException e){
                System.out.println("\t\t"+e.getMessage());
            }              
    }
    
        //Metodo de consulta da Frota Cadastrada
    public  String consultaFrota(){                
        String res = "";        
        try {
            if(frota.size() == 0){
                res = null;               
            }
            for(int i=0 ; i < frota.size(); i++)
                res += "\n" + frota.get(i).toString();               
        }
            catch (NullPointerException e) {
                System.err.print(e.getMessage());
            }
        return res;
    }

        //Metodos de consulta utilizando Prefixo
    public  String consultaPrefixo(int prefixo){        
        String res = "";
            for (Onibus onibus : frota) {
                if(onibus.getPrefixo() == prefixo)
                    res += "\n" + onibus.toString();                
            }
        return res;
    }

        //Metodo de consulta utilizando  Empresa
    public  String consultaEmpresa(String empresa){
        String res = "";
            for (Onibus onibus : frota) {
                if(onibus.getEmpresa().equals(empresa))
                    res += "\n" + onibus.toString();                
            }            
        return res;
    }    

        //Metodo de consulta utilizando Marca
    public  String consultaMarca(String marca){
        String res = "";
            for (Onibus onibus : frota) {
                if(onibus.getMarca().equals(marca))
                    res += "\n" + onibus.toString();
            }
        return res;
    }        

        //Metodo de consulta utilizando Placa
    public  String consultaPlaca(String placa){
        String res = "";
            for (Onibus onibus : frota) {
                if(onibus.getPlaca().equals(placa))
                    res += "\n" + onibus.toString();
            }
        return res;
    }        

        //Metodo de consulta utilizando Ano de Fabricação
    public  String consultaAno(int ano_fabricacao){        
        String res = "";
            for (Onibus onibus : frota) {
                if(onibus.getAno_fabricacao() == ano_fabricacao)
                    res += "\n" + onibus.toString();                
            }
        return res;
    }
}