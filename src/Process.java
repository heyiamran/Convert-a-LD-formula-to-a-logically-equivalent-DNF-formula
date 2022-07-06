// Zhuoran Bi 20217231
public class Process {
    static String a = "A", b = "B", c = "C", d = "D", e = "E", g = "G", h = "H", j = "J", k = "K", l = "L";

    public static String preProcess(String str) {
        boolean flag = true;
        int cur = 0;
        int countE = 0;
        while (flag) {
            flag = false;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != 'T' || str.charAt(i) != 'F') {
                    if (str.charAt(i) == '(') {
                        int tempBegin = i;
                        int tempEnd = i;
                        while (str.charAt(tempBegin) != ' ') {
                            tempBegin--;
                        }
                        while (str.charAt(tempEnd) != ' ') {
                            tempEnd++;
                        }
                        int indexOfBegin = tempBegin + 1;
                        int indexOfEnd = tempEnd;
                        String str1 = str.substring(indexOfBegin, indexOfEnd);
                        if (str1 == a) {
                            str = str.replace(str1, "A");
                        } else if (str1 == b) {
                            str = str.replace(str1, "B");
                        } else if (str1 == c) {
                            str = str.replace(str1, "C");
                        } else if (str1 == d) {
                            str = str.replace(str1, "D");
                        } else if (str1 == e) {
                            str = str.replace(str1, "E");
                        } else if (str1 == g) {
                            str = str.replace(str1, "G");
                        } else if (str1 == h) {
                            str = str.replace(str1, "H");
                        } else if (str1 == j) {
                            str = str.replace(str1, "J");
                        } else if (str1 == k) {
                            str = str.replace(str1, "K");
                        } else if (str1 == l) {
                            str = str.replace(str1, "L");
                        } else {
                            if (countE == 0) {
                                a = str1;
                                str = str.replace(str1, "A");
                                countE++;
                            } else if (countE == 1) {
                                b = str1;
                                str = str.replace(str1, "B");
                                countE++;
                            } else if (countE == 2) {
                                c = str1;
                                str = str.replace(str1, "C");
                                countE++;
                            } else if (countE == 3) {
                                d = str1;
                                str = str.replace(str1, "D");
                                countE++;
                            } else if (countE == 4) {
                                e = str1;
                                str = str.replace(str1, "E");
                                countE++;
                            } else if (countE == 5) {
                                e = str1;
                                str = str.replace(str1, "G");
                                countE++;
                            } else if (countE == 6) {
                                e = str1;
                                str = str.replace(str1, "H");
                                countE++;
                            } else if (countE == 7) {
                                e = str1;
                                str = str.replace(str1, "j");
                                countE++;
                            } else if (countE == 8) {
                                e = str1;
                                str = str.replace(str1, "K");
                                countE++;
                            } else if (countE == 9) {
                                e = str1;
                                str = str.replace(str1, "L");
                                countE++;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '>') { // we will replaced -> as -
                    //delete '>'
                    String str1 = str.substring(0, i);
                    String str2 = str.substring(i + 1, str.length());
                    str = str1.concat(str2);
                }
            }
        }
        str = str.replace(" ", "");
        return str;
    }

    static String postProcess(String str) {
        StringBuilder sb = new StringBuilder(str);
        String space = " ";
        String lb = "[";
        String rb = "]";

        if (str.length() > 2) {
            for (int i = 0; i < str.length(); i++) {
                if (Operators.isABCDE(str.charAt(i)) && str.charAt(i - 1) == '~') {
                    sb.insert(i, space);
                    sb.insert(i, lb);
                    i = i + 2;
                    sb.insert(i + 1, rb);
                    sb.insert(i + 1, space);
                    i = i + 2;
                    str = sb.toString();
                }
            }


            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '~') {
                    sb.insert(i + 1, space);
                    i = i + 1;
                    str = sb.toString();
                }
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'A') {
                String str1 = str.substring(0, i);
                String str2 = str.substring(i + 1, str.length());
                str = str1.concat(a);
                str = str.concat(str2);
                while (str.charAt(i) != ')') {
                    i++;
                }
            } else if (str.charAt(i) == 'B') {
                String str1 = str.substring(0, i);
                String str2 = str.substring(i + 1, str.length());
                str = str1.concat(b);
                str = str.concat(str2);
                while (str.charAt(i) != ')') {
                    i++;
                }
            } else if (str.charAt(i) == 'C') {
                String str1 = str.substring(0, i);
                String str2 = str.substring(i + 1, str.length());
                str = str1.concat(c);
                str = str.concat(str2);
                while (str.charAt(i) != ')') {
                    i++;
                }
            } else if (str.charAt(i) == 'D') {
                String str1 = str.substring(0, i);
                String str2 = str.substring(i + 1, str.length());
                str = str1.concat(d);
                str = str.concat(str2);
                while (str.charAt(i) != ')') {
                    i++;
                }
            } else if (str.charAt(i) == 'E') {
                String str1 = str.substring(0, i);
                String str2 = str.substring(i + 1, str.length());
                str = str1.concat(e);
                str = str.concat(str2);
                while (str.charAt(i) != ')') {
                    i++;
                }
            } else if (str.charAt(i) == 'G') {
                String str1 = str.substring(0, i);
                String str2 = str.substring(i + 1, str.length());
                str = str1.concat(g);
                str = str.concat(str2);
                while (str.charAt(i) != ')') {
                    i++;
                }
            } else if (str.charAt(i) == 'H') {
                String str1 = str.substring(0, i);
                String str2 = str.substring(i + 1, str.length());
                str = str1.concat(h);
                str = str.concat(str2);
                while (str.charAt(i) != ')') {
                    i++;
                }
            } else if (str.charAt(i) == 'J') {
                String str1 = str.substring(0, i);
                String str2 = str.substring(i + 1, str.length());
                str = str1.concat(j);
                str = str.concat(str2);
                while (str.charAt(i) != ')') {
                    i++;
                }
            } else if (str.charAt(i) == 'K') {
                String str1 = str.substring(0, i);
                String str2 = str.substring(i + 1, str.length());
                str = str1.concat(k);
                str = str.concat(str2);
                while (str.charAt(i) != ')') {
                    i++;
                }
            } else if (str.charAt(i) == 'L') {
                String str1 = str.substring(0, i);
                String str2 = str.substring(i + 1, str.length());
                str = str1.concat(l);
                str = str.concat(str2);
                while (str.charAt(i) != ')') {
                    i++;
                }
            }
        }
        return str;
    }
}
