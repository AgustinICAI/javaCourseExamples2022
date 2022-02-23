public class RetoA {
    public static String crearArbol(int ancho, int pisos, String caracteres) {
        StringBuilder sb = new StringBuilder();
        for (int piso = 0; piso < pisos; piso++){
            for(int anc = 1; anc <= ancho+2*piso; anc++){
                sb.append(" ".repeat(2*pisos + ancho - anc -2)).append(caracteres.repeat(anc)).append("\n");
                //sb.append(String.format("%"+(2*pisos + anc + ancho -2)+"s%n",caracteres.repeat(anc)));
            }
        }
        return sb.toString();
    }
}
