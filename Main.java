public class Main {
    public static int degree(int number, int degree){ //переменная степени
        int result = 1;
        for (int i = 1; i <= degree; i++) {
            result*=number;
        }
        return result;
    }
    public static int from_hex_to_dec(String number){ // перевод из шеснадцатеричной в десятиричную
        number = number.toUpperCase();
        String[] hexademical = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        char[] chars = number.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < hexademical.length; j++) {
                if (String.valueOf(chars[i]).equals(hexademical[j])){
                    result+=j*(degree(16,chars.length-i-1));
                }
            }
        }
        return result;
    }

    public static int to_eighth(int number, int system){ // перевод в восьмеричную
        number = to_decimal(number,system);
        int cycle = 0;
        int result = 0;
        while (cycle != -1){
            if (number != 0){
                result+=number%8*degree(system,cycle);
                number/=8;
                cycle+=1;
            }
            else{
                cycle=-1;
            }
        }
        return result;
    }


    public static String to_hexademical(int number, int system){ // перевод в шеснадцатеричную
        number = to_decimal(number, system);
        String[] hexademical = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        String result = "";
        boolean finished = false;
        while (!finished){
            if (number != 0){
                result+=hexademical[number%16];
                number/=16;
            }
            else{
                finished = true;
            }
        }
        return new StringBuilder(result).reverse().toString();
    }

    public static int to_decimal(int number, int system){ // преревод в десятичную
        int cycle = 0;
        int result = 0;
        while (cycle != -1){
            if (number != 0){
                result+=number%10*degree(system,cycle);
                number/=10;
                cycle+=1;
            }
            else{
                cycle=-1;
            }
        }
        return result;
    }

    public static int to_double(int number, int system){ // превод в двоичную
        number = to_decimal(number, system);
        int cycle = 0;
        int result = 0;
        while (cycle != -1){
            if (number != 0){
                result+=number%2*(degree(10,cycle));
                number/=2;
                cycle+=1;
            }
            else{
                cycle=-1;
            }
        }
        return result;
    }

    public static void main(String[] args) {    //перевод чисел в системы счисления
        int first = 721;
        System.out.printf("%d > %d > %d > %s\n",first,to_double(first, 8), to_decimal(to_double(first, 8),2), to_hexademical(to_decimal(to_double(first, 8),2),10));
        int second = 436;
        System.out.printf("%d > %d > %d > %s\n",second,to_double(second, 8), to_decimal(to_double(second, 8),2), to_hexademical(to_decimal(to_double(second, 8),2),10));
        int third = 327;
        System.out.printf("%d > %d > %d > %s\n",third,to_double(third, 8), to_decimal(to_double(third, 8),2), to_hexademical(to_decimal(to_double(third, 8),2),10));
        int fourth = 751;
        System.out.printf("%d > %d > %d > %s\n",fourth,to_double(fourth, 8), to_decimal(to_double(fourth, 8),2), to_hexademical(to_decimal(to_double(fourth, 8),2),10));
        int fifth = 154;
        System.out.printf("%d > %d > %d > %s\n",fifth,to_double(fifth, 8), to_decimal(to_double(fifth, 8),2), to_hexademical(to_decimal(to_double(fifth, 8),2),10));
        String sixth = "1D5";
        System.out.printf("%s > %d > %d > %d\n",sixth,(to_double(from_hex_to_dec(sixth),10)),(to_eighth(from_hex_to_dec(sixth),10)),from_hex_to_dec(sixth));
        String seventh = "9EA";
        System.out.printf("%s > %d > %d > %d\n",seventh,(to_double(from_hex_to_dec(seventh),10)),(to_eighth(from_hex_to_dec(seventh),10)),from_hex_to_dec(seventh));
        String eighth = "2CD";
        System.out.printf("%s > %d > %d > %d\n",eighth,(to_double(from_hex_to_dec(eighth),10)),(to_eighth(from_hex_to_dec(eighth),10)),from_hex_to_dec(eighth));
        String nineth = "2D8";
        System.out.printf("%s > %d > %d > %d\n",nineth,(to_double(from_hex_to_dec(nineth),10)),(to_eighth(from_hex_to_dec(nineth),10)),from_hex_to_dec(nineth));
        String decimal = "1D9";
        System.out.printf("%s > %d > %d > %d\n",decimal,(to_double(from_hex_to_dec(decimal),10)),(to_eighth(from_hex_to_dec(decimal),10)),from_hex_to_dec(decimal));
    }
}
