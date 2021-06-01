import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException{    
        System.out.println(
            "      ______                                                       _        \n" +
            "     /_  __/________ _____  _________  ____ _________  ____  _____(_)___    \n" +
            "      / / / ___/ __ `/ __ |/ ___/ __ |/ __ `/ ___/ _ |/ __ |/ ___/ / __ |   \n" +
            "     / / / /  / /_/ / / / (__  ) /_/ / /_/ / /  /  __/ / / / /__/ / /_/ /   \n" +
            "    /_/ /_/   |__,_/_/ /_/____/ .___/|__,_/_/   |___/_/ /_/|___/_/|__,_/    \n" +
            "                             /_/                                            \n" +
            "                            _____  ___  ___                                 \n" +
            "                           / __  |/__ |/   |                                \n" +
            "                          / /_/ / / / / /| |                                \n" +
            "                         / ____/ /_/ / __  |                                \n" +
            "                        /_/    |____/_/  |_|                                \n");    
        System.out.print("\n\n");    
        Menu session = new Menu();
             session.inicializa();
        
    }
}