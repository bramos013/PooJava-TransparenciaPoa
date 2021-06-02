public class Onibus {

    private int prefixo;    
    private String empresa;
    private String placa;
    private String marca;
    private int ano_fabricacao;

    public Onibus(int prefixo, String empresa, String placa, String marca, int ano_fabricacao) {
        this.prefixo = prefixo;
        this.empresa = empresa;
        this.placa = placa;
        this.marca = marca;
        this.ano_fabricacao = ano_fabricacao;
    }

    public int getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(int prefixo) {
        this.prefixo = prefixo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno_fabricacao() {
        return ano_fabricacao;
    }

    public void setAno_fabricacao(int ano_fabricacao) {
        this.ano_fabricacao = ano_fabricacao;
    }

    @Override
    public String toString() {
        return "Onibus [Prefixo=" + prefixo + 
               "\tEmpresa=" + empresa + 
               "\tMarca=" + marca + 
               "\tPlaca=" + placa + 
               "\tAno Fabricação=" + ano_fabricacao + "]";
    }                
    
}
