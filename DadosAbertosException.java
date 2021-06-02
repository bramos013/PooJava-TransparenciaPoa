public class DadosAbertosException extends Exception{
    
    public DadosAbertosException(String registro){
        if(registro == null){
            System.out.println("\t\tFalha nos dados Abertos");
        }
    }
}
