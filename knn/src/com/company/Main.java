package com.company;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
public class Main {
    static int k;
    static boolean dziala = true;
    static int rozmiar;

    public static void main(String[] args) {
        String testPath = "C:\\Users\\PC\\Desktop\\iris_test.txt";
        String trainPath = "C:\\Users\\PC\\Desktop\\iris_training.txt";
        List<String> list = new ArrayList<>();
        List<List<String>> iris_test = odczyt(testPath);
        List<List<String>> iris_training = odczyt(trainPath);
        List<String> stringArrayList = new ArrayList<>();

        System.out.println(" PODAJ K: ");
        Scanner scanner = new Scanner(System.in);
        k = scanner.nextInt();

        Map<String, Integer> stringIntegerMap;
        for (List<String> stringList : iris_test) {
            List<Data> insideList = new ArrayList<>();
            stringIntegerMap = new LinkedHashMap<>();
            String rodzajkwiatka;
            double kwadrat = 0.0;

            for (List<String> strings : iris_training) {
                for (int k = 0; k < stringList.size() - 1; k++) {
                    kwadrat += Math.abs(Math.pow((Double.parseDouble(stringList.get(k))) - (Double.parseDouble(strings.get(k))), 2));
                }
                rodzajkwiatka = strings.get(strings.size() - 1);
                Data data = new Data(rodzajkwiatka, kwadrat);
                insideList.add(data);
                kwadrat = 0.0;
            }

            stringIntegerMap = getmapa(stringIntegerMap, insideList);
            stringArrayList.addAll(stringIntegerMap.keySet());

            Data[] arr = null;
            boolean shuffle = false;
            List<Data> check;
            check = new ArrayList<>();
            stringIntegerMap.forEach((k, v) -> check.add(new Data(k, v)));
            if (check.size() >= 2) {
                int length = check.size();

                boolean[] booleans = new boolean[length];
                double val = check.get(0).getResult();
                for (int i = 0; i < check.size(); i++) {
                    booleans[i] = check.get(i).getResult() == val;
                }

                int i = 0;
                for (boolean value : booleans) {
                    if (value) {
                        i++;
                    }
                }
                if (i == booleans.length) {
                    shuffle = true;
                }

                //losowanie
                if (shuffle) {
                    List<Integer> randoms = new ArrayList<>();
                    for (int h = 0; h < booleans.length; h++) {
                        randoms.add(h);
                    }

                    List<Integer> rand = new ArrayList<>();
                    int length2 = randoms.size();
                    for (int h = 0; h < length2; h++) {
                        int n = (int) (Math.random() * randoms.size());
                        rand.add(randoms.get(n));
                        randoms.remove(n);
                    }
                    arr = new Data[rand.size()];

                    for (int j = 0; j < rand.size(); j++) {
                        arr[rand.get(j)] = new Data(check.get(j).getName(), check.get(j).getResult());
                    }
                }
            }
            if (shuffle) {
                String key = arr[0].getName();
                list.add(key);
            } else {
                Map.Entry<String, Integer> entry = stringIntegerMap.entrySet().iterator().next();
                String key = entry.getKey();
                list.add(key);
            }
        }

        int licznikdokladnosci = 0;
        for (int i = 0; i < list.size(); i++) {
            if (iris_test.get(i).get(iris_test.get(i).size() - 1).equals(list.get(i))) {
                licznikdokladnosci++;
            }

        }

        System.out.print("Dokładnosc to: " + licznikdokladnosci + "/" + list.size());
        System.out.println("  "+ ((double) licznikdokladnosci / list.size()) * 100 + "%");

        System.out.println();
        System.out.println("wpisz atrybuty lub napisz "+"koniec");


        Scanner scanner1 = new Scanner(System.in);
        String check = scanner1.nextLine();
        while (dziala) {
            if (check.equals("koniec")) {
                dziala = false;
            } else {
                String[] s = check.split("\\s+");
                if (s.length == (iris_test.get(0).size() - 1)) {
                    System.out.println(atrybuty(s, iris_training));

                    check = scanner1.nextLine();

                } else {
                    System.out.println("błędne wartości liczbowe");
                    check = scanner1.nextLine();
                }
            }
        }
    }

    private static Map<String, Integer> getmapa(Map<String, Integer> stringIntegerMap, List<Data> insideList) {
        insideList.sort(Comparator.comparing(Data::getResult).thenComparing(Data::getName));

        for (int j = 0; j < k; j++) {
            if (stringIntegerMap.containsKey(insideList.get(j).getName())) {
                String s = insideList.get(j).getName();
                int val = stringIntegerMap.get(s) + 1;
                stringIntegerMap.replace(s, val);
            } else {
                int c = 1;
                stringIntegerMap.put(insideList.get(j).getName(), c);
            }

        }
        stringIntegerMap = stringIntegerMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (s1, s2) -> s1, LinkedHashMap::new));
        return stringIntegerMap;
    }

    public static String atrybuty(String[] s, List<List<String>> trainList) {

        List<Double> insArrayList = new ArrayList<>();
        List<Data> checks = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        String nameString;
        double result = 0.0;

        for (String v : s) {
            insArrayList.add(Double.parseDouble(v));
        }

        for (List<String> strings : trainList) {
            for (int k = 0; k < insArrayList.size(); k++) {
                result += Math.abs(Math.pow((Double.parseDouble(strings.get(k))) - insArrayList.get(k), 2));
            }
            nameString = strings.get(strings.size() - 1);
            Data data = new Data(nameString, result);
            checks.add(data);
            result = 0.0;
        }
        map = getmapa(map, checks);

        return map.toString();
    }
    public static List odczyt(String path) {
        List<List<String>> myList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            try {
                String s;
                while ((s = bufferedReader.readLine()) != null) {
                    List<String> st = new ArrayList<>();
                    String[] toSplit = s.split("\\s+");
                    rozmiar = toSplit.length - 1;

                    for (int i = 1; i < toSplit.length; i++) {
                        String replacer = toSplit[i].replace(",", ".");
                        st.add(replacer);
                    }
                    myList.add(st);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            System.err.println("błedny path!");
            e.printStackTrace();
        }
        return myList;
    }

}
