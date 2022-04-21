package dev.ruster.algo;

class DessinFractale {

    private final Turtle bob;
    private static final int LARGEUR = 800;
    private static final int HAUTEUR = 600;
    //taille de la fenetre graphique

    public DessinFractale() {
        bob = new Turtle();
        Turtle.setCanvasSize(LARGEUR, HAUTEUR);//à appeler APRES création de la tortue
    }

    public DessinFractale(int v) {
        //attention, plus v est grand, plus bob va lentement !
        this();
        bob.speed(v);
    }


    public void reset() {
        bob.clear();
        bob.up();
        bob.setPosition(0, 0);
        bob.setDirection(0);
        bob.down();
    }

    public void close() {
        Turtle.exit();
    }

    public void carre(double l) {
        for(int i = 0; i < 4; i++) {
            bob.forward(l);
            bob.left(90);
        }
    }

    public static void main(String[] args) {
//        DessinFractale d = new DessinFractale(500);
        Turtle t = new Turtle();
        // d.carre(90);
        // d.reset();
        // d.close();

        t.speed(100);
        t.setDirection(90);
        // t.vonKoch(900, 5);
        t.tree(100, 3);
    }
}