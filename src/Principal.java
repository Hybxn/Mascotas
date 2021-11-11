public class Principal {

    private final double PESOMINIMO = 2;

    public static void main(String[] args) {

    }

    private Mascota generaMascota(String alias){
        return new Mascota(alias);
    }

    private void muestraMascota(Mascota mascota){
        System.out.println(mascota.toString());
        if (mascota.getPeso() < PESOMINIMO){
            System.out.printf("MASCOTA CON BAJO PESO (<%.2f)", PESOMINIMO);
        }
    }
}
