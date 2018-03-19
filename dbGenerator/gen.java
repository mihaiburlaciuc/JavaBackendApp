class Main {
    public static void main(String[] args) {
        double priceD = 100.0;
        int price = 100;
        // number_of_activities = price % 3 + 1
        // start date price % 22 / price % 10 / 2017
        // end date price % 30 / price % 10 + d % 2 / 2017


        for (int a = 0; a < 2; a++) {
            for (int b = 0; b < 2; b++) {
                for (int c = 0; c < 2; c++) {
                    for (int d = 0; d < 2; d++) {
                        String info = "";
                        String country;
                        if (a == 0) {
                            country = "RO";
                        } else {
                            country = "BG";
                        }
                        info += country;
                        info += " " + country + "d" + b;
                        info += " " + country + "d" + b + "c" + c;
                        info += " " + country
                            + "d" + b + "c" + c + "p" + d;
                        info += " " + priceD;
                        if (c % 2 == 1) {
                            info += " " + 01 + "/"
                                    + 01 + "/2017";
                            info += " " + 07 + "/"
                                            + 01 + "/2017";
                        } else {
                            info += " " + 05 + "/"
                                    + 01 + "/2017";
                            info += " " + 25 + "/"
                                            + 01 + "/2017";
                        }
                        for (int e = 0; e < (price % 4) + 1 - a; e++) {
                            info += " activity" + e;
                        }
                        price -= 5;
                        priceD -= 5;
                        System.out.println(info);
                    }
                }
            }
        }
    }
}
