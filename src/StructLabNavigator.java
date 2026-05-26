import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class StructLabNavigator {
    private static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {
        printHeader();

        while (true) {
            printMenu();

            int choice = readIntInRange("Pilih menu: ", 1, 4);
            System.out.println();

            if (choice == 4) {
                System.out.println("Terima kasih. Program dihentikan.");
                break;
            }

            if (choice == 1) {
                runBreadthFirstDemo();
            } else if (choice == 2) {
                runDepthFirstDemo();
            } else if (choice == 3) {
                showGraphReference();
            }

            pauseBeforeNextMenu();
        }
    }

    private static void printHeader() {
        System.out.println("==============================================");
        System.out.println(" StructLab Navigator - Traversal CLI");
        System.out.println("==============================================");
        System.out.println("Aplikasi latihan struktur data berbasis console.");
        System.out.println();
    }

    private static void printMenu() {
        System.out.println("Menu Utama");
        System.out.println("1. Demo Breadth First Search (BFS)");
        System.out.println("2. Demo Depth First Search (DFS)");
        System.out.println("3. Lihat graph demo");
        System.out.println("4. Keluar");
        System.out.println();
    }

    private static void runBreadthFirstDemo() {
        Graph graph = buildBreadthFirstDemoGraph();
        int startVertex = readIntInRange("Masukkan vertex awal BFS (0-5): ", 0, graph.getVertexCount() - 1);

        System.out.println();
        System.out.println("Graph demo BFS:");
        graph.printAdjacencyList();
        System.out.println();

        List<Integer> traversalOrder = graph.breadthFirstTraversal(startVertex);

        System.out.println("Hasil BFS dari vertex " + startVertex + ":");
        printTraversalOrder(traversalOrder);
    }

    private static void runDepthFirstDemo() {
        Graph graph = buildDepthFirstDemoGraph();
        int startVertex = readIntInRange("Masukkan vertex awal DFS (0-7): ", 0, graph.getVertexCount() - 1);

        System.out.println();
        System.out.println("Graph demo DFS:");
        graph.printAdjacencyList();
        System.out.println();

        List<Integer> traversalOrder = graph.depthFirstTraversal(startVertex);

        System.out.println("Hasil DFS dari vertex " + startVertex + ":");
        printTraversalOrder(traversalOrder);
    }

    private static void showGraphReference() {
        System.out.println("Graph demo BFS memakai 6 vertex dengan edge berikut:");
        buildBreadthFirstDemoGraph().printAdjacencyList();
        System.out.println();
        System.out.println("Graph demo DFS memakai 8 vertex dengan edge berikut:");
        buildDepthFirstDemoGraph().printAdjacencyList();
    }

    private static void printTraversalOrder(List<Integer> traversalOrder) {
        for (int i = 0; i < traversalOrder.size(); i++) {
            if (i > 0) {
                System.out.print(" -> ");
            }
            System.out.print(traversalOrder.get(i));
        }
        System.out.println();
    }

    private static void pauseBeforeNextMenu() {
        System.out.println();
        System.out.print("Tekan Enter untuk kembali ke menu...");
        INPUT.nextLine();
        System.out.println();
    }

    private static int readIntInRange(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String text = INPUT.nextLine().trim();

            try {
                int value = Integer.parseInt(text);
                if (value < min || value > max) {
                    System.out.println("Input harus berada di antara " + min + " dan " + max + ".\n");
                    continue;
                }
                return value;
            } catch (NumberFormatException exception) {
                System.out.println("Input tidak valid. Masukkan angka bulat.\n");
            }
        }
    }

    private static Graph buildBreadthFirstDemoGraph() {
        Graph graph = new Graph(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(4, 5);
        graph.addEdge(3, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(2, 1);
        graph.addEdge(4, 1);
        graph.addEdge(3, 1);
        graph.addEdge(5, 4);
        graph.addEdge(5, 3);

        return graph;
    }

    private static Graph buildDepthFirstDemoGraph() {
        Graph graph = new Graph(8);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 7);
        graph.addEdge(4, 5);
        graph.addEdge(5, 2);

        return graph;
    }

    private static final class Graph {
        private final List<List<Integer>> adjacencyList;

        private Graph(int vertexCount) {
            adjacencyList = new ArrayList<List<Integer>>(vertexCount);
            for (int i = 0; i < vertexCount; i++) {
                adjacencyList.add(new LinkedList<Integer>());
            }
        }

        private int getVertexCount() {
            return adjacencyList.size();
        }

        private void addEdge(int source, int destination) {
            validateVertex(source);
            validateVertex(destination);
            adjacencyList.get(source).add(destination);
        }

        private List<Integer> breadthFirstTraversal(int startVertex) {
            validateVertex(startVertex);

            // BFS memakai queue agar vertex diproses per level.
            boolean[] visited = new boolean[getVertexCount()];
            Queue<Integer> queue = new LinkedList<Integer>();
            List<Integer> order = new ArrayList<Integer>();

            visited[startVertex] = true;
            queue.add(startVertex);

            while (!queue.isEmpty()) {
                int currentVertex = queue.poll();
                order.add(currentVertex);

                for (int neighbor : adjacencyList.get(currentVertex)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }

            return order;
        }

        private List<Integer> depthFirstTraversal(int startVertex) {
            validateVertex(startVertex);

            // DFS dipertahankan rekursif agar alurnya mudah dibaca untuk pembelajaran.
            boolean[] visited = new boolean[getVertexCount()];
            List<Integer> order = new ArrayList<Integer>();
            depthFirstTraversal(startVertex, visited, order);
            return order;
        }

        private void depthFirstTraversal(int currentVertex, boolean[] visited, List<Integer> order) {
            visited[currentVertex] = true;
            order.add(currentVertex);

            for (int neighbor : adjacencyList.get(currentVertex)) {
                if (!visited[neighbor]) {
                    depthFirstTraversal(neighbor, visited, order);
                }
            }
        }

        private void printAdjacencyList() {
            for (int vertex = 0; vertex < adjacencyList.size(); vertex++) {
                System.out.print(vertex + " -> ");
                List<Integer> neighbors = adjacencyList.get(vertex);

                if (neighbors.isEmpty()) {
                    System.out.println("-");
                    continue;
                }

                for (int index = 0; index < neighbors.size(); index++) {
                    System.out.print(neighbors.get(index));
                    if (index < neighbors.size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
        }

        private void validateVertex(int vertex) {
            if (vertex < 0 || vertex >= adjacencyList.size()) {
                throw new IllegalArgumentException("Vertex di luar jangkauan.");
            }
        }
    }
}