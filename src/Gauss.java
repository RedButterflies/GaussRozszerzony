
import java.util.Scanner;

import static java.lang.Math.round;

public class Gauss{


    public static void algorytm() {
        int wybor;
        Scanner wyborX = new Scanner(System.in);
        System.out.println("Wprowadz 1 any uzyc gotowych danych , 2 aby wprowadzic wlasne dane");
        wybor=wyborX.nextInt();
        if(wybor==2) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Wprowadz liczbe rownan: ");
            Scanner liczbaR = new Scanner(System.in);
            int liczbaRownan = liczbaR.nextInt();
            System.out.println("Wprowadz liczbe wspolczynnikow: ");
            Scanner liczbaW = new Scanner(System.in);
            int liczbaWspolcz = liczbaW.nextInt();
            double[][] A = new double[liczbaRownan][liczbaWspolcz];
            double[] b = new double[liczbaRownan];
            System.out.println("Wprowadz wspolczynniki rownan:");
            for (int i = 0; i < liczbaRownan; i++) {
                for (int j = 0; j < liczbaRownan; j++) {
                    System.out.println("Wprowadz wspolczynnik " + (j + 1) + " rowanania " + (i + 1) + ":");
                    A[i][j] = scanner.nextDouble();
                }
            }

            System.out.println("Wprowadz wyrazy wolne:");
            for (int i = 0; i < liczbaRownan; i++) {
                System.out.println("Wprowadz wyraz wolny rownania " + (i + 1) + " :");
                b[i] = scanner.nextDouble();
            }

            System.out.println();
            int N = b.length;

            for (int i = 0; i < N; i++) {
                // Znajdowanie elementu maksymalnego
                int max = i;
                for (int j = i + 1; j < N; j++) {
                    if (Math.abs(A[j][i]) > Math.abs(A[max][i])) {
                        max = j;
                    }
                }

                // Zamiana wierszy
                double[] temp = A[i];
                A[i] = A[max];
                A[max] = temp;
                double t = b[i];
                b[i] = b[max];
                b[max] = t;

                // Zerwoanie wierszy pod aktualna kolumna
                for (int j = i + 1; j < N; j++) {
                    double factor = A[j][i] / A[i][i];
                    b[j] -= factor * b[i];
                    for (int k = i; k < N; k++) {
                        A[j][k] -= factor * A[i][k];
                    }
                }
            }

            // Rozwiazanie trojkatnej macierzy
            double[] x = new double[N];
            for (int i = N - 1; i >= 0; i--) {
                double sum = 0.0;
                for (int j = i + 1; j < N; j++) {
                    sum += A[i][j] * x[j];
                }
                x[i] = (b[i] - sum) / A[i][i];
            }
            System.out.println("Rozwiazaniem ukladu jest wektor x=");
            System.out.print("[");
            for (int i = 0; i < liczbaRownan; i++) {
                if(i!=liczbaRownan-1)
                    System.out.print(round(x[i])+",");
                else
                    System.out.print(round(x[i]));
            }
            System.out.print("]^T");

        }
        if (wybor==1)
        {
            int liczbaRownan =5;
            int liczbaWspolcz = 5;
            double[][] A = new double[liczbaRownan][liczbaWspolcz];
            double[] b = new double[liczbaRownan];
            A[0][0]=14;
            A[0][1]=-13;
            A[0][2]=3;
            A[0][3]=-16;
            A[0][4]=-42;

            A[1][0]=3.5;
            A[1][1]=-18;
            A[1][2]=13;
            A[1][3]=-23.75;
            A[1][4]=-21;

            A[2][0]=3.5;
            A[2][1]=3;
            A[2][2]=-5.25;
            A[2][3]=9.25;
            A[2][4]=10.5;

            A[3][0]=2;
            A[3][1]=14.5;
            A[3][2]=-10.5;
            A[3][3]=18.5;
            A[3][4]=21;

            A[4][0]=1.5;
            A[4][1]=6.75;
            A[4][2]=-9.25;
            A[4][3]=17;
            A[4][4]=-10.5;

            b[0]=-37;
            b[1]=-5.5;
            b[2]=12.5;
            b[3]=23.5;
            b[4]=-45.25;

            System.out.println("Wspolczynniki rownan: ");
            for (double[] doubles : A) {
                for (int j = 0; j < A.length; j++) {
                    System.out.print(doubles[j] + " ");
                }
                System.out.println();
            }
            System.out.println("Wyrazy wolne: ");
            for (double v : b) {
                System.out.println(v);
            }
            System.out.println();
            int N = b.length;

            for (int i = 0; i < N; i++) {

                int max = i;
                for (int j = i + 1; j < N; j++) {
                    if (Math.abs(A[j][i]) > Math.abs(A[max][i])) {
                        max = j;
                    }
                }


                double[] temp = A[i];
                A[i] = A[max];
                A[max] = temp;
                double t = b[i];
                b[i] = b[max];
                b[max] = t;


                for (int j = i + 1; j < N; j++) {
                    double factor = A[j][i] / A[i][i];
                    b[j] -= factor * b[i];
                    for (int k = i; k < N; k++) {
                        A[j][k] -= factor * A[i][k];
                    }
                }
            }


            double[] x = new double[N];
            for (int i = N - 1; i >= 0; i--) {
                double sum = 0.0;
                for (int j = i + 1; j < N; j++) {
                    sum += A[i][j] * x[j];
                }
                x[i] = (b[i] - sum) / A[i][i];
            }
            System.out.println("Rozwiazaniem ukladu jest wektor x=");
            System.out.print("[");
            for (int i = 0; i < liczbaRownan; i++) {
                if(i!=liczbaRownan-1)
                System.out.print(round(x[i])+",");
                else
                    System.out.print(round(x[i]));
            }
            System.out.print("]^T");

        }

    }

}