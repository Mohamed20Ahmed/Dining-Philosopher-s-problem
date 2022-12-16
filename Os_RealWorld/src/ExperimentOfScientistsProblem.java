public class ExperimentOfScientistsProblem {
    public static void main(String[] args) {
        Tools[] Microscope = new Tools[2];
        Tools[] PC = new Tools[2];
        Scientist[] Scientist = new Scientist[4];

        for (int i = 0; i < 2; i++) {
            Microscope[i] = new Tools(i);
            PC[i] = new Tools(i);
        }
        Scientist[0] = new Scientist(PC[0], Microscope[0],  1,  1,  1);
        Scientist[0].start();
        Scientist[1] = new Scientist(PC[1], Microscope[0],  2,  2,  1);
        Scientist[1].start();
        Scientist[2] = new Scientist(PC[1], Microscope[1],  3,  2,  2);
        Scientist[2].start();
        Scientist[3] = new Scientist(PC[0], Microscope[1],  4,  1,  2);
        Scientist[3].start();

    }
}