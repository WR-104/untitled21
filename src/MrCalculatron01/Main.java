package MrCalculatron01;

class Main {
    static Convertron convert = new Convertron();
    static String[] impl = {"+", "-", "/", "*"};
    static String[] implSplit = {"\\+", "-", "/", "\\*"};
    static int rES;
    static String result;
    public static String calc(String input) {

        int fate = -1;

        for (int i = 0; i < impl.length; i++) {
            if (input.contains(impl[i])) {
                fate = i;
                break;
            }
        }
        if (fate == -1) {
            System.out.println("Неверно введено выражение.");
            System.exit(0);
        }

        String[] chis = input.split(implSplit[fate]);
        for (int i = 0; i < impl.length; i++) {
            if (chis.length >2||chis.length >2||chis[0].contains(impl[i])||chis[1].contains(impl[i])) {
                System.out.println("Выражение должно состоять из 2х переменных от 1 до 10 и 1 оператора.");
                System.exit(0);
            }
        }

        if (convert.isRoman(chis[0]) == convert.isRoman(chis[1])) {
            int x, y;

            boolean isRoman = convert.isRoman(chis[0]);

            if (isRoman) {

                x = convert.vA(chis[0]);
                y = convert.vA(chis[1]);
                if (x>10||x<1||y>10||y<1){
                    System.out.println("Переменные строго от 1 до 10");
                    System.exit(0);
                }
                switch (impl[fate]) {
                    case "+":
                        rES = x + y;

                        result = convert.vR(rES);
                        break;
                    case "-":
                        rES = x - y;
                        result = convert.vR(rES);
                        break;
                    case "*":
                        rES = x * y;
                        result = convert.vR(rES);
                        break;
                    case "/":
                        rES = x / y;
                        result = convert.vR(rES);
                        break;
                }


            } else {
                x = Integer.parseInt(chis[0]);
                y = Integer.parseInt(chis[1]);
                if (x>10||x<1||y>10||y<1){
                    System.out.println("Переменные строго от 1 до 10");
                    System.exit(0);
                }

                switch (impl[fate]) {
                    case "+":
                        rES= x + y;

                        result = Integer.toString(rES);
                        break;
                    case "-":
                        rES = x - y;
                        result = Integer.toString(rES);
                        break;
                    case "*":
                        rES = x * y;
                        result = Integer.toString(rES);
                        break;
                    case "/":
                        rES = x / y;
                        result = Integer.toString(rES);
                        break;
                }

            }

        }else{
            System.out.println("Числа должны находиться в 1 системе счисления)");
            System.exit(0);
        }
        System.out.println("о т в е т : " + result);
        return result;
    }
}