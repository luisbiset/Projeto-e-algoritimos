package br.com.stefanini.Entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Utils {
    
    static String obterData() {
        String formato = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern(formato);
        LocalDateTime agora = LocalDateTime.now();
        return formatador.format(agora);
    }
}

