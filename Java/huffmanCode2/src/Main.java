import java.io.*;
import java.util.StringTokenizer;

/**
 * @author 이상희
 */
public class Main {
    private HuffmanTree huffman;
    private AlphabetFrequencyTable aphabetFrequencyTable;
    private PriorityQueue priorityQueue;

    public static void main(String[] args) {
        new Main("data10.txt");// hw01
        System.out.println();
        System.out.println("==================================================================================================");
        System.out.println();
        new Main("data10_encoded.txt", "data10_table.txt");//hw02
    }

    public Main(String file, String table) {
        aphabetFrequencyTable = new AlphabetFrequencyTable();
        priorityQueue = new PriorityQueue();

        Alpha root = new Alpha();
        try {
            BufferedReader in = new BufferedReader(new FileReader(table));
            String line = in.readLine();
            while (line != null) {
                String[] c = line.split(",");
                makeTree(c, root);
                line = in.readLine();
            }
            in.close();

            in = new BufferedReader(new FileReader(file));
            line = in.readLine();

            System.out.println();
            HuffmanTree tree = new HuffmanTree(root);
            String decodedString = tree.decodeFromTree(line);
            writeStringToFile(decodedString,"hw08_01_201202160_decoded.txt");
            System.out.println("디코딩된 데이터");
            System.out.println(decodedString.toString());

            in.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void makeTree(String[] c, Alpha root) {
        char alpha = c[0].charAt(0);
        String encodedData = c[1];
        Alpha current = root;
        int i;
        for (i = 0; i < encodedData.length() - 1; i++) {
            if (encodedData.charAt(i) == '0') {
                if (current.left == null)
                    current.left = new Alpha();
                current = current.left;
            } else if (encodedData.charAt(i) == '1') {
                if (current.right == null)
                    current.right = new Alpha();
                current = current.right;
            }
        }
        if (encodedData.charAt(i) == '0') {
            if (current.left == null) {
                current.left = new Alpha(alpha);
            } else {
                current = current.left;
                current.alpha = alpha;
            }
        } else if (encodedData.charAt(i) == '1') {
            if (current.right == null) {
                current.right = new Alpha(alpha);
            } else {
                current = current.right;
                current.alpha = alpha;
            }
        }
    }


    public Main(String file) {
        aphabetFrequencyTable = new AlphabetFrequencyTable();
        priorityQueue = new PriorityQueue();
        StringBuffer TokenString = new StringBuffer();

        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line = in.readLine();
            while (line != null) {
                StringTokenizer parser = new StringTokenizer(line, " ");
                while (parser.hasMoreTokens()) {
                    String word = parser.nextToken().toLowerCase();
                    for (int i = 0; i < word.length(); i++) {
                        aphabetFrequencyTable.add(word.charAt(i));
                        TokenString.append(word.charAt(i));
                    }
                    if (parser.hasMoreTokens()) {
                        aphabetFrequencyTable.add(' ');
                        TokenString.append(' ');
                    }

                }
                line = in.readLine();
            }
            in.close();
            printHuffman(TokenString);

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * 메인 메서드에서 출력을 하기 위한 메서드
     *
     * @param deletedTokenString 토큰별로 잘라내어서 합친 문자열 값
     */
    private void printHuffman(StringBuffer deletedTokenString) {
        priorityQueue.addTable(aphabetFrequencyTable);
        huffman = new HuffmanTree(priorityQueue);

        System.out.println("허프만 트리의 테이블 \n[알파벳,인코딩]");
        String txt = huffman.printTree();
        String fileName = "hw08_01_201202160_table.txt";
        writeStringToFile(txt, fileName);

        StringBuffer encodedStringData = new StringBuffer();
        StringBuffer encodedStringData2 = new StringBuffer();
        for (int i = 0; i < deletedTokenString.length(); i++) {
            encodedStringData.append(huffman.encodeFromTree(deletedTokenString.charAt(i)));
            encodedStringData2.append(huffman.encodeFromTree(deletedTokenString.charAt(i)) + "|");
        }

        System.out.println();
        System.out.println("\n인코딩 데이터");
        System.out.println(encodedStringData.toString());
        writeStringToFile(encodedStringData.toString(), "hw08_01_201202160_encoded.txt");


    }

    private void writeStringToFile(String txt, String fileName) {
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, false));
            fw.write(txt);
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
