public class Mascota {

    private String alias; //Obligatorio && length >= 3.
    private String colorPelo; //Obligatorio (AZUL, BLANCO, NEGRO, ROJO).
    private double peso; //Obligatorio && >= 0.

    public Mascota(String alias) {
        setAlias(alias);
        setColorPelo(generaColor());
        setPeso(generaPeso());
    }

    public Mascota(String alias, String colorPelo, double peso) {
        setAlias(alias);
        setColorPelo(colorPelo);
        setPeso(peso);
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        //Obligatorio && length >= 3.
        assert alias != null;
        this.alias = alias;
    }

    public String getColorPelo() {
        return colorPelo;
    }

    public void setColorPelo(String colorPelo) {
        //Obligatorio (AZUL, BLANCO, NEGRO, ROJO).

        if (colorPelo == null)
            System.err.println("Error el color de pelo no puede ser nulo.");
        else if (colorPelo.isEmpty())
            System.err.println("Error el color de pelo no puede una cadena vacia.");
        else if (colorPelo.isBlank())
            System.err.println("Error el color de pelo no puede una cadena de espacios en blanco.");
        else if (
                !(colorPelo.equalsIgnoreCase("AZUL") ||
                        colorPelo.equalsIgnoreCase("BLANCO") ||
                        colorPelo.equalsIgnoreCase("NEGRO") ||
                        colorPelo.equalsIgnoreCase("ROJO"))
        )
            System.err.println("Color de pelo invalido, el color debe ser AZUL, BLANCO, NEGRO O ROJO.");

        assert colorPelo != null;
        this.colorPelo = colorPelo.toUpperCase();
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        //Obligatorio && >= 0.
        assert peso >= 0 : "Error el peso debe ser mayor o igual a 0.";
        this.peso = peso;
    }

    public String toString() {
        return String.format("Alias -> %s,\n Color de pelo -> %s, peso %.2f",
                getAlias(), getColorPelo(), getPeso());
    }

    private String generaColor() {
        switch ((int) (Math.random() * 4)) {
            case 0:
                return "AZUL";
            case 1:
                return "BLANCO";
            case 2:
                return "NEGRO";
            default:
                return "ROJO";
        }
    }

    private double generaPeso() {
        return Math.random() * 50;
    }

    private boolean checkAlias(String alias) {
        if (alias == null) {
            System.err.println("Error el alias no puede ser null.");
            return false;
        } else if (alias.isEmpty()) {
            System.err.println("Error el alias no puede ser una cadena vacia.");
            return false;
        } else if (alias.isBlank()) {
            System.err.println("Error el alias no puede ser una cadena de espacios en blanco.");
            return false;
        } else if (alias.length() < 3) {
            System.err.printf("Error, el alias debe tener una longitud minima de 3 caracteres.\n" +
                    "Longitud actual %d", alias.length());
            return false;
        }
        return true;
    }
}
