public class DadosAbertosException extends Exception{
    CarregaDados dados = new CarregaDados();

    public DadosAbertosException(String registro){
        if(registro == null){
            System.out.println("\t\tFalha nos dados Abertos");
        }
    }
    public DadosAbertosException(){
        System.err.println("\t\tNenhuma consulta realizada!");
    }
}
