//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Membaca input dari console
//        3 Parameter : Hutang, Bunga, Jumlah Ansuran
        double hutang = 0;// Double.parseDouble(args[0]);
        float bunga = 0;// Float.parseFloat(args[1]);
        int jmlhCicilan = 0; //Integer.parseInt(args[2]);

        for (int i = 0; i < args.length; i++) {
            String[] split = args[i].split("=");
            switch (split[0]) {
                case "-h":
                    hutang = Double.parseDouble(split[1]);
                    break;
                case "-b":
                    bunga = Float.parseFloat(split[1]);
                    break;
                default:
                    jmlhCicilan = Integer.parseInt(split[1]);
                    break;
            }
        }
        System.out.println("Hutang\t\t= " + hutang);
        System.out.println("Bunga\t\t= " + bunga);
        System.out.println("Jmlh ansuran\t= " + jmlhCicilan);

//        Hitung jumlah total yang harus dibayar
        double totalBayar = hutang + (hutang * bunga / 100);
        System.out.println("+--------------------------------+");
        System.out.println("Yang harus dibayar: " + totalBayar);

//      Nominal yang dibayarkan tiap kali angsuran
        double angsuran = totalBayar / jmlhCicilan;

//        Angsuran ke- ?
        System.out.println("+--------------------------------------------+");
        System.out.println("| Angsuran ke- | Total Bayar  |     Sisa     |");
        System.out.println("+--------------------------------------------+");
        for (int i = 0; i < jmlhCicilan; i++) {
            int angsuranKe = i + 1;
            double sisa = totalBayar - (angsuran * angsuranKe);
            int pjgKrktrNomor = Integer.toString(angsuranKe).length();
            int pjgKrktrAngsuran = Double.toString(angsuran).length();
            int pjgKrktrSisa = Double.toString(sisa).length();

//        Tabel
            System.out.println("|" + getSpace(pjgKrktrNomor) + angsuranKe + "|" + getSpace(pjgKrktrAngsuran) + angsuran + "|" + getSpace(pjgKrktrSisa) + sisa + "|");
            System.out.println("+--------------------------------------------+");
        }

    }

    private static String getSpace(int pjgKarakter) {
        String space = "";
        for (int i = 0; i < 14 - pjgKarakter; i++) {
            space += " ";
        }
        return space;
    }
}
